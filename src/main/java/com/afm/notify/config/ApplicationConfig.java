package com.afm.notify.config;

import com.afm.notify.processor.EventProcessor;
import com.afm.notify.services.ConsumerManager;
import com.afm.notify.services.SubscriptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by rchen on 3/10/16.
 */
@Configuration
public class ApplicationConfig {

    @Autowired
    SubscriptionManager subscriptionManager;

    @Autowired
    ConsumerManager consumerManager;

    @Bean
    EventProcessor processor() {
        return new EventProcessor(subscriptionManager, consumerManager);
    }

}
