package com.virtualbaby.servlets;

import com.virtualbaby.connection.MySQL;
import com.virtualbaby.entities.Nino;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "TutorReportServlet", value = "/TutorReportServlet")
public class TutorReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        Nino nino = (Nino) request.getAttribute("nino");
        String changeDateButton = request.getParameter("changeDateButton");
        System.out.println(nino);
        if (changeDateButton != null){

            try {
                request.setAttribute("nino",nino);
                request.setAttribute("foodList", MySQL.getInstance().getComidaList(nino.getIdNino(),date));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            getServletContext().getRequestDispatcher("/tutorReportView.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
