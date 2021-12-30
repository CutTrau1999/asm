package com.example.asm.controller;

import com.example.asm.Model.CategoryModel;
import com.example.asm.Model.ProductModel;
import com.example.asm.entity.Category;
import com.example.asm.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateProductController extends HttpServlet {

    private ProductModel productModel = new ProductModel();
    private CategoryModel categoryModel = new CategoryModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> listCategory = categoryModel.findAll();
        req.setAttribute("listCategory", listCategory);
        req.getRequestDispatcher("/product/form.jsp").forward(req, resp);
        req.setAttribute("product", new Product());
        req.setAttribute("errors",new HashMap<String, String >());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            String name = req.getParameter("name");
            String idDM = req.getParameter("idDM");
            String description = req.getParameter("description");
            String thumbnail = req.getParameter("thumbnail");
            double price = Double.parseDouble(req.getParameter("price"));
            String sellday = req.getParameter("sellday");
            String editday = req.getParameter("editday");
            String status = req.getParameter("status");
            Product g = new Product(name, idDM, description, thumbnail,price,sellday,editday,status);
            if(!g.isValid()){

                ArrayList<Category> listCategory = categoryModel.findAll();
                req.setAttribute("listCategory", listCategory);
                req.setAttribute("product",g);
                req.setAttribute("errors",g.getErrors());
                req.getRequestDispatcher("/product/form.jsp").forward(req, resp);
                return;
            }
            if (productModel.save(g)){
              resp.sendRedirect("/product/list");
            }
            resp.sendRedirect("/product/list");
        }catch (Exception ex) {
            resp.getWriter().println("Error");
        }
    }
}

