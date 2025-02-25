package com.example.greetingapplication.greetingservice;

import com.example.greetingapplication.greetingmodel.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public Greeting getSimpleGreeting() {
        return new Greeting(0L, "Hello World");
    }

    //uc3 create greeting message
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
}
