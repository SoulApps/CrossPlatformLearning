<?php
    require_once('_includes/conexion.php');
    require_once('_includes/funciones.php');
    session_start();
    if(!isset($_SESSION['nick'])){
        $_SESSION['msg']=1;
        header('Location: index.php');
        exit();
    }

    if ($_POST["nombre"] != "")
        $update = consulta("UPDATE contactos SET nombre = '{$_POST["nombre"]}' WHERE id = {$_GET['id']} AND usuario = {$_SESSION['id']}", $conexion);
    if ($_POST["apellidos"] != "")
        $update = consulta("UPDATE contactos SET apellidos = '{$_POST["apellidos"]}' WHERE id = {$_GET['id']} AND usuario = {$_SESSION['id']}", $conexion);
    if ($_POST["email"] != "")
        $update = consulta("UPDATE contactos SET email = '{$_POST["email"]}' WHERE id = {$_GET['id']} AND usuario = {$_SESSION['id']}", $conexion);
    
    header("Location: pcontrol.php#contacto{$_GET['id']}");
    mysqli_close($conexion);
?>