package com.codegyme.student_management.repositories;

import com.codegyme.student_management.dto.StudentDTO;
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

    public StudentRepository() {
    }

    public List<StudentDTO> getAll() {
        List<StudentDTO> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select students.id, students.name, students.address, students.email, students.mark, classes.name as className from student_management.students join student_management.classes on students.class_id = classes.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            int id;
            String name;
            String email;
            String address;
            double mark;
            String className;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                email = resultSet.getString("email");
                mark = resultSet.getDouble("mark");
                className = resultSet.getString("className");
                students.add(new StudentDTO(id, name, address, email, mark, className));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public void add(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("insert into student_management.students (name,address,email,mark,class_id) values (?,?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setDouble(4, student.getMark());
            preparedStatement.setInt(5, student.getClassId());
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
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("update student_management.students set name = ?, address = ?, email = ?, mark = ?, class_id = ? where id = ?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setDouble(4, student.getMark());
            preparedStatement.setInt(5, student.getClassId());
            preparedStatement.setInt(6, student.getId());
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
            int classId;
            while (resultSet.next()) {
//                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                email = resultSet.getString("email");
                mark = resultSet.getDouble("mark");
                classId = resultSet.getInt("class_id");
                student = new Student(id, name, address, email, mark,classId);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
