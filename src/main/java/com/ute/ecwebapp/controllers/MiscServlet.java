package com.ute.ecwebapp.controllers;

import com.ute.ecwebapp.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "MiscServlet", value = "/Misc/*")
@MultipartConfig(
        fileSizeThreshold = 2 * 1024 * 1024,
        maxFileSize = 50 * 1024 * 1024,
        maxRequestSize = 50 * 1024 * 1024
)
public class MiscServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Editor":
                ServletUtils.foward("/views/vwMisc/Editor.jsp", request, response);
                break;

            case "/Upload":
                ServletUtils.foward("/views/vwMisc/Upload.jsp", request, response);
                break;

            default:
                ServletUtils.foward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String path = request.getPathInfo();
        switch (path) {
            case "/Editor":
                postEditor(request, response);
                break;

            case "/Upload":
                postUpload(request, response);
                break;

            default:
                ServletUtils.foward("/views/404.jsp", request, response);
                break;
        }
    }

    private void postUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("ProName"));

        // Collection<Part> parts = request.getParts();
        // System.out.println(parts.size());

        for (Part part : request.getParts()) {
            // System.out.println(part.getName());
            // for (String headerName : part.getHeaderNames()) {
            //   System.out.println(headerName);
            // }

            if (part.getName().equals("fuMain")) {
                String contentDisposition = part.getHeader("content-disposition");
                // System.out.println(contentDisposition);
                String[] items = contentDisposition.split(";");
                for (String s : items) {
                    String tmp = s.trim();
                    if (tmp.startsWith("filename")) {
                        int idx = tmp.indexOf("=") + 2;
                        String filename = tmp.substring(idx, tmp.length() - 1);

                        String targetDir = this.getServletContext().getRealPath("public/user-avatars");
                        File dir = new File(targetDir);
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                        String destination = targetDir + "/" + filename;
                        part.write(destination);
                    }
                }
            }
        }

        ServletUtils.foward("/views/vwMisc/Upload.jsp", request, response);
    }

    private void postEditor(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String tinyDesc = request.getParameter("TinyDes");
        System.out.println(tinyDesc);

        String desc = request.getParameter("FullDes");
        System.out.println(desc);

        ServletUtils.foward("/views/vwMisc/Editor.jsp", request, response);
    }
}