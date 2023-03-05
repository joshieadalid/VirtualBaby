package com.virtualbaby.connection;

import com.virtualbaby.entities.Comida;
import com.virtualbaby.entities.Nino;
import com.virtualbaby.entities.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySQL implements AutoCloseable {
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



    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("Clase cargada");
    }

    private void loadConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Virtual_Baby", "root", "");
        System.out.println("Conexión establecida");
    }

    public Usuario getUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM Usuario WHERE email=? AND password=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(resultSet.getString(1));
                    usuario.setNombreUsuario(resultSet.getString(2));
                    usuario.setAp_paterno(resultSet.getString(3));
                    usuario.setAp_materno(resultSet.getString(4));
                    usuario.setEmail(resultSet.getString(5));
                    usuario.setTelefono(resultSet.getString(6));
                    usuario.setPassword(resultSet.getString(7));
                    usuario.setTipo(resultSet.getString(8));
                    return usuario;
                } else {
                    return null;
                }
            } catch (Exception e) {
                throw new SQLException("Consulta sin resultados");
            }
        } catch (Exception e) {
            throw new SQLException("Error en la consulta");
        }
    }

    public List<Nino> getChildrenList(String groupId) throws SQLException {
        String query = "SELECT * FROM Niño WHERE idGrupo=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, groupId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Nino> children = new ArrayList<>();

                while (resultSet.next()) {
                    Nino child = new Nino();
                    child.setIdNino(resultSet.getString("idNiño"));
                    child.setNombreNino(resultSet.getString("nombreNiño"));
                    child.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                    child.setAp_paterno(resultSet.getString("ap_paterno"));
                    child.setAp_materno(resultSet.getString("ap_materno"));
                    children.add(child);
                }
                return children;
            } catch (SQLException e) {
                throw new SQLException("Consulta sin resultados");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener la lista de niños", e);
        }
    }



    public String getGroupTeacher(String idUser) throws SQLException {
        String query = "SELECT idGrupo FROM Grupo WHERE idProfesor = ?";
        System.out.println(idUser);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idUser);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("idGrupo");
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new SQLException("Error al obtener el grupo del profesor");
        }
    }

    public List<Comida> getComidaList(String idNino, LocalDate date) throws SQLException {
        String query = "SELECT Comida.cantidad, Comida.nombreComida, Comida.hora, Comida.obsComida FROM Reporte LEFT JOIN Comida ON Reporte.idReporte = Comida.idReporte WHERE Reporte.idNiño = ? AND Reporte.fecha = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idNino);
            statement.setDate(2, Date.valueOf(date));
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Comida> comidaList = new ArrayList<>();

                while (resultSet.next()) {
                    Comida comida = new Comida();
                    comida.setCantidad(resultSet.getString("cantidad"));
                    comida.setNombreComida(resultSet.getString("nombreComida"));
                    comida.setHora(resultSet.getString("hora"));
                    comida.setObsComida(resultSet.getString("obsComida"));
                    comidaList.add(comida);
                }
                return comidaList;
            } catch (SQLException e) {
                throw new SQLException("Consulta sin resultados");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener la lista de comida", e);
        }
    }


    public Nino getNino(String idUsuario) throws SQLException {
        String query = "SELECT Niño.* FROM `Niño` LEFT JOIN Usuario ON Usuario.idUsuario=Niño.idTutor WHERE Usuario.idUsuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idUsuario);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()){
                    Nino nino = new Nino();
                    nino.setIdNino(resultSet.getString("idNiño"));
                    nino.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                    nino.setNombreNino(resultSet.getString("nombreNiño"));
                    nino.setAp_paterno(resultSet.getString("ap_paterno"));
                    nino.setAp_materno(resultSet.getString("ap_materno"));
                    nino.setIdTutor(resultSet.getString("idTutor"));
                    nino.setGrupo(resultSet.getString("idGrupo"));
                    return nino;
                }else{
                    return null;
                }
            }catch (SQLException e){
                throw new SQLException("Consulta sin resultados");
            }
        } catch (SQLException e) {
            throw new SQLException("Se perdió el niño", e);
        }
    }

}
