<%@ page contentType="text/html;charset=UTF-8" %>
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
    <h1>Virtual Baby</h1>
</div>

<div class="container">
    <h2>INICIO DE SESIÓN</h2>
    <form>
        <br><br>
        <label for="user">USUARIO:</label>
        <input type="text" id="user" name="user" placeholder="Ingrese su usuario" required>
        <br><br>
        <label for="password">CONTRASEÑA:</label>
        <input type="password" id="password" name="password" placeholder="Ingrese su contraseña" required>
        <br><br>
        <input type="submit" value="Entrar">
    </form>

</div>
</body>
</html>
