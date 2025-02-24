package com.example.Greeting_App_Development.UC5_Find_Message.Model;

public class GreetingModel_Find {
    private Long id;
    private String message;

    public GreetingModel_Find(Long id, String message) {
        this.id = id;
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
