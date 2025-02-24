package com.example.Greeting_App_Development.UC3_Using_Name.Controller;

import com.example.Greeting_App_Development.UC3_Using_Name.Model.GreetingModel_Name;
import org.springframework.web.bind.annotation.*;

import com.example.Greeting_App_Development.UC3_Using_Name.Service.GreetingService_Name;

@RestController
@RequestMapping("/greeting")
public class GreetingController_Name {

    @GetMapping("/greet user")
    public GreetingModel_Name greetUser(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        String message = GreetingService_Name.getGreetingMessage(firstName, lastName);
        return new GreetingModel_Name(message);
    }
}

