package com.example.Greeting_App_Development.UC1_Return_JSON.Controller;

import com.example.Greeting_App_Development.UC1_Return_JSON.Model.GreetingModel_JSON;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController_JSON {

    // GET Request - Returns a GreetingModel_JSON object as JSON
    @GetMapping("/greet")
    public GreetingModel_JSON getGreeting() {
        return new GreetingModel_JSON(1, "Hello from GET");
    }

    // POST Request - Accepts a GreetingModel_JSON JSON and returns JSON response
    @PostMapping
    public GreetingModel_JSON postGreeting(@RequestBody GreetingModel_JSON request) {
        return new GreetingModel_JSON(2, "Hello from POST, received: " + request.getMessage());
    }

    // PUT Request - Accepts a GreetingModel_JSON JSON and updates it
    @PutMapping
    public GreetingModel_JSON putGreeting(@RequestBody GreetingModel_JSON request) {
        return new GreetingModel_JSON(request.getId(), "Updated: " + request.getMessage());
    }

    // DELETE Request - Accepts a GreetingModel_JSON JSON (optional) and deletes it
    @DeleteMapping
    public GreetingModel_JSON deleteGreeting(@RequestBody(required = false) GreetingModel_JSON request) {
        if (request != null) {
            return new GreetingModel_JSON(request.getId(), "Deleted: " + request.getMessage());
        } else {
            return new GreetingModel_JSON(0, "No data provided");
        }
    }
}
