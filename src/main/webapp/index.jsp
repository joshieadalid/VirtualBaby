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
    <form>
        <label for="perfil">Seleccione perfil:</label>
        <select id="perfil" name="perfil">
            <option value="Administrador">Administrador</option>
            <option value="Profesor">Profesor</option>
            <option value="Tutor">Tutor</option>
        </select>
        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" placeholder="Usuario" size="30" maxlength="5">
        <br>
        <label for="contraseña">Contraseña:</label>
        <input type="password" id="contraseña" name="contraseña" placeholder="Contraseña" size="30" maxlength="20">
        <br>
        <input type="submit" value="Entrar">
    </form>
</main>
<footer></footer>
</body>
</html>
