package com.virtualbaby.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    private static MySQL instance = null;
    Connection connection;
    public MySQL(){
        try {
            loadDriver();
        } catch (ClassNotFoundException e) {
            System.out.println("Dependencia de MariaDB no cargada");
        }
        try {
            loadConnection();
        } catch (SQLException e) {
            System.out.println("Error al cargar la conexión");
        }
    }

    public static MySQL getInstance(){
        if (instance == null){
            instance = new MySQL();
        }
        return instance;
    }

    void closeConnection() throws SQLException {
        connection.close();
    }
    private void loadDriver() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("Clase cargada");
    }
    private void loadConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Virtual_Baby","root","root");
        System.out.println("Conexión establecida");
    }

    public static void main(String[] args)
    {
        try {
            MySQL.getInstance().loadDriver();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            MySQL.getInstance().closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
