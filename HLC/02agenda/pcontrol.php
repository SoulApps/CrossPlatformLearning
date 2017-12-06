<!DOCTYPE html>
<?php
    require_once('_includes/conexion.php');
    require_once('_includes/funciones.php');
    session_start();
    if(!isset($_SESSION['nick'])){
        $_SESSION['msg']=1;
        header('Location: index.php');
        exit();
    }
    $titulo="Contactos";
?>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $titulo; ?></title>
    <link rel="stylesheet" href="_css/estilos.css">
    <link rel="stylesheet" href="_css/awesome/css/font-awesome.css">
</head>

<body>
   <header>
    <?php
        include('_includes/cabecera.php')
    ?>
    </header>
    <section>
    <?php
        if($_SESSION['admin'] == 1){
        //administrador
        $usuarios = consulta('SELECT * FROM usuarios WHERE admin = 0',$conexion);
        while($fila= mysqli_fetch_array($usuarios)){   
    ?>
        <article>
            <img src="<?php echo $fila['foto'];?>" alt=""><span><?php echo $fila['nick'];?></span> <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>

        </article>
    <?php
            }
    ?>
        
    <?php
        }else{
        // usuario 
        $existeContacto = 0;
        $contactos = consulta("SELECT * FROM contactos WHERE usuario = {$_SESSION['id']}",$conexion);
        while($fila= @mysqli_fetch_array($contactos)){   
          $existeContacto = 1;  
    ?> 
         <article>
            <img src="<?php echo $fila['foto'];?>"><span><?php echo $fila['nombre'];?></span> <a href="modificar_contacto.php?id=<?php echo $fila['id']?>"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a> <a href="#" onclick="favoritos(<?php echo $fila['id']?>)"><i  id="<?php echo 'contacto'.$fila['id'];?>"  class="fa fa-star<?php if ($fila['favorito'] == 1) echo ' favorito' ?>" aria-hidden="true"></i></a>


        </article>
       
        
    <?php 
         }
            if($existeContacto == 0){
                echo ("no tienes contactos");
            }
        }
    ?>
    </section>

<script src="_js/funciones.js"></script>
<script type="text/javascript" src="_js/jquery-3.1.1.min.js"></script>

</body>
</html>
