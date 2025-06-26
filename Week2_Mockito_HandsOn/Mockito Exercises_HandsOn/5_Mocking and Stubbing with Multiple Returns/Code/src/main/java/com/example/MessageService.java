package com.example;
public class MessageService {
    private final ExternalAPI api;
    public MessageService(ExternalAPI api) {
        this.api = api;
    }
    public String fetchTwoMessages() {
        String first = api.getNextMessage();
        String second = api.getNextMessage();
        return first + " | " + second;
    }
}