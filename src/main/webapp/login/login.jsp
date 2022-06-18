<%-- 
    Document   : login
    Created on : 12 jun 2022, 1:29:38
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Inicio de sesión</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Manicure</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="mt-5 d-flex justify-content-center">
            <div class = "card border-dark">
                <div class = "card-header text-dark text-center">
                    <h1>Iniciar sesión</h1>
                </div>
                <div class="mt-3 card-body text-center text-dark">
                    <form action="validacion.jsp">
                        <div class = "mb-3">
                            <label for="usuario" class="form-label text-uppercase text-start">Usuario</label>
                            <input type="text" name="usuario" id="usuario" class="form-control">
                        </div>
                        <div class = "mb-3">
                            <label for="password" class="form-label text-uppercase text-start">Contraseña</label>
                            <input type="password" name="password" id="password" class="form-control">
                        </div>
                        <div class = "mb-3">
                            <input type="submit" name="iniciarSesion" id="iniciarSesion" class="btn btn-dark text-uppercase" value="Iniciar sesión">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
