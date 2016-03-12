package com.afm.notify.services;

import com.afm.notify.domain.Subscription;
import org.springframework.stereotype.Service;

/**
 * Created by rchen on 2/18/16.
 */
@Service
public interface SubscriptionManager {
    public void removeConsumerSubscription(String subscriptionId, String consumerId);
    public Subscription saveSubscritption(String subscriptionId, String consumerId, String callbackUrl);
    public Subscription getSubscription(String subscriptionId);
}
