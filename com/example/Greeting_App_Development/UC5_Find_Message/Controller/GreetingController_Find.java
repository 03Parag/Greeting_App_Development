package com.example.Greeting_App_Development.UC5_Find_Message.Controller;

import com.example.Greeting_App_Development.UC5_Find_Message.Model.GreetingModel_Find;
import com.example.Greeting_App_Development.UC5_Find_Message.Service.GreetingService_Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController_Find {

    private final GreetingService_Find greetingService;

    @Autowired
    public GreetingController_Find(GreetingService_Find greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greetuser")
    public GreetingModel_Find greetUser(@RequestParam(required = false) String firstName,
                                        @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        // Pass null as the id (or any valid Long value) since this is a greeting without a specific id
        return new GreetingModel_Find(null, message);
    }

    @GetMapping("/findgreeting/{id}")
    public GreetingModel_Find findGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }
}
