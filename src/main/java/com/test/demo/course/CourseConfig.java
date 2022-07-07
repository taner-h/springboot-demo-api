package com.test.demo.course;

import com.test.demo.student.Student;
import com.test.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner courseRunner(CourseRepository repository) {
        return args -> {
            Course oop = new Course(
                    "Object-Oriented Programming",
                    "INF-203",
                    "Jack N.",
                    4);
            Course mp = new Course(
                    "Microprocessors",
                    "INF-302",
                    "Robert D.N.",
                    3);
            Course rdb = new Course(
                    "Relational Databases",
                    "INF-310",
                    "Daniel D.L.",
                    5);

            repository.saveAll(List.of(oop, mp, rdb));


        };
    }
}