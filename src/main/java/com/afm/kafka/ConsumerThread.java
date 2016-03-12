package com.afm.kafka;

import com.afm.domain.KafkaObject;
import com.afm.notify.processor.EventProcessor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rchen on 2/17/16.
 */
public class ConsumerThread implements Runnable {

    private Logger log = LoggerFactory.getLogger(ConsumerThread.class);

    private KafkaStream stream;
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'hh:mm:ssZ").create();
    private EventProcessor processor;

    public ConsumerThread(KafkaStream stream, EventProcessor processor) {
        this.stream = stream;
        this.processor = processor;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
        while (iterator.hasNext()) {
            String eventMsg = new String(iterator.next().message());
            log.info("The Message To Process: " + eventMsg);
            try {
                processor.process(gson.fromJson(eventMsg, KafkaObject.class));
            } catch (Exception ex) {
                log.error("Failed To Process Message: " + eventMsg);
                ex.printStackTrace();
                System.out.print(ex.getStackTrace());
            }
        }
    }

}
