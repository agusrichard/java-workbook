package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("No student with id " + studentId + " exists");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, Student student) {
        Student willBeUpdatedStudent = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("No student with id " + studentId + " exists")
        );

        System.out.println("update student");
        System.out.println(student.getName());
        System.out.println(willBeUpdatedStudent.getName());

        if (student.getName() != null && student.getName().length() > 0 && !Objects.equals(student.getName(), willBeUpdatedStudent.getName())) {
            System.out.println("Want to change the name");
            willBeUpdatedStudent.setName(student.getName());
        }

        if (student.getEmail() != null && student.getEmail().length() > 0 && !Objects.equals(student.getEmail(), willBeUpdatedStudent.getEmail())) {
            willBeUpdatedStudent.setEmail(student.getEmail());
        }

        if (student.getDob() != null && !Objects.equals(student.getDob(), willBeUpdatedStudent.getDob())) {
            willBeUpdatedStudent.setDob(student.getDob());
        }
    }
}
