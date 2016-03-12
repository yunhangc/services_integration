package com.afm.notify.controllers;

import com.afm.notify.domain.Subscription;
import com.afm.notify.exceptions.ConsumerSubscriptionNotFoundException;
import com.afm.notify.exceptions.ResourceNotFoundException;
import com.afm.notify.services.SubscriptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rchen on 3/3/16.
 */
@RestController
@RequestMapping("/subscription/{consumer}")
public class SubscriptionController {

    @Autowired
    private SubscriptionManager subscriptionManager;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Subscription getUserSubscription(@PathVariable String userId) {
        try {
            return subscriptionManager.getSubscription(userId);
        } catch (ConsumerSubscriptionNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public void removeConsumerSubscription(@PathVariable String consumer, @PathVariable String userId) {
        subscriptionManager.removeConsumerSubscription(userId, consumer);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.POST)
    public Subscription addConsumerSubscription(@PathVariable String consumer, @PathVariable String userId
            , @RequestBody String callbackUrl ) {
        return subscriptionManager.saveSubscritption(userId, consumer, callbackUrl);
    }
}
