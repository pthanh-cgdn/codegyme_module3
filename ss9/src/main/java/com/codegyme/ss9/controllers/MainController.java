package com.codegyme.ss9.controllers;

import com.codegyme.ss9.services.ICalculatorService;
import com.codegyme.ss9.services.impl.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name ="MainController" , value ="/main" )
public class MainController extends HttpServlet {
    ICalculatorService calculatorService = new CalculatorService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int a = Integer.parseInt(req.getParameter("a"));
            int b = Integer.parseInt(req.getParameter("b"));
            int c = calculatorService.sum(a,b);
            req.setAttribute("result",c);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
//            resp.sendRedirect("https://www.google.com/");
        }catch(Exception e) {
            out.println("Vui long nhap dung dinh dang");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("main.jsp").forward(req, resp);

    }
}
