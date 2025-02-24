package com.example.Greeting_App_Development.UC3_Using_Name.Service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService_Name {
    public static String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World";
        }
    }
}
