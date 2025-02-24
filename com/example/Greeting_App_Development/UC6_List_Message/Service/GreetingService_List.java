package com.example.Greeting_App_Development.UC6_List_Message.Service;

import com.example.Greeting_App_Development.UC6_List_Message.Model.GreetingModel_List;
import com.example.Greeting_App_Development.UC6_List_Message.Repository.GreetingRepository_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService_List {

    private final GreetingRepository_List greetingRepository;

    @Autowired
    public GreetingService_List(GreetingRepository_List greetingRepository) {
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

        GreetingModel_List greeting = new GreetingModel_List(message);
        greetingRepository.save(greeting);

        return message;
    }

    public Optional<GreetingModel_List> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public GreetingModel_List saveGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName.trim() + " " + lastName.trim() + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName.trim() + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName.trim() + "!";
        } else {
            message = "Hello, World!";
        }

        message = message.replaceAll("\\s+", " ").trim();

        GreetingModel_List greeting = new GreetingModel_List(message);
        return greetingRepository.save(greeting);
    }

    public List<GreetingModel_List> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
