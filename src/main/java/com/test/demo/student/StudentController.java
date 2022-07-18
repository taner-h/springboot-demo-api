package com.test.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/student")
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

    @GetMapping(path = "{studentID}")
    public Optional<Student> getStudentById(@PathVariable("studentID") Integer id) {
        return studentService.getStudentById(id);
    }


    @PostMapping
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Integer id) {

        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentID}")
    public Student updateStudent(
            @PathVariable("studentID") Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
            ) {

        return studentService.updateStudent(id, name, email);
    }



}