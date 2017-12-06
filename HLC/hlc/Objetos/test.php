<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h1>Objetos</h1>
		
		<?php
			include "coche.php";
			
			//$miCoche1 = new Coche();
			$miCoche2 = new Coche("1234AAA", "Ford", "Fiesta", "Roza", 5);
			
			//$miCoche1->mostrarToString();
			echo "<br>";
			$miCoche2->mostrarToString();
		?>
	</body>
</html>