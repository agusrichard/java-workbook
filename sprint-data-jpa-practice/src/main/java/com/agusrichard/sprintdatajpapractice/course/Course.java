package com.agusrichard.sprintdatajpapractice.course;

import com.agusrichard.sprintdatajpapractice.student.Student;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @CreationTimestamp
    private Date createdDate;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course(){}

    public Course(Long id, String name, String description, Date createdDate, List<Student> students) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.students = students;
    }

    public Course(String name, String description, Date createdDate, List<Student> students) {
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", students=" + students +
                '}';
    }
}
