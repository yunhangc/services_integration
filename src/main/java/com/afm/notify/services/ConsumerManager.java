package com.afm.notify.services;

import com.afm.notify.clients.NotificationClient;
import com.afm.notify.domain.Consumer;
import org.springframework.stereotype.Service;

/**
 * Created by rchen on 2/18/16.
 */
@Service
public interface ConsumerManager {

    Consumer getConsumer(String id);
    Consumer saveConsumer(String id, String topic, String url);
    void removeConsumer(String id);
    NotificationClient getClient(String id);

}
