package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student sherlock = new Student(
                    "Sherlock Holmes",
                    "sherlockholmes@example.com",
                    LocalDate.of(1997, Month.NOVEMBER, 14)
            );

            Student john = new Student(
                    "John Watson",
                    "johnwatson@example.com",
                    LocalDate.of(1999, Month.OCTOBER, 8)
            );

            repository.saveAll(
                    List.of(sherlock, john)
            );
        };
    }
}
