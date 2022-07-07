package com.test.demo.teacher;

import com.test.demo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Integer teacherId) {
        Optional<Teacher> teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher.isEmpty())
            throw new IllegalStateException("no teacher found with given id");

        return teacher;
    }

    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherId = teacherRepository.findTeacherById(teacher.getId());
        if (teacherId.isPresent())
            throw new IllegalStateException("A teacher with the given id already exists.");
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findTeacherById(id);
        if (teacher.isEmpty())
            throw new IllegalStateException("No teacher exist with the given id.");
        teacherRepository.deleteById(id);
    }
}
