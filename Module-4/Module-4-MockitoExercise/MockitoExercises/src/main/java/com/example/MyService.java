package com.example;

public class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void send(String message) {
        api.sendData(message);
    }

    public void remove() {
        api.deleteData();
    }
}