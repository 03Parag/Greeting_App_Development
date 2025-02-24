package com.example.Greeting_App_Development.UC5_Find_Message.Repository;

import com.example.Greeting_App_Development.UC5_Find_Message.Model.GreetingModel_Find;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GreetingRepository_Find {

    private List<GreetingModel_Find> greetings = new ArrayList<>();
    private static Long idCounter = 1L;

    // Save greeting message to in-memory list
    public void save(GreetingModel_Find greeting) {
        greeting.setId(idCounter++);
        greetings.add(greeting);
    }

    // Find greeting by ID
    public Optional<GreetingModel_Find> findById(Long id) {
        return greetings.stream().filter(g -> g.getId().equals(id)).findFirst();
    }

    // Get all greeting messages (optional)
    public List<GreetingModel_Find> findAll() {
        return greetings;
    }
}

