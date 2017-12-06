<!DOCTYPE html>
<?php
session_start();
if(isset($_SESSION['id'])){
    session_destroy();
}
require_once('_includes/funciones.php');
require_once('_includes/conexion.php');
?>

<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="stylesheet" href="_css/estilos.css">
    <link rel="stylesheet" href="_css/estilos.css">
    <link rel="stylesheet" href="_css/awesome/css/font-awesome.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
   <header>
       <div class="w3-top">
            <div class="w3-bar w3-white w3-card-2" id="myNavbar">
                <a href="index.php"><img src="_img/icono.jpg" alt="Logo" class="w3-bar-item w3-button w3-wide" height="42" width="42"></img></a>
            </div>
        </div>
   </header>
   <div id="registro">
        <?php echo comprobar_msg(); ?>
        <form action="crear_cuenta.php" method="post" enctype="multipart/form-data">
            <label for="inick">Usuario </label> <span id="nickErr"></span><input id="inick" name="nick" type="text" onblur="comprobarNick(this.value)"><br>
            <label for="mail">Email </label> <span id="emailErr"></span> <input id="mail" name="email" type="email" onblur="comprobarEmail(this.value)"><br>
            <label for="pass">Cotraseña </label> <span id="passErr"></span><input id="pass" name="passwd" type="password" onblur="comprobarPass(this.value)"><br>
            <label for="pass">Repetir cotraseña </label> <input id="pass" name="repasswd" type="password"><br>
            <a href="index.php">¿Ya tienes una cuenta? Inicia sesión</a>
            <input id="boton" type="submit" value="Acceder"><br>
        </form>
    </div>
    <?php
        include('_includes/footer.php');
    ?>
    <script src="_js/funciones.js"></script>
    </body>
</html>
