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
    $titulo="Mis hilos";
?>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $titulo; ?></title>
    <link rel="stylesheet" href="_css/estilos.css">
    <link rel="stylesheet" href="_css/awesome/css/font-awesome.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
   <header>
    <?php
        include('_includes/cabecera.php');
    ?>
    </header>
    <?php
        $existeContacto = 0; 
        $contactos = consulta("SELECT thread.*, usuario.nick FROM thread JOIN usuario ON thread.usuario = usuario.id WHERE usuario.id = {$_SESSION['id']}  ORDER BY thread.id DESC;", $conexion);
        while($fila = @mysqli_fetch_array($contactos)) {  
            $existeContacto = 1;   
    ?> 
        <div id="hilo">
            <p id="infohilo">Por <?php echo($fila['nick']);?> en <?php echo date_format(date_create($fila['fecha']), "d/m/Y");?></p><br>
            <a href="ver_hilo.php?hilo=<?php echo $fila['id']; ?>&amp;titulo=<?php echo $fila['titulo']; ?>"><?php echo($fila['titulo']);?></a>
        </div>
    <?php 
        }
        if($existeContacto == 0){ 
    ?>
        <p class="noHilo">No has creado ningún hilo<br><a href="pcontrol_crear_hilo.php">Crea uno ahora<br><i class="fa fa-plus" aria-hidden="true"></i></a></p>           
    <?php
        }   
    ?>

    <?php
        include('_includes/footer.php');
    ?>
    </header>
    <script src="_js/funciones.js"></script>
</body>
</html>
