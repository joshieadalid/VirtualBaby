package com.virtualbaby.servlets;

import com.virtualbaby.connection.MySQL;
import com.virtualbaby.entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String loginButton = request.getParameter("loginButton");

        if (loginButton != null) {
            Usuario loggedUser;
            try {
                loggedUser = MySQL.getInstance().getUser(email, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            System.out.println(loggedUser);
            if (Objects.equals(loggedUser.getTipo(), "1")) {
                try {
                    request.setAttribute("childrenList", MySQL.getInstance().getChildrenList());

                } catch (SQLException e) {
                    System.out.println("Error en la consulta SQL");
                    throw new RuntimeException(e);
                }
                request.setAttribute("teacher",loggedUser);
                getServletContext().getRequestDispatcher("/teacherView.jsp").forward(request, response);
                response.getWriter().println("<p>Hola papá</p>");
            }

            if (Objects.equals(loggedUser.getTipo(), "Tutor")) {
                getServletContext().getRequestDispatcher("/.jsp").forward(request, response);
                response.getWriter().println("<p>Hola profe</p>");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
