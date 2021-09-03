package com.agusrichard.todo.todo;

import com.agusrichard.todo.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            nullable = false,
            columnDefinition = "VARCHAR(128)"
    )
    private String title;

    @Column(
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            nullable = true,
            columnDefinition = "TIMESTAMP WITH TIME ZONE"
    )
    private OffsetDateTime timeOfExecution;

    @ManyToOne
    @JoinColumn(name="account_id")
    @JsonIgnore
    private Account account;

    public Todo(String title, String description, OffsetDateTime timeOfExecution, Account account) {
        this.title = title;
        this.description = description;
        this.timeOfExecution = timeOfExecution;
        this.account = account;
    }

    public Todo(Long id, String title, String description, OffsetDateTime timeOfExecution, Account account) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timeOfExecution = timeOfExecution;
        this.account = account;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getTimeOfExecution() {
        return timeOfExecution;
    }

    public void setTimeOfExecution(OffsetDateTime timeOfExecution) {
        this.timeOfExecution = timeOfExecution;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timeOfExecution=" + timeOfExecution +
                ", account=" + account +
                '}';
    }
}
