<!DOCTYPE html>
<?php
session_start();
require_once('_includes/funciones.php');

if(isset($_SESSION['id'])){
    header('Location: pcontrol.php');
}
?>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cuéntalo</title>
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
   <div id="login">
        <?php echo comprobar_msg(); ?>
        <form action="login.php" method="post">
           <label for="usu">Usuario </label> <input id="usu" name="usuario" type="text"><br>
           <label for="pass">Cotraseña </label> <input id="pass" name="passwd" type="password"><br>
           <input id="boton" type="submit" value="Acceder"><br>
           <a href="nueva_cuenta.php">Crear Cuenta</a>
        </form>
    </div>
    <?php
        include('_includes/footer.php');
    ?>
    <script src=""></script>
</body>
</html>
