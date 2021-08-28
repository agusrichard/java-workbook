package com.agusrichard.todo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @GetMapping(path = "hello")
    public String hello() {
        return "Hello from UserController";
    }
}
