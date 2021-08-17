package com.example.hellorestservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/user")
    public User user(@RequestParam(value = "name", defaultValue = "Sekar") String name,
            @RequestParam(value = "age", defaultValue = "0") int age) {
        return new User(counter.incrementAndGet(), name, age);
    }
}
