package com.codegyme.student_management.dto;

public class StudentDTO {
    private int id;
    private String name;
    private String address;
    private String email;
    private double mark;
    private String className;

    public StudentDTO(int id, String name, String address, String email, double mark, String className) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mark = mark;
        this.className = className;
    }

    public StudentDTO(String name, String address, String email, double mark) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mark = mark;
    }

    public StudentDTO(String name, String address, String email, double mark, String classId) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mark = mark;
        this.className = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
