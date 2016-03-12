package com.afm.notify.clients;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Created by rchen on 2/18/16.
 */
public interface NotificationClient {

    @RequestLine("POST /{path}?user={user}")
    @Headers("Content-Type: application/json")
    void doRequest(@Param("path") String path, @Param("user") String user, Object content);

}
