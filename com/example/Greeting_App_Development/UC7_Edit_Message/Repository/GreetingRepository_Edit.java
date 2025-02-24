package com.example.Greeting_App_Development.UC7_Edit_Message.Repository;

import com.example.Greeting_App_Development.UC7_Edit_Message.Model.GreetingModel_Edit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GreetingRepository_Edit {

    private List<GreetingModel_Edit> greetings = new ArrayList<>();

    public GreetingModel_Edit save(GreetingModel_Edit greeting) {
        if (greeting.getId() == null) {
            greeting.setId((long) (greetings.size() + 1));
        }
        greetings.add(greeting);
        return greeting;
    }

    public List<GreetingModel_Edit> findAll() {
        return greetings;
    }

    public Optional<GreetingModel_Edit> findById(Long id) {
        return greetings.stream()
                .filter(greeting -> greeting.getId().equals(id))
                .findFirst();
    }
}
