package com.test.demo.course;

import com.test.demo.student.Student;
import com.test.demo.teacher.Teacher;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String code;
    private Integer credit;

    @ManyToMany
    @JoinTable(
            name = "CourseStudent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Student> students;
    @ManyToMany
    @JoinTable(
            name = "CourseTeacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Teacher> teachers;

    public Course(String title, String code, Integer credit) {
        this.title = title;
        this.code = code;
        this.credit = credit;
        this.students = new HashSet<>();
        this.teachers = new HashSet<>();
    }

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }


    public Set<Student> getStudents() {
        return students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
}
