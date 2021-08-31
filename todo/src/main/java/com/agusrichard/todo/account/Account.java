package com.agusrichard.todo.account;

import com.agusrichard.todo.todo.Todo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;
    private String fullname;

    @Column(nullable = true)
    private LocalDate dob;

    @OneToMany(mappedBy = "account")
    private List<Todo> todoList;

    public Account(Long id, String email, String fullname, LocalDate dob) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.dob = dob;
    }

    public Account(String email, String fullname, LocalDate dob) {
        this.email = email;
        this.fullname = fullname;
        this.dob = dob;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", dob=" + dob +
                '}';
    }
}
