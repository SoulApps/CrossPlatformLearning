<!DOCTYPE html>
<?php
session_start();
require_once('_includes/funciones.php');

if(isset($_SESSION['id'])){
    header('Location: pcontrol.php');
}
?>
<html lang="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda | LogIn</title>
    <link rel="stylesheet" href="_css/estilos.css">
</head>

<body>
   <header>
       <a href="index.php">
           <h3>Agenda Personal</h3>
           <h4>IES Saladillo</h4>
       </a>
       <figure>
           <img src="_img/logo-peq.jpg">
           <figcaption>
               Logo de la página
           </figcaption>
       </figure>
   </header>
   <div id="login">
        <?php echo comprobar_msg(); ?>
        <form action="login.php" method="post">
           <label for="usu">Usuario </label> <input id="usu" name="usuario" type="text"><br>
           <label for="pass">Cotraseña </label> <input id="pass" name="passwd" type="password"><br>
           <input id="boton" type="submit" value="Acceder"><br>
           <a href="rec_password.php">Olvidó su contraseña</a>
           <a href="nueva_cuenta.php">Crear Cuenta</a>
        </form>
    </div>
   <footer>
       <p>&copy; 2017 By Domingo Pérez <a href="#">Facebook</a> | <a href="#">Twitter</a> </p>
   </footer>
    <script src=""></script>
</body>
</html>













