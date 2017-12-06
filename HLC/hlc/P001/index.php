<?php
    $var="Hola mundo";
?>
<html>
    <head>
            <title>Mi primer php</title>
    </head>
    
    <body>
        <?php if(isset($_GET['nomb']))
				echo "Ha vuelto".$_GET['nomb'])?>
		<br>
		<a href="usuario.php?nomb=Luis Romero&edad=28">Luis</a><br>
		<a href="usuario.php?nomb=Ana Perez&edad=31">Ana</a><br>
    </body>
</html> 