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

@WebServlet(name = "TutorReportServlet", value = "/TutorReportServlet")
public class TutorReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String ninoId = request.getParameter("ninoId");
        String changeDateButton = request.getParameter("changeDateButton");
        System.out.println(ninoId);
        if (changeDateButton != null) {
            Nino nino;
            try {
                nino = MySQL.getInstance().getNinoWithNinoId(ninoId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                request.setAttribute("nino", nino);
                request.setAttribute("foodList", MySQL.getInstance().getComidaList(nino.getIdNino(), date));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            List<Comida> foodList;
            try {
                foodList = MySQL.getInstance().getComidaList(nino.getIdNino(), date);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            List<Sueno> sleepList;
            try {
                sleepList = MySQL.getInstance().getSuenoList(nino.getIdNino(), date);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            List<Bano> evacuationList;
            try {
                evacuationList = MySQL.getInstance().getBanoList(nino.getIdNino(), date);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Usuario teacher;
            try {
                teacher = MySQL.getInstance().getTeacherDataByGroup(nino.getIdGrupo());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Usuario tutor;
            try {
                 tutor = MySQL.getInstance().getUserById(nino.getIdTutor());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("nino", nino);
            request.setAttribute("tutor", tutor);
            request.setAttribute("foodList", foodList);
            request.setAttribute("sleepList", sleepList);
            request.setAttribute("evacuationList", evacuationList);
            request.setAttribute("teacher", teacher);
            getServletContext().getRequestDispatcher("/tutorReportView.jsp").forward(request, response);
        }
    }
}
