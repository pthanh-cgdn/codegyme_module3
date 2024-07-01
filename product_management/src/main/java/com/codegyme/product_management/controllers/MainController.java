package com.codegyme.product_management.controllers;

import com.codegyme.product_management.models.Product;
import com.codegyme.product_management.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name="MainController", urlPatterns = "/product")
public class MainController extends HttpServlet {
    private ProductService productService = new ProductService();
    private List<Product> products = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("product/create.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Product productToEdit = productService.findProductById(id);
                req.setAttribute("product", productToEdit);
                req.getRequestDispatcher("product/edit.jsp").forward(req, resp);
                break;
            default:
                products = productService.getAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("product/display.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Product product = null;
        String name;
        String categoryName;
        String manufacture;
        int price;
        int id;

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                 name = req.getParameter("name");
                 categoryName = req.getParameter("categoryName");
                 manufacture = req.getParameter("manufacture");price = Integer.parseInt(req.getParameter("price"));
                product = new Product(name, categoryName,manufacture,price);
                boolean isAdded = productService.addProduct(product);
                if (isAdded) {
                    req.setAttribute("message", "Product is successfully added");
                } else {
                    req.setAttribute("message", "Product is not added");
                }
                req.getRequestDispatcher("product/create.jsp").forward(req, resp);
                break;
            case "delete":
                int productId = Integer.parseInt(req.getParameter("id"));
                product = productService.findProductById(productId);
                if (product == null) {
                    req.setAttribute("message", "Product is not found");
                    req.getRequestDispatcher("product/display.jsp").forward(req, resp);
                } else {
                    productService.remove(product);
                    resp.sendRedirect("product/display.jsp");
                }
                break;
            case "edit":
                id = Integer.parseInt(req.getParameter("id"));
                name = req.getParameter("name");
                categoryName = req.getParameter("categoryName");
                manufacture = req.getParameter("manufacture");
                price = Integer.parseInt(req.getParameter("price"));
                product = new Product(name, categoryName,manufacture,price);
                boolean isEdited = productService.editProduct(id,product);
                if (isEdited) {
                    req.setAttribute("message", "Product is successfully edited");
                } else {
                    req.setAttribute("message", "Product is not edited");
                }
//                req.getRequestDispatcher("product/edit.jsp").forward(req, resp);
                products = productService.getAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("product/display.jsp").forward(req, resp);
                break;
            case "search":
                String searchContent = req.getParameter("search");
                products = productService.search(searchContent);
                req.setAttribute("products", products);
                req.getRequestDispatcher("/product/search.jsp").forward(req, resp);
        }
    }
}
