package com.afm.notify.controllers;

import com.afm.notify.domain.Consumer;
import com.afm.notify.services.ConsumerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by rchen on 2/20/16.
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerManager manager;

    @RequestMapping(value = "/{id}/topic/{topic}", method = RequestMethod.PUT)
    Consumer saveConsumer(@RequestBody String url, @PathVariable String id, @PathVariable String topic) {
       return manager.saveConsumer(id,topic, url);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    String deleteConsumer(@PathVariable String id) {
        manager.removeConsumer(id);
        return "Consumer Id: " + id + " Removed";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Consumer getConsumer(@PathVariable String id) {
        return manager.getConsumer(id);
    }
}
