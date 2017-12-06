<?php
    require_once('_includes/conexion.php');
    require_once('_includes/funciones.php');
    session_start();
    if(!isset($_SESSION['nick'])){
        $_SESSION['msg']=1;
        header('Location: index.php');
        exit();
    }

    //Compruebo primero si el contacto ya es favorito o no para actuar en consecuencia.
    //Compruebo que el contacto sea realmente del usuario en el where.
    $contacto = consulta("SELECT favorito FROM contactos WHERE id = {$_POST['id']} AND usuario = {$_SESSION['id']}", $conexion);

    if ($fila = mysqli_fetch_array($contacto)) {
        if ($fila['favorito'] == 1) { //Si ya es favorito
            consulta("UPDATE contactos SET favorito = 0 WHERE id = {$_POST['id']}", $conexion);   
            echo '0';
        }
        else {
            consulta("UPDATE contactos SET favorito = 1 WHERE id = {$_POST['id']}", $conexion);
            echo '1';
        }
    }
    mysqli_close($conexion);
?>
