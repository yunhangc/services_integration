package com.afm.kafka.config;

import com.afm.kafka.EventConsumerRunner;
import com.afm.notify.processor.EventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * Created by rchen on 2/18/16.
 */
public abstract class KafkaConsumerConfig {

    private Logger log = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    private static final String zookeeperAddress = "192.168.99.100:2181";

    EventProcessor eventProcessor;
    String topic;
    String groupId;

    @Bean(destroyMethod = "shutdown")
    public EventConsumerRunner consumer() {
        log.info("Starting Consumer... zookeeper address: {}, topic: {}, groupId: {}"
                ,zookeeperAddress, topic, groupId);
        Integer threads = 1;
        EventConsumerRunner consumer = new EventConsumerRunner(
                zookeeperAddress, groupId, topic, eventProcessor);
        consumer.run(threads);

        return consumer;
    }

}

