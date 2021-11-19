package com.agusrichard.sprintdatajpapractice.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "agusrichard@example.com",
                        "agusrichard",
                        "Agus Richard",
                        LocalDate.of(1997, Month.SEPTEMBER, 21)
                )
        );
    }
}
