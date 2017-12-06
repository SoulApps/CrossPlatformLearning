 <html>
    <head>
        <title>Usuario</title>
    </head>
    
    <body>
        <h1>USUARIO</h1>
		Nombre: <?php echo $_GET['nomb'])?> -- Edad: <?php echo @$_GET['edad']?><br>
		<?php $var="hola"?>
		<a href="index.php?nomb=<?php echo $_GET['nomb'])?>">Volver</a>
    </body>
</html> 