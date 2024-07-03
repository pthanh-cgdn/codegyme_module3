package com.codegyme.student_management.services;

import com.codegyme.student_management.models.Classes;
import com.codegyme.student_management.repositories.ClassRepository;

import java.util.List;

public class ClassService {
    private ClassRepository classRepository = new ClassRepository();
    public List<Classes> getAll(){
        return classRepository.getAll();
    }
}
