package com.virtualbaby.servlets;

import com.virtualbaby.connection.MySQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import com.virtualbaby.entities.Usuario;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String loginButton = request.getParameter("loginButton");

        if (loginButton != null){
            Usuario loggedUser;
            try {
                loggedUser= MySQL.getInstance().getUser(user,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (Objects.equals(loggedUser.getTipo(), "Tutor")){
                getServletContext().getRequestDispatcher("/personal_report.jsp").forward(request,response);
                response.getWriter().println("<p>Hola papá</p>");
            }

            if (Objects.equals(loggedUser.getTipo(), "Profesor")){
                getServletContext().getRequestDispatcher("/teachers_view.jsp").forward(request,response);
                response.getWriter().println("<p>Hola profe</p>");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
