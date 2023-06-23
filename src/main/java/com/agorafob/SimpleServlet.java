package com.agorafob;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


//Simple Servlet
//@WebServlet("/hello")
//public class SimpleServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        if(Objects.nonNull(name)){
//            resp.getWriter().append("Hello, World!").append("I am ").append(name);
//        }else {
//            resp.getWriter().append("Hello, World!");
//        }
//    }

//Simple Http Servlet
//public class SimpleServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html; charset=UTF-8");
//        String userName = req.getParameter("username");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println("<html>");
//        printWriter.println("<body>");
//        if (Objects.isNull(userName)) {
//            printWriter.println("<h1>Hello, Guest!</h1>");
//        } else {
//            printWriter.println("<h1>Hello, " + userName + "</h1>");
//        }
//
//        printWriter.println("</body>");
//        printWriter.println("</html>");
//        printWriter.close();
//
//
//    }

//Simple JSP Servlet
    public class SimpleServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getServletContext().getRequestDispatcher("/hello.jsp").forward(req,resp);

        }

}
