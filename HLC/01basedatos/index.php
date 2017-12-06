<!DOCTYPE html>
<?php
    include("conexion.php");
    $peticion = "SELECT * FROM usuarios;";
    $resultado = mysqli_query($conexion, $peticion);
?>
<html>
    <body>
        <?php
            while($fila = mysqli_fetch_array($resultado)) {
                //echo $fila['nombre']." ".$fila['apellidos']."<br>";
                echo "{$fila['nombre']} {$fila['apellidos']} {$fila['email']} <a href='modificar.php?id={$fila['id']}'><button>Actualizar email</button></a>       <a href='borrar.php?id={$fila['id']}'><button>Borrar</button></a><br>";
            }
            mysqli_close($conexion);
        ?>
        <hr>
        <form action="alta.php" method="post">
            Nombre <input type="text" name="nombre"><br>
            Apellidos <input type="text" name="apellidos"><br>
            Email <input type="text" name="email"><br>
            Teléfono <input type="text" name="tlf"><br>
            <input type="submit" value="Alta">
        </form>
    </body>
</html>