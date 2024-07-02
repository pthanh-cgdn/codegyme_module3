package com.codegyme.student_management.repositories;

import com.codegyme.student_management.models.Student;
import com.codegyme.student_management.services.StudentService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();
//    static {
//        students.add(new Student(1, "HaiTT","QN","hai.tran@codegyme.vn",10));
//        students.add(new Student(2, "HieuN","QT","hieu.nguyen@codegyme.vn",7));
//        students.add(new Student(3, "PhucH","DN","phuc.huynh@codegyme.vn",5));
//    }

    public StudentRepository() {
    }

    public List<Student> getAll() {
        students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select * from student_management.students");
            ResultSet resultSet = preparedStatement.executeQuery();
            int id;
            String name;
            String email;
            String address;
            double mark;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                email = resultSet.getString("email");
                mark = resultSet.getDouble("mark");
                students.add(new Student(id, name, address, email, mark));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public void add(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("insert into student_management.students (name,address,email,mark) values(?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setDouble(4, student.getMark());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id) {
        boolean isDelete;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("delete from student_management.students where id=?");
            preparedStatement.setInt(1, id);
            isDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete;
    }

    public void edit(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("update student_management.students set name = ?, address = ?, email = ?, mark = ? where id = ?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setDouble(4, student.getMark());
            preparedStatement.setInt(5, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudentById(int id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select * from student_management.students where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String name;
            String email;
            String address;
            double mark;
            while (resultSet.next()) {
//                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                email = resultSet.getString("email");
                mark = resultSet.getDouble("mark");
                student = new Student(id, name, address, email, mark);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
