<?php
    include("conexion.php");
    $peticion = "DELETE FROM usuarios WHERE id = {$_GET['id']}";
    mysqli_query($conexion, $peticion);
    mysqli_close($conexion);
    header('Location: index.php');
?>