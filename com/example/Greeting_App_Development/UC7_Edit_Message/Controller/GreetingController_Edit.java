package com.example.Greeting_App_Development.UC7_Edit_Message.Controller;

import com.example.Greeting_App_Development.UC7_Edit_Message.Model.GreetingModel_Edit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Greeting_App_Development.UC7_Edit_Message.Service.GreetingService_Edit;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController_Edit {

    private final GreetingService_Edit greetingService;

    @Autowired
    public GreetingController_Edit(GreetingService_Edit greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greetuser")
    public GreetingModel_Edit greetUser(@RequestParam(required = false) String firstName,
                                        @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return new GreetingModel_Edit(message);
    }

    @PostMapping("/savegreeting")
    public GreetingModel_Edit saveGreeting(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return greetingService.saveGreeting(firstName, lastName);
    }

    @GetMapping("/findgreeting/{id}")
    public GreetingModel_Edit findGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

    @GetMapping("/allgreetings")
    public List<GreetingModel_Edit> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/updategreeting/{id}")
    public GreetingModel_Edit updateGreeting(
            @PathVariable Long id,
            @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }
}
