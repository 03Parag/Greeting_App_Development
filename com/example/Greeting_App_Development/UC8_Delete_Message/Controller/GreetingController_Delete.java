package com.example.Greeting_App_Development.UC8_Delete_Message.Controller;

import com.example.Greeting_App_Development.UC8_Delete_Message.Model.GreetingModel_Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Greeting_App_Development.UC8_Delete_Message.Service.GreetingService_Delete;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController_Delete {

    private final GreetingService_Delete greetingService;

    @Autowired
    public GreetingController_Delete(GreetingService_Delete greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greetuser")
    public GreetingModel_Delete greetUser(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return new GreetingModel_Delete(message);
    }

    @PostMapping("/savegreeting")
    public GreetingModel_Delete saveGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        String message = greetingService.getGreetingMessage(firstName, lastName);
        return greetingService.saveGreeting(firstName, lastName);
    }

    @GetMapping("/findgreeting/{id}")
    public GreetingModel_Delete findGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

    @GetMapping("/allgreetings")
    public List<GreetingModel_Delete> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/updategreeting/{id}")
    public GreetingModel_Delete updateGreeting(
            @PathVariable Long id,
            @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }

    @DeleteMapping("/deletegreeting/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.ok("Greeting with ID " + id + " deleted successfully.");
    }


}

