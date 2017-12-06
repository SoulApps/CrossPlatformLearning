<?php
    include("conexion.php");
    $peticion = "UPDATE usuarios SET email = '{$_POST['email']}' WHERE id = {$_POST['id']};";
    mysqli_query($conexion, $peticion);
    mysqli_close($conexion);
    header('Location: index.php');
?>


Error registro no válido, será redirigido a index
    <meta http-equiv="refresh" content="2; url=index.php">