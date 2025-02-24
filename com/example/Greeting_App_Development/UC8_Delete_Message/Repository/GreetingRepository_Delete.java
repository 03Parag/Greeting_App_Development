package com.example.Greeting_App_Development.UC8_Delete_Message.Repository;

import com.example.Greeting_App_Development.UC8_Delete_Message.Model.GreetingModel_Delete;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GreetingRepository_Delete {
    private final Map<Long, GreetingModel_Delete> greetings = new HashMap<>();
    private long idCounter = 1;

    public GreetingModel_Delete save(GreetingModel_Delete greeting) {
        if (greeting.getId() == null) {
            greeting.setId(idCounter++);
        }
        greetings.put(greeting.getId(), greeting);
        return greeting;
    }

    public List<GreetingModel_Delete> findAll() {
        return new ArrayList<>(greetings.values());
    }

    public Optional<GreetingModel_Delete> findById(Long id) {
        return Optional.ofNullable(greetings.get(id));
    }

    public boolean existsById(Long id) {
        return greetings.containsKey(id);
    }

    public void deleteById(Long id) {
        greetings.remove(id);
    }
}
