package com.agusrichard.sprintdatajpapractice.student;

import java.time.LocalDate;

public class Student {
     private Long id;
     private String email;
     private String password;
     private String fullname;
     private LocalDate birthDate;

     public Student() {

     }

    public Student(Long id, String email, String password, String fullname, LocalDate birthDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.birthDate = birthDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
