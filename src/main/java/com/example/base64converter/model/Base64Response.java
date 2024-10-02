package com.example.base64converter.model;

public class Base64Response {

    private String message;
    private String result;

    public Base64Response(String message, String result) {
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

