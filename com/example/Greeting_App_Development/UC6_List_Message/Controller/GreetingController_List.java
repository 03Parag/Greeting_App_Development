package com.example.Greeting_App_Development.UC6_List_Message.Controller;

import com.example.Greeting_App_Development.UC6_List_Message.Model.GreetingModel_List;
import org.springframework.web.bind.annotation.*;

import com.example.Greeting_App_Development.UC6_List_Message.Service.GreetingService_List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController_List {

    private final GreetingService_List greetingService;

    @Autowired
    public GreetingController_List(GreetingService_List greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greetuser")
    public GreetingModel_List greetUser(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return new GreetingModel_List(message);
    }

    @PostMapping("/savegreeting")
    public GreetingModel_List saveGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return greetingService.saveGreeting(firstName, lastName);
    }

    @GetMapping("/findgreeting/{id}")
    public GreetingModel_List findGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

    @GetMapping("/allgreetings")
    public List<GreetingModel_List> getAllGreetings() {
        return greetingService.getAllGreetings();
    }





}

