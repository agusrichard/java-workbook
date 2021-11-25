package com.agusrichard.sprintdatajpapractice.course;

import com.agusrichard.sprintdatajpapractice.student.Student;
import com.agusrichard.sprintdatajpapractice.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository,
                         StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.getById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void registerStudent(Long studentId, Long courseId) {
        Student studentFound = studentRepository.findById(studentId).get();
        Course courseFound = courseRepository.findById(courseId).get();
        System.out.println(studentFound);
        System.out.println(courseFound);
        courseFound.addStudent(studentFound);
        courseRepository.save(courseFound);
    }
}
