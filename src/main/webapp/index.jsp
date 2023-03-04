<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Log in</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<header>
    <h1>VirtualBaby</h1>
    <hr>
</header>
<main>
    <h2>Iniciar sesión</h2>
    <form name="loginForm" method="get" action="loginServlet">
        <label for="perfil">Seleccione perfil:</label>
        <select id="perfil" name="userType">
            <option value="Administrador">Administrador</option>
            <option value="Profesor">Profesor</option>
            <option value="Tutor">Tutor</option>
        </select>

        <label for="user">Usuario:</label>
        <input type="text" id="user" name="user" placeholder="Usuario" size="30" maxlength="5">
        <br>
        <label for="password">Contraseña:</label>
        <input type="password" name="password" id="password" placeholder="Contraseña" size="30" maxlength="20">
        <br>

        <input type="submit" name="loginButton" value="Entrar">
    </form>
</main>
<footer></footer>
</body>
</html>
