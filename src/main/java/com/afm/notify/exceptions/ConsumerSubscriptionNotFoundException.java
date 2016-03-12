package com.afm.notify.exceptions;

/**
 * Created by rchen on 2/19/16.
 */
public class ConsumerSubscriptionNotFoundException extends RuntimeException {
    static final String PARTIAL_MESSAGE = " not found in subscription.";

    public ConsumerSubscriptionNotFoundException(String object) {
        super(object + PARTIAL_MESSAGE);
    }
}
