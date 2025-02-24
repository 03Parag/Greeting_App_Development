package com.example.Greeting_App_Development.UC7_Edit_Message.Service;

import com.example.Greeting_App_Development.UC7_Edit_Message.Model.GreetingModel_Edit;
import com.example.Greeting_App_Development.UC7_Edit_Message.Repository.GreetingRepository_Edit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService_Edit {

    private final GreetingRepository_Edit greetingRepository;

    @Autowired
    public GreetingService_Edit(GreetingRepository_Edit greetingRepository) {
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

        GreetingModel_Edit greeting = new GreetingModel_Edit(message);
        greetingRepository.save(greeting);

        return message;
    }

    public Optional<GreetingModel_Edit> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public GreetingModel_Edit saveGreeting(String firstName, String lastName) {
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

        message = message.replaceAll("\\s+", " ").trim(); // Remove extra spaces or newlines

        GreetingModel_Edit greeting = new GreetingModel_Edit(message);
        return greetingRepository.save(greeting);
    }

    public List<GreetingModel_Edit> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public GreetingModel_Edit updateGreeting(Long id, String newMessage) {
        Optional<GreetingModel_Edit> existingGreeting = greetingRepository.findById(id);

        if (existingGreeting.isPresent()) {
            GreetingModel_Edit greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with id: " + id);
        }
    }
}
