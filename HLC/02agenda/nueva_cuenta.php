<!DOCTYPE html>
<?php
session_start();
if(isset($_SESSION['id'])){
    session_destroy();
}
require_once('_includes/funciones.php');
require_once('_includes/conexion.php');
/*$peticion="SELECT * FROM provincias ORDER BY provincia";
$resultado= mysqli_query($conexion, $peticion);*/


?>
<html lang="es">
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
   <div id="registro">
        <?php echo comprobar_msg(); ?>
        <form action="crear_cuenta.php" method="post" enctype="multipart/form-data">
           <label for="inick">Nick </label> <span id="nickErr"></span><input id="inick" name="nick" type="text" onblur="comprobarNick(this.value)"><br>
           <label for="pass">Cotraseña </label> <input id="pass" name="passwd" type="password"><br>
           <label for="nomb">Nombre </label> <input id="nomb" name="nombre" type="text"><br>
           <label for="apell">Apellidos </label> <input id="apell" name="apellido" type="text"><br>
           <label for="mail">Email </label> <input id="mail" name="email" type="email"><br>
           Foto <input type="file" name="foto"><br>
           Provincia: <select name="provincia" id="prov" onblur="poblaciones(this.value)">
                       <option value="-1">Elige una...</option>
                       <?php 
                            $c = consulta("SELECT * FROM provincias ORDER BY provincia", $conexion);
                            while($fila= mysqli_fetch_array($c)){
                                echo "<option value='{$fila["idProvincia"]}'>{$fila['provincia']}</option>";
                                
                            }
                        ?>
                      </select>
            Poblacion: <select name="poblacion" id="pob">
                      <option value="-1">Elige una...</option>
                       
                      </select>
           <input id="boton" type="submit" value="Acceder"><br>
          
        </form>
    </div>
   <footer>
       <p>&copy; 2017 By Domingo Pérez <a href="#">Facebook</a> | <a href="#">Twitter</a> </p>
   </footer>
       
    <script src="_js/funciones.js"></script>
</body>
</html>






