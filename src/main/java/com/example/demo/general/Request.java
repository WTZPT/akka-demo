package com.example.demo.general;

public class Request {
    private final String key;
    private final Object value;

    public Request(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
