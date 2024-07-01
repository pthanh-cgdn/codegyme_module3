package com.codegyme.student_management.repositories;

import com.codegyme.student_management.models.Student;
import com.codegyme.student_management.services.StudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "HaiTT","QN","hai.tran@codegyme.vn",10));
        students.add(new Student(2, "HieuN","QT","hieu.nguyen@codegyme.vn",7));
        students.add(new Student(3, "PhucH","DN","phuc.huynh@codegyme.vn",5));
    }

    public StudentRepository() {
    }

    public List<Student> getAll() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public boolean delete(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public void edit(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s.setName(student.getName());
                s.setAddress(student.getAddress());
                s.setEmail(student.getEmail());
                s.setMark(student.getMark());
            }
        }
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
