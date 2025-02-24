package com.example.Greeting_App_Development.UC2_Service_Layer.Model;

public class GreetingModel_Service {
    private String message;

    public GreetingModel_Service(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
