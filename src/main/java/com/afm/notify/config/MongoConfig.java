package com.afm.notify.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by rchen on 2/18/16.
 */

@Configuration
class MongoConfig {

    public @Bean
    Mongo mongo() throws Exception {
        return new MongoClient("mongo");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "notify");
    }

}