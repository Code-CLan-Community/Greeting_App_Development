package com.example.greetingapplication.greetingmodel;

public class Greeting {
    private Long id;
    private String message;

    // Constructors
    public Greeting() {}

    public Greeting(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
