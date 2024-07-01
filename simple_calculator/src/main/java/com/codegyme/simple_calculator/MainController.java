package com.codegyme.simple_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="MainController", value = "/result")
public class MainController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double fop = Double.parseDouble(req.getParameter("fop"));
        double sop = Double.parseDouble(req.getParameter("sop"));
        String operator = req.getParameter("operator");
        double result = 0;
        String op="";
        switch (operator) {
            case "add":
                result = fop + sop;
                op="+";
                break;
            case "ded":
                result = fop - sop;
                op="-";
                break;
            case "mul":
                result = fop * sop;
                op="x";
                break;
            case "div":
                result = fop / sop;
                op = "/";
                break;
        }
        req.setAttribute("result", result);
        req.setAttribute("fop", fop);
        req.setAttribute("sop", sop);
        req.setAttribute("operator", op);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
