package com.agusrichard.sprintdatajpapractice.student;

import com.agusrichard.sprintdatajpapractice.course.Course;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column()
    private String fullname;

    @JsonProperty("birth_date")
    @Column()
    private LocalDate birthDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="course_student",
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Course> courses;

    public Student() {}

    public Student(String email, String password, String fullname, LocalDate birthDate, List<Course> courses) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.courses = courses;
    }

    public Student(Long id, String email, String password, String fullname, LocalDate birthDate, List<Course> courses) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.courses = courses;
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

    public void addCourse(Course course) {
        this.courses.add(course);
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
