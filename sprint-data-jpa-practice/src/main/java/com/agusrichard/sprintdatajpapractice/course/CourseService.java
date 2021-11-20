package com.agusrichard.sprintdatajpapractice.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }
}
