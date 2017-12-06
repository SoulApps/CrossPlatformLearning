<?php
require_once('_includes/conexion.php');
require_once('_includes/funciones.php');
 session_start();
    if(!isset($_SESSION['nick'])){
        $_SESSION['msg']=1;
        header('Location: index.php');
        exit();
    }

if(isset($_SESSION['id'])){    
    $titulo= str_replace(' ','',$_POST['titulo']);
    $titulo= mysqli_real_escape_string($conexion, $titulo);

    $detalles= str_replace(' ','',$_POST['detalles']);
    $detalles= mysqli_real_escape_string($conexion, $detalles);

    mysqli_query($conexion, "INSERT INTO thread VALUES(NULL, '{$_SESSION["id"]}', '{$titulo}', '{$detalles}', NULL)");
    $hilo = consulta("SELECT MAX(id) FROM thread;", $conexion); //Cojo el último insertado.
    if ($fila = @mysqli_fetch_array($hilo))
        echo "ver_hilo.php?hilo={$fila['MAX(id)']}&titulo={$_POST["titulo"]}"; //Redirijo a ese hilo.

}else{
    $_SESSION['msg']=3;
    echo 'nueva_cuenta.php';
    exit();
}
@mysql_close($conexion);
?>
