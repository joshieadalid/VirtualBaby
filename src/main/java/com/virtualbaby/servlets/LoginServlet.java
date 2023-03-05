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
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_LOGIN_BUTTON = "loginButton";

    private static final String ATTR_CHILDREN_LIST = "childrenList";
    private static final String ATTR_TEACHER = "teacher";

    private static final String VIEW_TEACHER = "/teacherView.jsp";
    private static final String VIEW_ERROR = "/error.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter(PARAM_EMAIL);
        String password = request.getParameter(PARAM_PASSWORD);
        String submitLoginButton = request.getParameter(PARAM_LOGIN_BUTTON);

        if (submitLoginButton != null) {
            try {
                Usuario loggedUser = MySQL.getInstance().getUser(email, password);
                LOGGER.info("Usuario logueado: " + loggedUser);

                switch (loggedUser.getTipo()) {
                    case "1":
                        List<Nino> childrenList = MySQL.getInstance().getChildrenList();
                        request.setAttribute(ATTR_CHILDREN_LIST, childrenList);
                        request.setAttribute(ATTR_TEACHER, loggedUser);
                        getServletContext().getRequestDispatcher(VIEW_TEACHER).forward(request, response);
                        break;
                    case "2":
                        // TODO: Implementar lógica para el tipo 2
                        break;
                    default:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                        break;
                }
            } catch (Exception e) {
                LOGGER.severe("Error al obtener el usuario de la base de datos" + e);
                request.setAttribute("error", "Error al obtener el usuario");
                getServletContext().getRequestDispatcher(VIEW_ERROR).forward(request, response);
            }
        }
    }
}

