package com.afm.notify.services;

import com.afm.notify.domain.Subscription;
import com.afm.notify.exceptions.ConsumerSubscriptionNotFoundException;
import com.afm.notify.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rchen on 2/19/16.
 */
@Service
public class SubscriptionManagerImpl implements SubscriptionManager {

    @Autowired
    private SubscriptionRepository repository;

    @Override
    public void removeConsumerSubscription(String subscriptionId, String consumerId) {
        Subscription subscription = repository.getSubscription(subscriptionId);

        if (subscription == null) {
            throw new ConsumerSubscriptionNotFoundException(subscriptionId);
        }

        repository.removeService(subscription, consumerId);
    }

    @Override
    public Subscription saveSubscritption(String subscriptionId, String consumerId, String callbackUrl) {
        return repository.saveSubscription(subscriptionId, consumerId, callbackUrl);
    }

    @Override
    public Subscription getSubscription(String subscriptionId) {
        return repository.getSubscription(subscriptionId);
    }
}
