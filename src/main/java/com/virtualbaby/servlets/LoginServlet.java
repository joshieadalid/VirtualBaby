package com.virtualbaby.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType = request.getParameter("userType");
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String loginButton = request.getParameter("loginButton");

        if (loginButton != null){
            if (Objects.equals(userType, "parent")){
                getServletContext().getRequestDispatcher("/personal_report.jsp").forward(request,response);
                response.getWriter().println("<p>Hola papá</p>");
            }

            if (Objects.equals(userType, "professor")){
                getServletContext().getRequestDispatcher("/teachers_view.jsp").forward(request,response);
                response.getWriter().println("<p>Hola profe</p>");
            }

            if (Objects.equals(userType, "admin")){
                getServletContext().getRequestDispatcher("/teachers_view.jsp").forward(request,response);
                response.getWriter().println("<p>Hola administrador</p>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
