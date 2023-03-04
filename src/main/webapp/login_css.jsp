<%--
  Created by IntelliJ IDEA.
  User: Angel
  Date: 04/03/2023
  Time: 12:31 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Log in</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="bar">
    <h1>  Virtual Baby</h1>
</div>

<div class="container">
    <h2>INICIO DE SESIÓN</h2>
    <form method="get" action="${pageContext.request.contextPath}/LoginServlet">
        <label for="userType">PERFIL:</label>
        <select name="userType" id="userType">
            <option value="admin">Administrador</option>
            <option value="professor">Profesor</option>
            <option value="tutor">Tutor</option>
        </select>
        <br><br>
        <label for="user">USUARIO:</label>
        <input type="text" id="user" name="user" placeholder="Ingrese su usuario" required>
        <br><br>
        <label for="password">CONTRASEÑA:</label>
        <input type="password" id="password" name="password" placeholder="Ingrese su contraseña" required>
        <br><br>
        <input type="submit" value="submit">
    </form>

</div>
</body>
</html>
