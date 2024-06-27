package com.codegyme.simple_login.controllers;

import com.codegyme.simple_login.services.IValidateAccount;
import com.codegyme.simple_login.services.impl.ValidateAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Maincontroller", value = "/login")
public class MainController extends HttpServlet {
    IValidateAccount validateAccount = new ValidateAccount();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isValid = validateAccount.checkLogin(username,password);
        req.setAttribute("isValid",isValid);
        req.getRequestDispatcher("login_result.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
