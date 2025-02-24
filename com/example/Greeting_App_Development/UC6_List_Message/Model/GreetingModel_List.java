package com.example.Greeting_App_Development.UC6_List_Message.Model;

public class GreetingModel_List {
    private Long id;
    private String message;


    public GreetingModel_List(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
