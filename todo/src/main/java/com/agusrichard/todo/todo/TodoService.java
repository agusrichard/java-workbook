package com.agusrichard.todo.todo;

import com.agusrichard.todo.account.Account;
import com.agusrichard.todo.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository, AccountRepository accountRepository) {
        this.todoRepository = todoRepository;
        this.accountRepository = accountRepository;
    }

    public void createNewTodo(Long userId, Todo todo) {
        Optional<Account> account = accountRepository.findById(userId);
        todo.setAccount(account.get());

        todoRepository.save(todo);
    }

    @Transactional
    public void updateTodo(Todo todo) {
        Todo willBeUpdatedTodo = todoRepository.findById(todo.getId()).orElseThrow(
                () -> new IllegalStateException("No todo with id " + todo.getId() + " is exist")
        );

        willBeUpdatedTodo.setTitle(todo.getTitle());
        willBeUpdatedTodo.setDescription(todo.getDescription());
        willBeUpdatedTodo.setTimeOfExecution(todo.getTimeOfExecution());
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> getTodoList(Long accountId) {
        return todoRepository.findAll();
    }
}
