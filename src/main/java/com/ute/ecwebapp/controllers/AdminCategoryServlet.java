package com.ute.ecwebapp.controllers;

import com.ute.ecwebapp.beans.Category;
import com.ute.ecwebapp.utils.ServletUtils;
import com.ute.ecwebapp.models.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "AdminCategoryServlet", value = "/Admin/Category/*")
public class AdminCategoryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
//                Category c = new Category(1, "Điện thoại");
//                request.setAttribute("category", c);

                List<Category> list = CategoryModel.findAll();
                request.setAttribute("categories", list);

                ServletUtils.foward("/views/vwCategory/Index.jsp", request, response);
                break;
            default:
                ServletUtils.foward("/views/404.jsp", request, response);
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}