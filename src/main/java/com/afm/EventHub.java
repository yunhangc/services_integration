package com.afm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by rchen on 2/17/16.
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class EventHub {
    public static void main(String[] args) {
        SpringApplication.run(EventHub.class, args);
    }
}
