package com.test.demo.course;

import com.test.demo.student.Student;

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
    private String instructor;
    private Integer credit;

    @ManyToMany
    @JoinTable(
            name = "CourseStudent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Student> students;

    public Course(String title, String code, String instructor, Integer credit) {
        this.title = title;
        this.code = code;
        this.instructor = instructor;
        this.credit = credit;
        this.students = new HashSet<>();
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", instructor='" + instructor + '\'' +
                ", credit=" + credit +
                '}';
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }
}
