package com.afm.notify.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Created by rchen on 2/22/16.
 */
public class NotificationCommand {
    @HystrixCommand
    public void doRequest(NotificationClient client, String callbackUri, Object eventMessage) {
        String user = extractUserFromRequest(callbackUri);
        callbackUri = extractPathFromCallbackUri(callbackUri);
        client.doRequest(callbackUri, user, eventMessage);
    }

    protected static String extractPathFromCallbackUri(String callbackUri){
        return (callbackUri.contains("?")) ? callbackUri.substring(0, callbackUri.indexOf("?")) : callbackUri;
    }

    protected static String extractUserFromRequest(String callbackUri){
        String user = null;
        if(callbackUri.contains("user=")){
            user = callbackUri.split("user=")[1];
            if(user.contains("&")){
                user = user.substring(0, user.indexOf("&"));
            }
        }
        return user;
    }

}
