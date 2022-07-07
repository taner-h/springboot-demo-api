package com.test.demo.course;

import com.test.demo.student.Student;
import com.test.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void addNewCourse(Course course) {
        Optional<Course> courseCode = courseRepository.findCourseByCode(course.getCode());
    if (courseCode.isPresent())
        throw new IllegalStateException("A course with the given code already exists.");
    courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        Optional<Course> course = courseRepository.findCourseById(id);
        if (course.isEmpty())
            throw new IllegalStateException("No course exist with the given id.");
        courseRepository.deleteById(id);
    }

    public Optional<Course> getCourseByID(Integer id) {
        Optional<Course> course = courseRepository.findCourseById(id);
        if (course.isEmpty())
            throw new IllegalStateException("No course exist with the given id.");

        return course;
    }


    public void enrollStudentToCourse(Integer courseId, Integer studentId) {
        Course course = courseRepository.findCourseById(courseId)
                .orElseThrow(() -> new IllegalStateException("no course found with given id (" + courseId + ")"));
        Student student = studentRepository.findStudentById(studentId)
                .orElseThrow(() -> new IllegalStateException("no student found with given id (" + studentId + ")"));
        course.enrollStudent(student);
        courseRepository.save(course);

        }



}

