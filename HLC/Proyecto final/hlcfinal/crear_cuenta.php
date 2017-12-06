<?php
require_once('_includes/conexion.php');
require_once('_includes/funciones.php');
session_start();

if(isset($_SESSION['id'])){
    session_destroy();
    session_start();
}

if(isset($_POST['nick']) && isset($_POST['email']) && isset($_POST['passwd']) && isset($_POST['repasswd'])){
    $nick= str_replace(' ','',$_POST['nick']);
    $nick= mysqli_real_escape_string($conexion, $nick);

    //Contraseñas iguales.
    $passwd= str_replace(' ','',$_POST['passwd']);
    $passwd= mysqli_real_escape_string($conexion, $passwd);
    $repasswd= str_replace(' ','',$_POST['repasswd']);
    $repasswd= mysqli_real_escape_string($conexion, $repasswd);

    if ($passwd != $repasswd){
        $_SESSION['msg']=10;
        header('Location: nueva_cuenta.php?n='.$nick);
        exit();
    }

    //Existe el nick.
    $resultado= consulta("SELECT * FROM usuario WHERE nick='{$nick}'",$conexion);
    while ($fila= mysqli_fetch_array($resultado)){
        $_SESSION['msg']=4;
        header('Location: nueva_cuenta.php?n='.$nick);
        exit();
    }

    //Existe el email.
    $resultado= consulta("SELECT * FROM usuario WHERE email='{$_POST["email"]}'",$conexion);
    while ($fila= mysqli_fetch_array($resultado)){
        $_SESSION['msg']=8;
        header('Location: nueva_cuenta.php');
        exit();
    }

    //Email correcto.
    if (!filter_var($_POST["email"], FILTER_VALIDATE_EMAIL)) {
        $_SESSION['msg']=9;
        header('Location: nueva_cuenta.php');
        exit();
    }

    mysqli_query($conexion, "INSERT INTO usuario VALUES(NULL, '{$nick}', '{$passwd}', '{$_POST["email"]}')");
    $_SESSION['msg']=7;
    $_SESSION['nick']=$nick;

    $resultado= consulta("SELECT * FROM usuario WHERE nick='{$nick}'",$conexion);
    if ($fila= mysqli_fetch_array($resultado))
        $_SESSION['id']=$fila["id"];
        
    header('Location: pcontrol.php');

}else{
    $_SESSION['msg']=3;
    header('Location: nueva_cuenta.php');
    exit();
}

?>
