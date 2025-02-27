package com.example.greetingapplication.greetingrepository;

import com.example.greetingapplication.greetingmodel.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

}
