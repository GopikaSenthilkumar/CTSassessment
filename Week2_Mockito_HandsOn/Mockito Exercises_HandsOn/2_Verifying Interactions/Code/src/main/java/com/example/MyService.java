package com.example;
public class MyService {
    private final ExternalAPI api;
    public MyService(ExternalAPI api) {
        this.api = api;
    }
    public void retrieveMessage() {
        String result = api.fetchMessage();
        System.out.println("Received: " + result);
    }
}
