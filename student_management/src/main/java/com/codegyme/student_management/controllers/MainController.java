package com.codegyme.student_management.controllers;

import com.codegyme.student_management.models.Student;
import com.codegyme.student_management.services.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name="MainController", urlPatterns="/students")
public class MainController extends HttpServlet {
    StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            default:
                listStudents(req, resp);
                break;
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.getStudentById(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void listStudents(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = studentService.getAll();
        request.setAttribute("students", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("students/display.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                updateStudent(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            default:
                break;

        }
    }
    public void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        try {
            response.sendRedirect("/students");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        double mark = Double.parseDouble(req.getParameter("mark"));

        Student student = new Student(id, name, address, email, mark);
        studentService.save(student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/create.jsp");
        req.setAttribute("message", "New student was created");

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        double mark = Double.parseDouble(req.getParameter("mark"));
        Student student = new Student(id, name, address, email, mark);
        studentService.edit(student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/edit.jsp");
        req.setAttribute("message", "Student information was updated");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
