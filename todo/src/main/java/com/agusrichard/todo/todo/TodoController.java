package com.agusrichard.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "hello")
    public String hello() {
        return "Hello from Todo Controller";
    }

    @PostMapping("{userId}")
    public void createNewTodo(@PathVariable Long userId, @RequestBody Todo todo) {
        todoService.createNewTodo(userId, todo);
    }

    @GetMapping("get-todo-list/{accountId}")
    public List<Todo> getTodoList(@PathVariable Long accountId) {
        return todoService.getTodoList(accountId);
    }

    @DeleteMapping("{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
    }
}
