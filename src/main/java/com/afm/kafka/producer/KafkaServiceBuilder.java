package com.afm.kafka.producer;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rchen on 3/6/16.
 */
@Service
public class KafkaServiceBuilder {

    private Logger log = LoggerFactory.getLogger(KafkaServiceBuilder.class);

    Producer<String, String> notifyProducer;
//    String brokers = "kafka";
    String brokers = "192.168.99.100:9092";

    private static final String DEFAULT_RECONNECT_BACKOFF_MS = "10000";
    private static final String DEFAULT_RETRY_BACKOFF_MS = "10000";
    private static final String DEFAULT_RETRIES = "3";
    private static final String DEFAULT_BUFFER_MEMORY = "33554432";
    private static final String DEFAULT_BLOCK_ON_BUFFER_FULL = "false";
    private static final String DEFAULT_TIMEOUT_MS = "1000";
    private static final String DEFAULT_METADATA_FETCH_TIMEOUT_MS = "1000";
    private static final String DEFAULT_ACKS = "1";

    public KafkaService build() {
        return new KafkaService(getProducer());

    }

    Producer<String, String> getProducer() {
        if (notifyProducer == null) {
            StringSerializer serializer = new StringSerializer();
            Map<String, String> configs = new HashMap<>();
            configs.put("bootstrap.servers", brokers);
            configs.put("reconnect.backoff.ms", DEFAULT_RECONNECT_BACKOFF_MS);
            configs.put("retry.backoff.ms", DEFAULT_RETRY_BACKOFF_MS);
            configs.put("reties", DEFAULT_RETRIES);
            configs.put("buffer.memory", DEFAULT_BUFFER_MEMORY);
            configs.put("block.on.buffer.full", DEFAULT_BLOCK_ON_BUFFER_FULL);
            configs.put("timeout.ms", DEFAULT_TIMEOUT_MS);
            configs.put("metadata.fetch.timeout.ms", DEFAULT_METADATA_FETCH_TIMEOUT_MS);
            configs.put("acks", DEFAULT_ACKS);
            notifyProducer = new KafkaProducer(configs, serializer, serializer);

        }
        return notifyProducer;
    }


}
