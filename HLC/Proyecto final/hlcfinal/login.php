<?php
    require_once('_includes/conexion.php');
    session_start();
    if(isset($_POST['usuario']) && isset($_POST['passwd'])){
        $nick= str_replace(' ','',$_POST['usuario']);
        $nick= mysqli_real_escape_string($conexion, $nick);

        $passwd= str_replace(' ','',$_POST['passwd']);
        $passwd= mysqli_real_escape_string($conexion, $passwd);

        $peticion= "SELECT * FROM usuario WHERE nick='{$nick}' AND passwd='{$passwd}'";
        $resultado= mysqli_query($conexion, $peticion);
        $fila =@mysqli_fetch_array($resultado);
        if (count($fila) != 0){
            $_SESSION['nick']= $fila['nick'];
            $_SESSION['id']= $fila['id'];
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