package com.example.greetingapplication.greetingcontroller;

import com.example.greetingapplication.greetingmodel.Greeting;
import com.example.greetingapplication.greetingservice.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // UC1 Create Basic HTTP Requests

    // GET Request - Simple Greeting
    @GetMapping("/hello")
    public Greeting getGreeting() {
        return new Greeting(0L, "Hello from GET Method");
    }

    // POST Request - Simple Greeting
    @PostMapping("/hello")
    public Greeting postGreeting() {
        return new Greeting(1L, "Hello from POST Method");
    }

    // PUT Request - Simple Greeting
    @PutMapping("/hello")
    public Greeting putGreeting() {
        return new Greeting(2L, "Hello from PUT Method");
    }

    // DELETE Request - Simple Greeting
    @DeleteMapping("/hello")
    public Greeting deleteGreeting() {
        return new Greeting(3L, "Hello from DELETE Method");
    }

    // UC2 Create Simple Greeting
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/simple")
    public Greeting getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }

    @PostMapping("/create")
    public Greeting createGreeting(@RequestParam(required = false) String firstName,
                                   @RequestParam(required = false) String lastName) {
        return greetingService.createGreeting(firstName, lastName);
    }

    // UC4 Save Greeting Message
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    // UC5 Find Greeting by ID
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    // UC6 Display All Greetings
    @GetMapping("/list")
    public List<Greeting> listAllGreetings() {
        return greetingService.listAllGreetings();
    }

    // UC7 Update Greeting Message
    @PutMapping("/edit/{id}")
    public Greeting editGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.editGreeting(id, message);
    }

    // UC8 Delete a Greeting Message
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        boolean deleted = greetingService.deleteGreeting(id);
        return deleted ? "Greeting Deleted Successfully" : "Greeting Not Found";
    }
}
