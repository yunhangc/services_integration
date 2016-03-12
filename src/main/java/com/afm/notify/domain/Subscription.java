package com.afm.notify.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.List;

/**
 * Created by rchen on 2/17/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Subscription {

    //restaurant id in our case
    @Id
    String subscriptionId;
    List<Service> services;

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Subscription(String subscriptionId, List<Service> services) {
        this.subscriptionId = subscriptionId;
        this.services = services;
    }





}
