package com.test.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentByEmail(String email);
//    @Query("select e from Student e where e.email = :email")
//    Optional<Student> findStudentMyEmail(String email);
    Optional<Student> findStudentById(Integer id);
}
