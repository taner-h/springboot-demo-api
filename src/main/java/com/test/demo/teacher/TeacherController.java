package com.test.demo.teacher;

import com.test.demo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping(path= "{teacherId}")
    public Optional<Teacher> getTeacherById(@PathVariable Integer teacherId){
        return teacherService.getTeacherById(teacherId);

    }

    @PostMapping
    public Teacher addNewTeacher(@RequestBody Teacher teacher) {
        return teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path= "{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Integer id){
        teacherService.deleteTeacher(id);
    }
}
