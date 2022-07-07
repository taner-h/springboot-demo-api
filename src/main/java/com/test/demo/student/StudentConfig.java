package com.test.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner studentRunner(StudentRepository repository) {
        return args -> {
            Student taner = new Student(
                    "Taner",
                    LocalDate.of(1999, MARCH, 29),
                    "tanerfb1999@gmail.com");
            Student john = new Student(
                    "John",
                    LocalDate.of(1988, JANUARY, 21),
                    "johndoe@gmail.com");
            Student jack = new Student(
                    "Jack",
                    LocalDate.of(2001, DECEMBER, 5),
                    "nicholsonjack@gmail.com");

            repository.saveAll(List.of(taner, john, jack));



        };

    }
}
