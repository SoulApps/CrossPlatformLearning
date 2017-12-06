<?php
    require_once('_includes/conexion.php');
    require_once('_includes/funciones.php');
    session_start();
    if(!isset($_SESSION['nick'])){
        $_SESSION['msg']=1;
        header('Location: index.php');
        exit();
    }
?>

<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar <?php $_GET["id"]?></title>
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
        <form action="actualizar_contacto.php?id=<?php echo $_GET['id']?>" method="post" enctype="multipart/form-data">
           <label for="inick">Email </label> <input id="mail" name="email" type="text"><br>
           <label for="pass">Nombre </label> <input id="nomb" name="nombre" type="text"><br>
           <label for="nomb">Apellidos </label> <input id="apell" name="apellidos" type="text"><br>
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
           <input id="boton" type="submit" value="Guardar"><br>
          
        </form>
    </div>
   <footer>
       <p>&copy; 2017 By Domingo Pérez <a href="#">Facebook</a> | <a href="#">Twitter</a> </p>
   </footer>
       
    <script src="_js/funciones.js"></script>
</body>
</html>
