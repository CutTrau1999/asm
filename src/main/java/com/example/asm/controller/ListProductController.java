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

public class ListProductController extends HttpServlet {

    

    private ProductModel productModel = new ProductModel();
    private CategoryModel categoryModel = new CategoryModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> listCategory = categoryModel.findAll();
        req.setAttribute("listCategory", listCategory);
        req.setCharacterEncoding("UTF-8");
        ArrayList<Product> listProduct = productModel.findAll();

        req.setAttribute("list", listProduct);
        req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
    }
}
