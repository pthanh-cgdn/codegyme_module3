package com.codegyme.customer_list.controllers;

import com.codegyme.customer_list.models.Customer;
import com.codegyme.customer_list.services.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="MainController",value="/customer")
public class MainController extends HttpServlet {
    private CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.getAll();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("/customer/customer.jsp").forward(req, resp);
    }
}
