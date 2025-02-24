package com.example.Greeting_App_Development.UC8_Delete_Message.Service;

import com.example.Greeting_App_Development.UC8_Delete_Message.Model.GreetingModel_Delete;
import com.example.Greeting_App_Development.UC8_Delete_Message.Repository.GreetingRepository_Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService_Delete {


    private final GreetingRepository_Delete greetingRepository;

    @Autowired
    public GreetingService_Delete(GreetingRepository_Delete greetingRepository) {
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
            message = "Hello World";
        }

        GreetingModel_Delete greeting = new GreetingModel_Delete(message);
        greetingRepository.save(greeting);

        return message; // Save in database
    }

    public Optional<GreetingModel_Delete> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public GreetingModel_Delete saveGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName.trim() + " " + lastName.trim() + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName.trim() + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName.trim() + "!";
        } else {
            message = "Hello World!";
        }

        message = message.replaceAll("\\s+", " ").trim(); // Remove extra spaces or newlines

        GreetingModel_Delete greeting = new GreetingModel_Delete(message);
        return greetingRepository.save(greeting);
    }



    //UC-06 Ability for the Greeti App to List all the Greeting Messages in the Repository
    public List<GreetingModel_Delete> getAllGreetings() {
        return greetingRepository.findAll();
    }

    //UC-07Ability for the Greeting App to Edit a Greeting Messages in thE Repository
    public GreetingModel_Delete updateGreeting(Long id, String newMessage) {
        Optional<GreetingModel_Delete> existingGreeting = greetingRepository.findById(id);

        if (existingGreeting.isPresent()) {
            GreetingModel_Delete greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with id: " + id);
        }
    }

    public void deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with id: " + id);
        }
    }

}

