package com.example;

public class NotificationService {

    private ExternalApi api;

    public NotificationService(ExternalApi api) {
        this.api = api;
    }

    public void process() {
        api.sendData("Start");
        api.getData();
        api.deleteData();
    }
}