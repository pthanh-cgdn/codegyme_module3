package com.codegyme.discount_cal.controllers;

import com.codegyme.discount_cal.services.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="MainController",value="/discount")
public class MainController extends HttpServlet {
    private Calculator calculator = new Calculator();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int price = 1000000000;
        double discount = 0.2;
        int priceAfterDiscount = calculator.calDiscount(price,discount);
        req.setAttribute("priceAfterDiscount",priceAfterDiscount);
        req.getRequestDispatcher("discount.jsp").forward(req,resp);

    }
}
