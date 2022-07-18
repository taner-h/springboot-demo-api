package com.test.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping
    public Course addNewCourse(@RequestBody Course course) {
        return courseService.addNewCourse(course);
    }

    @DeleteMapping(path= "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Integer id){
        courseService.deleteCourse(id);
    }

    @GetMapping(path= "{courseId}")
    public Optional<Course> getCourseByID(@PathVariable("courseId") Integer id){
        return courseService.getCourseByID(id);
    }

    @PutMapping("/{courseId}/student/{studentId}")
    public Course enrollStudentToCourse(@PathVariable Integer courseId, @PathVariable Integer studentId) {
        return courseService.enrollStudentToCourse(courseId, studentId);
    }

    @PutMapping("/{courseId}/teacher/{teacherId}")
    public Course assignTeacherToCourse(@PathVariable Integer courseId, @PathVariable Integer teacherId) {
        return courseService.assignTeacherToCourse(courseId, teacherId);
    }

}
