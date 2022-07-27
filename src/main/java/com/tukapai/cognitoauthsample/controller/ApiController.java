package com.tukapai.cognitoauthsample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/")
public class ApiController {
    //バックエンドに送信できているかを確認するAPI
    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping
    public String testApiCall() {
        logger.info("test api call");

        InetAddress ip;
        String hostname = "";
        String hostip = "";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            hostip = ip.toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "<html>Hello dears !!!! <br>" +
                "Your current IP address : " + hostip + "<br>" +
                "Your current Hostname : " + hostname + "<br>"
                + "</html>";
    }
}
