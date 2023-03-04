package com.virtualbaby.connection;

import com.virtualbaby.entities.Usuario;

import java.sql.*;
import java.util.ArrayList;

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

    ArrayList<Usuario> getUser(String user, String password) throws SQLException {
        String query = "SELECT * FROM Usuario WHERE idUsuario=? AND password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Usuario> users = new ArrayList<>();
        while (resultSet.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(resultSet.getString(1));
            usuario.setNombreUsuario(resultSet.getString(2));
            usuario.setAp_paterno(resultSet.getString(3));
            usuario.setAp_materno(resultSet.getString(4));
            usuario.setEmail(resultSet.getString(5));
            usuario.setTelefono(resultSet.getString(6));
            usuario.setPassword(resultSet.getString(7));
            usuario.setTipo(resultSet.getString(8));
            users.add(usuario);
        }
        preparedStatement.close();
        return users;
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
