package com.example.Greeting_App_Development.UC4_Save_Message.Service;

import com.example.Greeting_App_Development.UC4_Save_Message.Model.GreetingModel_Save;
import com.example.Greeting_App_Development.UC4_Save_Message.Repository.GreetingRepository_Save;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService_Save {

    private final GreetingRepository_Save greetingRepository_Save;

    @Autowired
    public GreetingService_Save(GreetingRepository_Save greetingRepository_Save) {
        this.greetingRepository_Save = greetingRepository_Save;
    }

    public String getGreetingMessage(String firstName, String lastName) {
        String message;
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World";
        }

        // Save greeting to repository
        GreetingModel_Save greeting = new GreetingModel_Save(message);
        greetingRepository_Save.save(greeting);

        return message;
    }
}
