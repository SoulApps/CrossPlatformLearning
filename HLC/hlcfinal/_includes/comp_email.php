<?php
    require_once('conexion.php');
    require_once('funciones.php');

    if (!filter_var($_POST["q"], FILTER_VALIDATE_EMAIL)) {
        echo "-1";
        exit();
    }

    if(isset($_POST['q'])){
        $peticion="SELECT * FROM usuario WHERE email = '{$_POST['q']}'";
        $resultado= mysqli_query($conexion, $peticion);
            
        $fila=mysqli_fetch_array($resultado);
        echo count($fila);
    }

    mysqli_close($conexion);
?>