package com.example.Greeting_App_Development.UC1_Return_JSON.Model;

public class GreetingModel_JSON {
    private int id;
    private String message;

    public GreetingModel_JSON() {}

    public GreetingModel_JSON(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
