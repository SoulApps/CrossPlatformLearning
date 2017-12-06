<?php
    require_once('_includes/conexion.php');
    session_start();
    if(isset($_POST['usuario']) && isset($_POST['passwd'])){
        $peticion= "SELECT * FROM usuarios WHERE nick='{$_POST["usuario"]}' AND passwd='{$_POST["passwd"]}' AND baja=0";
        $resultado= mysqli_query($conexion, $peticion);
        $fila =mysqli_fetch_array($resultado);
        if (count($fila) != 0){
            
            $_SESSION['nick']= $fila['nick'];
            $_SESSION['id']= $fila['id'];
            $_SESSION['admin']= $fila['admin'];
            header('Location: pcontrol.php');
            
        }else{
             $_SESSION['msg']=2;
             header('Location: index.php');
        }
    }else{
        $_SESSION['msg']=1;
        header('Location: index.php');
    }
mysqli_close($conexion);
?>