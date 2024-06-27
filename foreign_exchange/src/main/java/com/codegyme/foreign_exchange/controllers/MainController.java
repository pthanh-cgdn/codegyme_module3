package com.codegyme.foreign_exchange.controllers;

import com.codegyme.foreign_exchange.services.Convert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainController",value="/convert")
public class MainController extends HttpServlet {
    Convert convert = new Convert();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double usd = Double.parseDouble(req.getParameter("usd"));
        double rate = Double.parseDouble(req.getParameter("rate"));
        double vnd = convert.exchange(usd,rate);
        req.setAttribute("vnd",vnd);
        req.getRequestDispatcher("convert.jsp").forward(req,resp);
    }
}
