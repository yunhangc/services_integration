package com.afm.notify.repositories;

import com.afm.notify.domain.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by rchen on 2/18/16.
 */
@Repository
public class ConsumerRepository {

    @Autowired
    MongoTemplate mongo;

    public Consumer saveConsumer(String id, String topic, String url) {
        Consumer consumer = new Consumer(id, topic, url);
        mongo.save(consumer);
        return consumer;
    }

    public Consumer getConsumer(String id) {
        return mongo.findById(id, Consumer.class);
    }

    public void removeConsumer(String id) {
        mongo.remove(query(where("_id").is(id)), Consumer.class);
    }

}
