package com.afm.notify.services;

import com.afm.notify.clients.NotificationClient;
import com.afm.notify.domain.Consumer;
import com.afm.notify.repositories.ConsumerRepository;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rchen on 2/19/16.
 */
@Service
public class ConsumerManagerImpl implements ConsumerManager {

    @Autowired
    ConsumerRepository repository;

    @Override
    public Consumer getConsumer(String id) {
        return repository.getConsumer(id);
    }

    @Override
    public Consumer saveConsumer(String id, String topic, String url) {
        return repository.saveConsumer(id, topic, url);
    }

    @Override
    public void removeConsumer(String id) {
        repository.removeConsumer(id);
    }

    @Override
    public NotificationClient getClient(String id) {
        Consumer c = getConsumer(id);
        if( c != null ){
            return Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder())
                    .target(NotificationClient.class, c.getUrl() );
        }
        return null;
    }
}
