package com.agusrichard.todo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    @GetMapping(path = "hello")
    public String hello() {
        return "Hello from Todo Controller";
    }
}
