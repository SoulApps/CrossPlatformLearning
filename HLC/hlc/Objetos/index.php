<!DOCTYPE html>
<html>
	<head></head>
	<body>
		<h1>Objetos</h1>
		
		<?php
			include "persona.php";
				
			$miPersona = new Persona(12345678, "Ochinchin", 'H', 80, 183, "1998-17-11");
			
			echo $miPersona->calcularIMC();
			echo "<br>";
			$miPersona->esMayorDeEdad();
			echo "<br>";
			echo $miPersona->NIF()."<br>";
			$miPersona->toString();
		?>
	</body>
</html>