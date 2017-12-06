<html>
	<head></head>
	<body>
		<?php
			//Apertura de un fichero
			$fichero = fopen("prueba.txt", "w");
			fputs($fichero, "Cosillas");
			fclose($fichero);
			
			//Append
			$fichero = fopen("prueba.txt", "a");
			fputs($fichero, "\nCosillas");
			fclose($fichero);
			
			//Lectura
			$fichero = fopen("prueba.txt", "r");
			do {
				echo fgets($fichero). "<br>"; //Lee una línea
			} while (!feof($fichero));
			fclose($fichero);
		?>
	</body>
</html>