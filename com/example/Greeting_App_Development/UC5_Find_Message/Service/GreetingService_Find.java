package com.example.Greeting_App_Development.UC5_Find_Message.Service;

import com.example.Greeting_App_Development.UC5_Find_Message.Model.GreetingModel_Find;
import com.example.Greeting_App_Development.UC5_Find_Message.Repository.GreetingRepository_Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService_Find {

    private final GreetingRepository_Find greetingRepository;

    @Autowired
    public GreetingService_Find(GreetingRepository_Find greetingRepository) {
        this.greetingRepository = greetingRepository;
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
            message = "Hello, World!";
        }

        GreetingModel_Find greeting = new GreetingModel_Find(null, message);
        greetingRepository.save(greeting);

        return message;
    }

    public Optional<GreetingModel_Find> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
}
