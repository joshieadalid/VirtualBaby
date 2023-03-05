package com.virtualbaby.connection;

import com.virtualbaby.entities.*;

import java.sql.*;
import java.util.ArrayList;

public class MySQL {
    private static MySQL instance = null;
    Connection connection;

    public MySQL() {
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

    public static MySQL getInstance() {
        if (instance == null) {
            instance = new MySQL();
        }
        return instance;
    }

    public static void main(String[] args) {
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

    void closeConnection() throws SQLException {
        connection.close();
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("Clase cargada");
    }

    private void loadConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Virtual_Baby", "root", "root");
        System.out.println("Conexión establecida");
    }

    public Usuario getUser(String user, String password) throws SQLException {
        String query = "SELECT * FROM Usuario WHERE idUsuario=? AND password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(resultSet.getString(1));
        usuario.setNombreUsuario(resultSet.getString(2));
        usuario.setAp_paterno(resultSet.getString(3));
        usuario.setAp_materno(resultSet.getString(4));
        usuario.setEmail(resultSet.getString(5));
        usuario.setTelefono(resultSet.getString(6));
        usuario.setPassword(resultSet.getString(7));
        usuario.setTipo(resultSet.getString(8));

        preparedStatement.close();
        return usuario;
    }

    public ArrayList<Nino> getChildrenList() throws SQLException {
        String query = "SELECT * FROM Niño";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Nino> childrenList = new ArrayList<>();

        while(resultSet.next()){
            Nino nino = new Nino();
            nino.setIdNino(resultSet.getString(1));
            nino.setFechaNacimiento(resultSet.getString(2));
            nino.setNombreNino(resultSet.getString(3));
            nino.setAp_paterno(resultSet.getString(4));
            nino.setAp_materno(resultSet.getString(5));
            childrenList.add(nino);
        }
        preparedStatement.close();
        return childrenList;
    }
}
