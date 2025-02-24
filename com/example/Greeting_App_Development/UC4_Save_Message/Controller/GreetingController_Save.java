package com.example.Greeting_App_Development.UC4_Save_Message.Controller;

import com.example.Greeting_App_Development.UC4_Save_Message.Model.GreetingModel_Save;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Greeting_App_Development.UC4_Save_Message.Service.GreetingService_Save;

@RestController
@RequestMapping("/greeting")
public class GreetingController_Save {

    private final GreetingService_Save greetingService_Save;

    @Autowired
    public GreetingController_Save(GreetingService_Save greetingService_Save) {
        this.greetingService_Save = greetingService_Save;
    }

    @GetMapping("/greetuser")
    public GreetingModel_Save greetUser(@RequestParam(required = false) String firstName,
                                        @RequestParam(required = false) String lastName) {
        String message = greetingService_Save.getGreetingMessage(firstName, lastName);
        return new GreetingModel_Save(message);
    }

    @PostMapping("/savegreeting")
    public GreetingModel_Save saveGreeting(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName) {
        String message = greetingService_Save.getGreetingMessage(firstName, lastName);
        return new GreetingModel_Save(message);
    }
}
