package com.test.demo.teacher;

import com.test.demo.course.Course;
import com.test.demo.course.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    CommandLineRunner teacherRunner(TeacherRepository repository) {
        return args -> {
            Teacher jack = new Teacher(
                    "Jack N.",
                    LocalDate.of(1980, Month.JANUARY, 23),
                    "jack@mail.com",
                    LocalDate.of(2018, Month.MARCH, 12)
            );

            Teacher sam = new Teacher(
                    "Sam J.",
                    LocalDate.of(1962, Month.JANUARY, 22),
                    "jack@mail.com",
                    LocalDate.of(2015, Month.DECEMBER, 1)
            );

            Teacher dan = new Teacher(
                    "Dan L.",
                    LocalDate.of(1967, Month.APRIL, 3),
                    "jack@mail.com",
                    LocalDate.of(2014, Month.MARCH, 17)
            );

            repository.saveAll(List.of(sam,dan,jack));


        };
    }
}
