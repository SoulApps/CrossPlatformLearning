<?php
    include("conexion.php");
    $peticion = "INSERT INTO usuarios VALUES(NULL, '".$_POST['nombre']."', '".$_POST['apellidos']."', '".$_POST['email']."', '".$_POST['tlf']."', NULL);";
    mysqli_query($conexion, $peticion);
    mysqli_close($conexion);
    header('Location: index.php');
?>