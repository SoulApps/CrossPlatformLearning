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
    $titulo="Crear hilo";
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
    <div class="nuevoHilo">
        <form action="javascript:crearHilo();" method="post" id="nuevo_hilo">
            <input type="text" id="titulo" name="titulo" placeholder="Título"><br>
            <textarea form="nuevo_hilo" id="detalles" name="detalles" placeholder="Escribe aquí los detalles..." maxlenth="10000"></textarea><br>
            <input type="submit" value="Enviar">
        </form>
    </div>
    <?php
        include('_includes/footer.php');
    ?>
    <script src="_js/funciones.js"></script>
</body>
</html>
