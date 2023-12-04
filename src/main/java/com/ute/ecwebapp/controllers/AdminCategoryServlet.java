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
                // Category c = new Category(2, "Điện thoại");
                // request.setAttribute("category", c);

                List<Category> list = CategoryModel.findAll();
                request.setAttribute("categories", list);
                ServletUtils.foward("/views/vwCategory/Index.jsp", request, response);
                break;

            case "/Add":
                ServletUtils.foward("/views/vwCategory/Add.jsp", request, response);
                break;

            case "/Edit":
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (NumberFormatException ignored) {
                }

                Category c = CategoryModel.findById(id);
                if (c != null) {
                    request.setAttribute("category", c);
                    ServletUtils.foward("/views/vwCategory/Edit.jsp", request, response);
                } else {
//                    ServletUtils.redicrect("/Admin/Category", request, response);
                }
                break;

            default:
                ServletUtils.foward("/views/404.jsp", request, response);
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Add":
                addCategory(request, response);
                break;


            case "/Delete":
                deleteCategory(request, response);
                break;


            case "/Update":
                updateCategory(request, response);
                break;

            default:
                ServletUtils.foward("/views/404.jsp", request, response);
                break;

        }
    }

    private static void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("CatName");
        Category c = new Category(0, name);
        CategoryModel.add(c);
        ServletUtils.foward("/views/vwCategory/Add.jsp", request, response);
    }
    private static void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("CatID"));
        String name = request.getParameter("CatName");
        Category c = new Category(id, name);
        CategoryModel.update(c);
        ServletUtils.redicrect("/Admin/Category", request, response);
    }
    private static void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("CatID"));
        CategoryModel.delete((id));
        ServletUtils.redicrect("/Admin/Category", request, response);
    }
}