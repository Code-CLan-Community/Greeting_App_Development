package com.example.greetingapplication.greetingservice;

import com.example.greetingapplication.greetingmodel.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public Greeting getSimpleGreeting() {
        return new Greeting(0L, "Hello World");
    }
}
