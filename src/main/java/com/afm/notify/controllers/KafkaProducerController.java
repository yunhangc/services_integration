package com.afm.notify.controllers;

import com.afm.kafka.producer.KafkaService;
import com.afm.kafka.producer.KafkaServiceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rchen on 3/6/16.
 */
@RestController
@RequestMapping("/kafka/{topic}")
public class KafkaProducerController {

    @Autowired
    KafkaServiceBuilder builder;

    @RequestMapping(value = "/key/{key}", method = RequestMethod.POST)
    public void sendToKafka(@PathVariable String topic, @PathVariable String key, @RequestBody Object value) {
        KafkaService service = builder.build();
        service.sendMessage(topic, key, value);
    }


}
