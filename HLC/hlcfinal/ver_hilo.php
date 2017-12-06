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

    if(!isset($_GET['hilo'])){
        header('Location: pcontrol.php');
        exit();
    }

    $titulo = $_GET["titulo"];
?>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo $titulo; ?></title>
    <link rel="stylesheet" href="_css/estilos.css">
    <link rel="stylesheet" href="_css/awesome/css/font-awesome.css">
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
        $hilo = consulta("SELECT thread.*, usuario.nick FROM thread JOIN usuario ON thread.usuario = usuario.id WHERE thread.id = {$_GET['hilo']};", $conexion);
        if ($fila = @mysqli_fetch_array($hilo)) {
    ?>
        <div id="verHilo" class="nuevoHilo">
            <p id="infohilo">Por <?php echo($fila['nick']);?> en <?php echo date_format(date_create($fila['fecha']), "d/m/Y");?></p><br>
            <h3 class="izq"><?php echo($fila['titulo']);?></h3>
            <textarea readonly><?php echo($fila['detalles']);?></textarea>
        </div>
    <?php }?>

    <div id="cajaComentario">
        <form method="post" id="nuevo_comentario" action="javascript:escribirComentario();">
            <input id="hilo" type="hidden" name="thread" value="<?php echo $_GET['hilo']; ?>">
            <input id="titulo" type="hidden" name="titulo" value="<?php echo $_GET['titulo']; ?>">
            <textarea id="contenido" form="nuevo_comentario" name="contenido" placeholder="Escribe aquí tu comentario..." maxlenth="10000"></textarea><br>
            <input type="submit" value="Enviar">
        </form>
    </div>
    <?php
        $comentario = consulta("SELECT comentario.*, usuario.nick FROM comentario JOIN usuario ON comentario.usuario = usuario.id AND comentario.thread = {$_GET['hilo']};", $conexion);
        while ($fila = @mysqli_fetch_array($comentario)) {
    ?>
        <div class="comentario" id="comentario<?php echo $fila['id']?>" name="comentario<?php echo $fila['id']?>">
            <p id="infohilo">Por <?php echo($fila['nick']);?> en <?php echo date_format(date_create($fila['fecha']), "d/m/Y");?></p><br>
            <p class="contenidoComentario"><?php echo($fila['contenido']);?></p>
        </div>
    <?php }?>
    <?php
        include('_includes/footer.php');
    ?>

   <script src="_js/funciones.js"></script>
</body>
</html>
