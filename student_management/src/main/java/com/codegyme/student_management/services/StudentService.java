package com.codegyme.student_management.services;

import com.codegyme.student_management.models.Student;
import com.codegyme.student_management.repositories.StudentRepository;

import java.util.List;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public void save(Student student) {
        studentRepository.add(student);
    }
}
