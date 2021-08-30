package com.agusrichard.todo.todo;

import com.agusrichard.todo.user.User;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 128)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column(
            name = "time_of_execution",
            columnDefinition = "TIMESTAMP WITH TIME ZONE",
            nullable = true
    )
    private OffsetDateTime timeOfExecution;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Todo(int id, String title, String description, OffsetDateTime timeOfExecution) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timeOfExecution = timeOfExecution;
    }

    public Todo(String title, String description, OffsetDateTime timeOfExecution) {
        this.title = title;
        this.description = description;
        this.timeOfExecution = timeOfExecution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timeOfExecution=" + timeOfExecution +
                '}';
    }
}
