package com.codegyme.student_management.repositories;

import com.codegyme.student_management.dto.StudentDTO;
import com.codegyme.student_management.models.Classes;
import com.codegyme.student_management.models.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository {
    private List<Classes> students = new ArrayList<>();

    public ClassRepository() {
    }

    public List<Classes> getAll() {
        List<Classes> classes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select * from student_management.classes");
            ResultSet resultSet = preparedStatement.executeQuery();
            int id;
            String name;

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                classes.add(new Classes(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return classes;
    }
}
