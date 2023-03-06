package com.virtualbaby.connection;

import com.virtualbaby.entities.*;

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
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Virtual_Baby", "root", "root");
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
    public Nino getNinoWithNinoId(String idNino) throws SQLException {
        String query = "SELECT * from Niño WHERE idNiño = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idNino);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Nino nino = new Nino();
                    nino.setIdNino(resultSet.getString("idNiño"));
                    nino.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                    nino.setNombreNino(resultSet.getString("nombreNiño"));
                    nino.setAp_paterno(resultSet.getString("ap_paterno"));
                    nino.setAp_materno(resultSet.getString("ap_materno"));
                    nino.setIdTutor(resultSet.getString("idTutor"));
                    nino.setIdGrupo(resultSet.getString("idGrupo"));

                    return nino;
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
public Usuario getUserById(String idUsuario) throws SQLException {
        String query = "SELECT * from Usuario WHERE idUsuario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idUsuario);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(resultSet.getString("idUsuario"));
                    usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
                    usuario.setAp_paterno(resultSet.getString("ap_paterno"));
                    usuario.setAp_materno(resultSet.getString("ap_materno"));
                    usuario.setEmail(resultSet.getString("email"));
                    usuario.setTelefono(resultSet.getString("telefono"));
                    usuario.setPassword(resultSet.getString("password"));
                    usuario.setTipo(resultSet.getString("tipo"));
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

    public Usuario getTeacherDataByGroup(String idGrupo) throws SQLException {
        String query = "SELECT Usuario.* FROM Grupo LEFT JOIN Usuario ON Grupo.idProfesor = Usuario.idUsuario WHERE Grupo.idGrupo = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idGrupo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Usuario profesor = new Usuario();
                profesor.setTipo(resultSet.getString("idUsuario"));
                profesor.setNombreUsuario(resultSet.getString("nombreUsuario"));
                profesor.setAp_paterno(resultSet.getString("ap_paterno"));
                profesor.setAp_materno(resultSet.getString("ap_materno"));
                profesor.setEmail(resultSet.getString("email"));
                profesor.setTelefono(resultSet.getString("telefono"));
                profesor.setPassword(resultSet.getString("password"));
                profesor.setTipo(resultSet.getString("tipo"));
                return profesor;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new SQLException("Error al obtener el profesor por el grupo");
        }
    }



    public List<Comida> getComidaList(String idNino, LocalDate date) throws SQLException {
        String query = "SELECT Comida.* FROM Reporte LEFT JOIN Comida ON Reporte.idReporte = Comida.idReporte WHERE Reporte.idNiño = ? AND Reporte.fecha = ?";
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

    public List<Bano> getBanoList(String idNino, LocalDate date) throws SQLException {
        String query = "SELECT Baño.* FROM Reporte LEFT JOIN Baño  ON Reporte.idReporte = Baño.idReporte WHERE Reporte.idNiño = ? AND Reporte.fecha = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idNino);
            statement.setDate(2, Date.valueOf(date));
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Bano> banoList = new ArrayList<>();

                while (resultSet.next()) {
                    Bano bano = new Bano();
                    bano.setIdBano(resultSet.getString("idBaño"));
                    bano.setHora(resultSet.getString("hora"));
                    bano.setTipo(resultSet.getString("tipo"));
                    bano.setIdReporte(resultSet.getString("idReporte"));
                    bano.setObsBano(resultSet.getString("obsBaño"));
                    banoList.add(bano);
                }
                return banoList;
            } catch (SQLException e) {
                throw new SQLException("Consulta sin resultados");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener la lista de baño", e);
        }
    }

    public List<Sueno> getSuenoList(String idNino, LocalDate date) throws SQLException {
        String query = "SELECT Sueño.* FROM Reporte LEFT JOIN Sueño  ON Reporte.idReporte = Sueño.idReporte WHERE Reporte.idNiño = ? AND Reporte.fecha = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, idNino);
            statement.setDate(2, Date.valueOf(date));
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Sueno> suenoList = new ArrayList<>();

                while (resultSet.next()) {
                    Sueno sueno = new Sueno();
                    sueno.setIdSueno(resultSet.getString("idSueño"));
                    sueno.setHoraInicio(resultSet.getString("horaInicio"));
                    sueno.setHoraFin(resultSet.getString("horaFin"));
                    sueno.setObsSueno(resultSet.getString("obsSueño"));
                    sueno.setIdReporte(resultSet.getString("idReporte"));
                    suenoList.add(sueno);
                }
                return suenoList;
            } catch (SQLException e) {
                throw new SQLException("Consulta sin resultados");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener la lista de sueño", e);
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
                    nino.setIdGrupo(resultSet.getString("idGrupo"));
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

    public static void main(String[] args) {
        try {
            getInstance().getUser("maria.rodriguez@mai","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Nino n0001 = getInstance().getNinoWithNinoId("N0001");
            System.out.println(n0001);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
