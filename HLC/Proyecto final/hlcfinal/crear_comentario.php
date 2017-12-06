<?php
require_once('_includes/conexion.php');
require_once('_includes/funciones.php');
session_start();
    if(!isset($_SESSION['nick'])){
        $_SESSION['msg']=1;
        header('Location: index.php');
        exit();
    }

if (isset($_POST["contenido"])) {
    if(isset($_SESSION['id'])){    
        $contenido= str_replace(' ','',$_POST['contenido']);
        $contenido= mysqli_real_escape_string($conexion, $contenido);
        mysqli_query($conexion, "INSERT INTO comentario VALUES(NULL, '{$_POST["thread"]}', '{$_SESSION["id"]}', NULL, '{$contenido}')");
        
        $hilo = consulta("SELECT MAX(id) FROM comentario;", $conexion); //Cojo el último insertado.
        if ($fila = @mysqli_fetch_array($hilo))
           echo "ver_hilo.php?hilo={$_POST["thread"]}&titulo={$_POST["titulo"]}#comentario{$fila['MAX(id)']}"; //Redirijo a ese comentario.

    }else{
        $_SESSION['msg']=3;
        echo 'nueva_cuenta.php';
        exit();
    }
}
@mysql_close($conexion);
?>
