package com.example.demo.student;

import com.sun.xml.bind.annotation.XmlIsSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }
}
