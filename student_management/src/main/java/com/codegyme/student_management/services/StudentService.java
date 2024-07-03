package com.codegyme.student_management.services;

import com.codegyme.student_management.dto.StudentDTO;
import com.codegyme.student_management.models.Student;
import com.codegyme.student_management.repositories.StudentRepository;

import java.util.List;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();

    public List<StudentDTO> getAll() {
        return studentRepository.getAll();
    }

    public void save(Student student) {
        studentRepository.add(student);
    }

    public boolean delete(int id) {
        return studentRepository.delete(id);
    }

    public void edit(Student student) {
        studentRepository.edit(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }
}
