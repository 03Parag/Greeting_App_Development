package com.example.Greeting_App_Development.UC6_List_Message.Repository;

import com.example.Greeting_App_Development.UC6_List_Message.Model.GreetingModel_List;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GreetingRepository_List {

    private List<GreetingModel_List> greetings = new ArrayList<>();

    public GreetingModel_List save(GreetingModel_List greeting) {
        greetings.add(greeting);
        return greeting;
    }

    public List<GreetingModel_List> findAll() {
        return greetings;
    }

    public Optional<GreetingModel_List> findById(Long id) {
        return greetings.stream()
                .filter(greeting -> greeting.getId().equals(id))
                .findFirst();
    }
}
