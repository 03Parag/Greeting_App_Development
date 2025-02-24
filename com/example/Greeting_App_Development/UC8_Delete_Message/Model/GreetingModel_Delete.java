package com.example.Greeting_App_Development.UC8_Delete_Message.Model;

public class GreetingModel_Delete {
    private Long id;
    private String message;

    public GreetingModel_Delete(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public GreetingModel_Delete(String message) {
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
