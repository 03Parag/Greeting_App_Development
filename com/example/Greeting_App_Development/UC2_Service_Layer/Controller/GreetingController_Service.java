package com.example.Greeting_App_Development.UC2_Service_Layer.Controller;

import com.example.Greeting_App_Development.UC2_Service_Layer.Model.GreetingModel_Service;
import org.springframework.web.bind.annotation.*;
import com.example.Greeting_App_Development.UC2_Service_Layer.Service.GreetingService_Service;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/greeting")
public class GreetingController_Service {

    //UC1
    @GetMapping("/greet")
    public GreetingModel_Service getGreeting() {
        return new GreetingModel_Service("Hello from BridgeLabz");
    }

    @PostMapping("/greet")
    public GreetingModel_Service postGreeting(@RequestBody GreetingModel_Service greeting) {
        return greeting;
    }

    @PutMapping("/greet")
    public GreetingModel_Service putGreeting(@RequestBody GreetingModel_Service greeting) {
        return new GreetingModel_Service("Updated: " + greeting.getMessage());
    }

    @DeleteMapping("/greet")
    public GreetingModel_Service deleteGreeting() {
        return new GreetingModel_Service("GreetingModel_Name deleted");
    }


    //UC2
    private final GreetingService_Service greetingService;

    @Autowired
    public GreetingController_Service(GreetingService_Service greetingService) {
        this.greetingService = greetingService;
    }

    //UC2
    @GetMapping("/greet service")
    public GreetingModel_Service getGreetings() {
        return new GreetingModel_Service(greetingService.getGreetingMessage());
    }
}

