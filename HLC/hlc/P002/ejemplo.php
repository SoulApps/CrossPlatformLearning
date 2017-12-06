<html>
    <head></head>
    <body>
        <?php
            if (!isset($_POST["nombre"])) {
        ?>
            <form method="post">
                <input type="text" name="nombre">
                <button>Enviar</button>
            </form>
        <?php
            }
            else {
                echo "Hola ".$_POST["nombre"]."<br>";
                echo "<a href=\"./ejemplo.php\">Volver</a>";
            }
        ?>
    </body>
</html>