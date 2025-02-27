package com.example.greetingapplication.greetingservice;

import com.example.greetingapplication.greetingmodel.Greeting;
import com.example.greetingapplication.greetingrepository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class GreetingService {

    public Greeting getSimpleGreeting() {
        return new Greeting(0L, "Hello World");
    }

    public Greeting createGreeting(String firstName, String lastName) {
        String message = "Hello";
        if (firstName != null && !firstName.isEmpty()) {
            message += " " + firstName;
        }
        if (lastName != null && !lastName.isEmpty()) {
            message += " " + lastName;
        }
        if (firstName == null && lastName == null) {
            message = "Hello World";
        }
        return new Greeting(1L, message);
    }

    // UC4 - Create a repository
    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    // UC5 - Find Greeting by ID
    public Greeting findGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    // UC6 - Display All Greetings
    public List<Greeting> listAllGreetings() {
        List<Greeting> greetings = new ArrayList<>();
        greetingRepository.findAll().forEach(greetings::add);
        return greetings;
    }

    // UC7 - Update Greeting Message
    public Greeting editGreeting(Long id, String newMessage) {
        Greeting greeting = greetingRepository.findById(id).orElse(null);
        if (greeting != null) {
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return null;
    }
}
