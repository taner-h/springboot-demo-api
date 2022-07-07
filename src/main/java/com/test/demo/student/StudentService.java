package com.test.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentEmail.isPresent())
            throw new IllegalStateException("e-mail already taken.");
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        Optional<Student> studentId = studentRepository.findStudentById(id);
        if (studentId.isEmpty()) {
            throw new IllegalStateException("no student found with given id (" + id + ")");
        }

        studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudent(Integer id, String name, String email) {
        Student student = studentRepository.findStudentById(id)
                .orElseThrow(() -> new IllegalStateException("no student found with given id (" + id + ")"));

        if (name != null)  student.setName(name);
        if (email != null)  student.setEmail(email);
    }

    public Optional<Student> getStudentById(Integer id) {
        Optional<Student> student = studentRepository.findStudentById(id);
        if (student.isEmpty()) {
            throw new IllegalStateException("no student found with given id (" + id + ")");
        }

        return student;
    }
}