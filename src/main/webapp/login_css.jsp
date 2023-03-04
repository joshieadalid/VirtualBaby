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
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="bar">
    <h1>  Virtual Baby</h1>
</div>

<div class="container">
    <h2>INICIO DE SESIÓN</h2>
    <form>
        <label for="perfil">PERFIL:</label>
        <select name="perfil" id="perfil">
            <option value="administrador">Administrador</option>
            <option value="profesor">Profesor</option>
            <option value="tutor">Tutor</option>
        </select>
        <br><br>
        <label for="usuario">USUARIO:</label>
        <input type="text" id="usuario" name="usuario" placeholder="Ingrese su usuario" required>
        <br><br>
        <label for="contrasena">CONTRASEÑA:</label>
        <input type="password" id="contrasena" name="contrasena" placeholder="Ingrese su contraseña" required>
        <br><br>
        <input type="submit" value="Entrar">
    </form>

</div>
</body>
</html>
