package com.afm.notify.domain;

/**
 * Created by rchen on 2/18/16.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

/**
 *  A consumer consumes from a kafka topic, process the object if necessary and post it to the url
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Consumer {

    @Id
    String id;

    String topic;
    String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Consumer(String id, String topic, String url) {
        this.id = id;
        this.topic = topic;
        this.url = url;
    }

}
