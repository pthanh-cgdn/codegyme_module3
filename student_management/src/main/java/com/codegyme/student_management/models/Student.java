package com.codegyme.student_management.models;

public class Student {
    private int id;
    private String name;
    private String address;
    private String email;
    private double mark;

    public Student(int id, String name, String address, String email, double mark) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mark = mark;
    }

    public Student(String name, String address, String email, double mark) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mark = mark;
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
}
