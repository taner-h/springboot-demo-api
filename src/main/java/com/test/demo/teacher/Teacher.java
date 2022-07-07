package com.test.demo.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.demo.course.Course;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate dob;
    private String email;
    private LocalDate jobStartDate;

    @JsonIgnore
    @ManyToMany(mappedBy = "teachers")
    private Set<Course> courses;

    @Transient
    private Integer age;

    public Teacher() {
    }

    public Teacher(
            String name,
            LocalDate dob,
            String email,
            LocalDate jobStartDate) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.jobStartDate = jobStartDate;
        this.courses = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJobStartDate() {
        return jobStartDate;
    }

    public void setJobStartDate(LocalDate jobStartDate) {
        this.jobStartDate = jobStartDate;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", jobStartDate=" + jobStartDate +
                ", age=" + age +
                '}';
    }
}
