package com.afm.kafka.producer;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Future;

/**
 * Created by rchen on 3/6/16.
 */

public class KafkaService {

    private Logger log = LoggerFactory.getLogger(KafkaService.class);

    Producer<String, String> producer;
    private Gson gson = new Gson();

    public KafkaService(Producer<String, String> producer) {
        this.producer = producer;
    }

    boolean isEnabled() {
        return producer != null;
    }

    public Future<RecordMetadata> sendMessage(String topicName, String key, Object value) {
        if (!isEnabled()) {
            log.error("Brokers are not set. Will not send message");
            return null;
        }

        return producer.send(new ProducerRecord<String, String>(topicName, key, getJsonMessage(value, topicName)));
    }

    private String getJsonMessage(Object value, String topicName) {
        String message = gson.toJson(value);
        log.info("Sending message {} to {} topic", message, topicName);
        return message;
    }
}
