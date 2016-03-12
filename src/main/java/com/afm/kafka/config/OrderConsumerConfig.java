package com.afm.kafka.config;

import com.afm.notify.processor.EventProcessor;
import com.afm.notify.domain.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by rchen on 3/9/16.
 */
@Configuration
@Profile({"default","integration"})
public class OrderConsumerConfig extends KafkaConsumerConfig {

    @Autowired
    EventProcessor processor;

    @PostConstruct
    public void init() {
        this.topic = "orders";
        this.groupId = "orders_group";
        this.eventProcessor = processor;
    }

}
