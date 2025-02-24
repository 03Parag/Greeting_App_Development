package com.example.Greeting_App_Development.UC4_Save_Message.Repository;

import com.example.Greeting_App_Development.UC4_Save_Message.Model.GreetingModel_Save;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GreetingRepository_Save {

    private List<GreetingModel_Save> greetings = new ArrayList<>();

    public void save(GreetingModel_Save greeting) {
        greetings.add(greeting);
    }

    public List<GreetingModel_Save> findAll() {
        return greetings;
    }
}
