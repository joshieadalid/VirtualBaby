<%@ page import="com.virtualbaby.entities.Nino" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.virtualbaby.entities.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 04/03/2023
  Time: 04:08 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
    <link rel="stylesheet" href="css/tutorStyle.css">
</head>
<body>

<div class="bar">
    <h1> Menu del profesor</h1>
</div>
<div class="blocky">
    <table>
        <tr>
            <td>
                <%Usuario teacher = (Usuario) request.getAttribute("teacher");%>
                <label for="Nombre_Completo">NOMBRE: <%=teacher.getNombreUsuario()%> <%=teacher.getAp_paterno()%> <%=teacher.getAp_materno()%></label>
                <label for="Grupo">GRUPO: </label>
            </td>
            <td class="respuesta">
                <label for="Nombre_Completo" class="respuesta"> juanhjdhsjhdjs jhkahsdj jhasjd </label>
                <label for="Grupo" class="respuesta"> 2bm1</label>
            </td>
        </tr>
    </table>
</div>

<div class="container">
    <h2>Reportes Individuales</h2>

    <table>
        <thead>
        <tr>
            <th>Alumnos</th>
            <th>Visualizar reporte</th>
            <th>Editar reporte</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Nino> childrenList = (ArrayList<Nino>) request.getAttribute("childrenList");
        %>
        <%for (Nino i : childrenList) {%>
        <tr class="suave">
            <td class="shir"><%=i.getNombreNino()%> <%=i.getAp_paterno()%> <%=i.getAp_materno()%>
            </td>
            <td><input type="button" value="Ver"></td>
            <td><input type="button" value="Reporte"></td>
        </tr>
        <%} %>
        </tbody>
    </table><!--Fin de la tabla-->
</div>


<!--Opciones generales-->
<div class="container">
    <h2>Otras opciones...</h2>
    <input type="button" value="Establecer menú grupal">
    <input type="button" value="Establecer hora de sueño grupal">
</div>
</body>
</html>