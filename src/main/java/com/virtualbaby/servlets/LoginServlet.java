package com.virtualbaby.servlets;

import com.virtualbaby.connection.MySQL;
import com.virtualbaby.entities.Comida;
import com.virtualbaby.entities.Nino;
import com.virtualbaby.entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
            MySQL mysql;
            try {
                mysql = MySQL.getInstance();
                Usuario loggedUser = mysql.getUser(email, password);
                LOGGER.info("Usuario logueado: " + loggedUser);

                switch (loggedUser.getTipo()) {
                    case "0":
                        System.out.println(loggedUser);
                        Nino nino = mysql.getNino(loggedUser.getIdUsuario());
                        List<Comida> foodList = mysql.getComidaList(nino.getIdNino(), LocalDate.parse("2023-03-02"));
                        request.setAttribute("nino", nino);
                        request.setAttribute("tutor",loggedUser);
                        request.setAttribute("foodList", foodList);
                        getServletContext().getRequestDispatcher("/tutorReportView.jsp").forward(request, response);
                        break;
                    case "1":
                        String groupId = mysql.getGroupTeacher(loggedUser.getIdUsuario());
                        List<Nino> childrenList = mysql.getChildrenList(groupId);
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
            } catch (Exception e) {
                LOGGER.severe("Error al obtener el usuario de la base de datos" + e);
                request.setAttribute("error", "Error al obtener el usuario");
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
    }

}

