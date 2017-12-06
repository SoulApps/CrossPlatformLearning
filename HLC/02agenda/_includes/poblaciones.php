<?php
    require_once('conexion.php');
    require_once('funciones.php');
    debug($_POST['q']);
if(isset($_POST['q'])){
    
    $peticion="SELECT * FROM poblaciones WHERE idProvincia = {$_POST['q']} ORDER BY poblacion";
    $resultado= mysqli_query($conexion, $peticion);
        echo '<option value="-1">Elige una...</option>';
    while($fila=mysqli_fetch_array($resultado)){
        echo "<option value='{$fila["idPoblacion"]}'>{$fila['poblacion']}</option>";
    }
}

mysqli_close($conexion);
?>