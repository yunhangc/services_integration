package com.afm.notify.processor;

import com.afm.domain.KafkaObject;
import com.afm.notify.clients.NotificationClient;
import com.afm.notify.clients.NotificationCommand;
import com.afm.notify.domain.Service;
import com.afm.notify.domain.Subscription;
import com.afm.notify.services.ConsumerManager;
import com.afm.notify.services.SubscriptionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rchen on 2/17/16.
 */
public class EventProcessor {

    private Logger log = LoggerFactory.getLogger(EventProcessor.class);

    private SubscriptionManager subscriptionManager;
    private ConsumerManager consumerManager;

    public EventProcessor(SubscriptionManager subscriptionManager, ConsumerManager consumerManager) {
        this.subscriptionManager = subscriptionManager;
        this.consumerManager = consumerManager;
    }

    public void process(KafkaObject ko) {
        String subscriptionId = ko.getSubscriptionId();
        Subscription subscription = subscriptionManager.getSubscription(subscriptionId);
        if (subscription == null) {
            log.error("subscription with id: {} not found.", subscriptionId);
        }
        for (Service service : subscription.getServices()) {
            NotificationClient client = consumerManager.getClient(service.getName());
            NotificationCommand command = new NotificationCommand();
            if (client != null) {
                log.info("calling remote api for consumer={}, subscription={}", service.getName(), subscriptionId);
                command.doRequest(client, service.getCallBack(), ko.getValue());
            } else {
                log.error("invalid consumer {}.", service.getName());
            }
        }

        log.info("processing " + subscription.getSubscriptionId());
    }
}
