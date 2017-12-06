<?php
require_once('_includes/conexion.php');
require_once('_includes/funciones.php');
session_start();

if(isset($_SESSION['id'])){
    session_destroy();
    session_start();
}

if(isset($_POST['nick'])){
    $nick= str_replace(' ','',$_POST['nick']);
    $nick= mysqli_real_escape_string($conexion, $nick);
    $resultado= consulta("SELECT * FROM usuarios WHERE nick='{$nick}'",$conexion);

    while ($fila= mysqli_fetch_array($resultado)){
        $_SESSION['msg']=4;
        header('Location: nueva_cuenta.php?n='.$nick);
        exit();
    }

    if($_FILES['foto']['name']) {
        $f=$_FILES['foto']['name'];
        $nombFoto=str_replace(' ','',$f);
        mkdir("_img/{$nick}",777);
        $ruta="_img/{$nick}";
        $rutaFoto=$ruta."/{$nombFoto}";
        $file_copy=$ruta."/".basename($nombFoto);
        $image_file_type= pathinfo($file_copy,PATHINFO_EXTENSION);

        if($image_file_type == 'jpg' || $image_file_type == 'png'){
            if(move_uploaded_file($_FILES['foto']['tmp_name'], $file_copy)){
               //MENSAJE DE OK FILE UPLOAD 
            } else{
                $_SESSION['msg']=5;
                header('Location: pcontrol.php');
                $file_copy = -1;
            }
        }else{
            $_SESSION['msg']=6;
                header('Location: pcontrol.php');
                $file_copy = -1;
        }
    } else {
        $file_copy = -1;
    }

    mysqli_query($conexion, "INSERT INTO usuarios VALUES (NULL, '{$nick}', '{$_POST["passwd"]}', '{$_POST["nombre"]}', '{$_POST["apellido"]}', '{$_POST["email"]}', '{$file_copy}', 0, 0)");
    $_SESSION['msg']=7;
    $_SESION['nick']=$nick;
    header('Location: pcontrol.php');
    //mandar email de confirmacion
   

}else{
    $_SESSION['msg']=3;
    header('Location: nueva_cuenta.php');
    exit();
}

?>






