package com.afm.notify.repositories;

import com.afm.notify.domain.Consumer;
import com.afm.notify.domain.Service;
import com.afm.notify.domain.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by rchen on 2/18/16.
 */
@Repository
public class SubscriptionRepository {

    @Autowired
    private MongoTemplate mongo;

    @Autowired
    private ConsumerRepository consumerRepository;

    public Subscription getSubscription(String subscriptionId) {
        return mongo.findById(subscriptionId, Subscription.class);
    }

    public Subscription saveSubscription(String subscriptionId, String consumerId, String callbackUrl) {
        Subscription subscription = getSubscription(subscriptionId);

        if (subscription == null) {
            subscription = new Subscription(subscriptionId, new ArrayList<Service>());
        }

        Service service = getExistingService(subscription, consumerId);

        if (service == null) {
            service = new Service(consumerId, callbackUrl);
            subscription.getServices().add(service);
        } else {
            //update the callback url
            service.setCallBack(callbackUrl);
        }
        mongo.save(subscription);
        return subscription;
    }

    public void deleteSubscription(String subscriptionId) {
        mongo.remove(query(where("_id").is(subscriptionId)), Subscription.class);
    }

    public void removeService(Subscription subscription, String serviceName) {
        Service service = getExistingService(subscription, serviceName);
        if (service != null) {
            List<Service> services = subscription.getServices();
            services.remove(service);
            subscription.setServices(services);
            if (subscription.getServices().size() == 0) {
                mongo.remove(subscription);
            } else {
                mongo.save(subscription);
            }
        }
    }

    private Service getExistingService(Subscription subscription, String name) {
        List<Service> services = subscription.getServices();
        for (Service service : services) {
            if (service.getName().equals(name)) {
                return service;
            }
        }
        return null;
    }

}
