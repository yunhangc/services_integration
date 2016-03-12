package com.afm.kafka;

import com.afm.notify.processor.EventProcessor;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rchen on 2/17/16.
 */
public class EventConsumerRunner {

    private Logger log = LoggerFactory.getLogger(EventConsumerRunner.class);

    private final ConsumerConnector consumer;
    private final String topic;
    private EventProcessor processor;
//    private Class eventClass;
    private ExecutorService executor;


    public EventConsumerRunner(final String zookeeper, final String groupId, final String topic
            , EventProcessor processor) {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", zookeeper);
        properties.put("group.id", groupId);
        properties.put("zookeeper.session.timout.ms", "6000");
        properties.put("zookeeper.sync.tim.ms", "200");
        properties.put("auto.commit.interval.ms", "1000");

        this.consumer = kafka.consumer.Consumer
                .createJavaConsumerConnector(new ConsumerConfig(properties));
        this.topic = topic;
        this.processor = processor;
    }

    public void shutdown() {
        if (consumer != null) consumer.shutdown();
        if (executor != null) executor.shutdown();

        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                log.warn("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            log.error("Interrupted during shutdown, exiting uncleanly");
        }
    }

    public void run(final Integer numberThreads) {
        Map<String, Integer> topicCountMap = new HashMap() {{ put(topic, numberThreads);}};
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap
                = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
        executor = Executors.newFixedThreadPool(numberThreads);
        for(final KafkaStream stream : streams) {
            executor.submit(new ConsumerThread(stream, processor));
        }
    }

}

