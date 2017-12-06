<html>
	<head></head>
	<body>
		<?php
			include("lector.php");
			
			$fichero = "AsChkDev.txt";				
			$fichero = "prueba.txt";	
			
			$lector = new Lector($fichero);
			echo $lector->contarPalabras()."<br>";
			echo $lector->contarLetra('z')."<br>";
			echo $lector->pasarAMayusculas();
		?>
	</body>
</html>