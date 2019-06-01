package com.hochnt.controller.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home.html")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*System.out.println("abcde");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.print("Hello demo");*/
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/web.jsp"); // muon hien thi view nao thif truyen path cua file jsp vao (views)
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
