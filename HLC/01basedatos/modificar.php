<?php
    include("conexion.php");
    $peticion = "SELECT email FROM usuarios WHERE id={$_GET['id']};";
    $resultado = mysqli_query($conexion, $peticion);
    $fila = mysqli_fetch_array($resultado);   
?>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>

<body>
    <?php if (count($fila) > 0) { ?>
    <form action="actualizar.php" method="post">       
            <input type="hidden" name="id" value="<?php echo $_GET['id'];?>">
            Email <input type="text" name="email" value="<?php echo $fila['email']?>"><br>       
            <input type="submit" value="Actualizar">
    </form>
    <?php 
        }
        else {
    ?>
    Error registro no válido, será redirigido a index
    <meta http-equiv="refresh" content="2; url=index.php">
    <?php 
        }
    ?>
</body>
</html>
