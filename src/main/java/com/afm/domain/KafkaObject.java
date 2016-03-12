package com.afm.domain;

/**
 * Created by rchen on 3/10/16.
 */
public class KafkaObject {

    private String subscriptionId;
    private Object value;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}
