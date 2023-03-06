package com.virtualbaby.servlets;

import com.virtualbaby.connection.MySQL;
import com.virtualbaby.entities.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String submitLoginButton = request.getParameter("loginButton");

        LOGGER.info(email);
        LOGGER.info(password);
        if (submitLoginButton != null) {
            MySQL mysql = null;
            Usuario loggedUser = null;
            try {
                mysql = MySQL.getInstance();
                loggedUser = mysql.getUser(email, password);
                LOGGER.info("Usuario: " + loggedUser);
            } catch (Exception e) {
                LOGGER.severe("Error al obtener el usuario de la base de datos" + e);
                request.setAttribute("error", "Error al obtener el usuario");
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
            if (loggedUser != null) {
                switch (loggedUser.getTipo()) {
                    case "0":
                        LOGGER.warning("Usuario de tipo 0");
                        Nino nino;
                        try {
                            nino = mysql.getNino(loggedUser.getIdUsuario());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                        List<Comida> foodList;
                        try {
                            foodList = mysql.getComidaList(nino.getIdNino(), LocalDate.parse("2023-03-02"));
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                        List<Sueno> sleepList;
                        try {
                            sleepList = mysql.getSuenoList(nino.getIdNino(), LocalDate.parse("2023-03-02"));
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        List<Bano> evacuationList;
                        try {
                            evacuationList = mysql.getBanoList(nino.getIdNino(), LocalDate.parse("2023-03-02"));
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        Usuario teacher;
                        try {
                            teacher = mysql.getTeacherDataByGroup(nino.getIdGrupo());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        request.setAttribute("nino", nino);
                        request.setAttribute("tutor", loggedUser);
                        request.setAttribute("foodList", foodList);
                        request.setAttribute("sleepList", sleepList);
                        request.setAttribute("evacuationList", evacuationList);
                        request.setAttribute("teacher", teacher);
                        getServletContext().getRequestDispatcher("/tutorReportView.jsp").forward(request, response);
                        break;
                    case "1":
                        LOGGER.warning("Usuario de tipo 1");
                        String groupId;
                        try {
                            groupId = mysql.getGroupTeacher(loggedUser.getIdUsuario());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        List<Nino> childrenList;
                        try {
                            childrenList = mysql.getChildrenList(groupId);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        request.setAttribute("childrenList", childrenList);
                        request.setAttribute("teacher", loggedUser);
                        request.setAttribute("groupId", groupId);

                        getServletContext().getRequestDispatcher("/teacherView.jsp").forward(request, response);
                        break;
                    case "2":
                        // TODO: Caso admin
                    default:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                        break;
                }
            }

        }
    }

}

