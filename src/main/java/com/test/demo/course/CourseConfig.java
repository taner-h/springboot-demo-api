package com.test.demo.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner courseRunner(CourseRepository repository) {
        return args -> {
            Course oop = new Course(
                    "Object-Oriented Programming",
                    "INF-203",
                    4);
            Course mp = new Course(
                    "Microprocessors",
                    "INF-302",
                    3);
            Course rdb = new Course(
                    "Relational Databases",
                    "INF-310",
                    5);

            repository.saveAll(List.of(oop, mp, rdb));


        };
    }
}