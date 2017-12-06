<html>
	<head></head>
	<body>
		<?php
		$personas = array(array("dni" => "1A", "nombre" => "Pipiolo1", "estatura" => 180),
								array("dni" => "2AA", "nombre" => "Pipiolo2", "estatura" => 200),
								array("dni" => "3AAA", "nombre" => "Pipiolo3", "estatura" => 80));
		?>
		<?php
			function buscarPersona($dni, $personas) {							
				foreach($personas as $persona) {
					if ($persona["dni"] == $dni) {
						foreach($persona as $indice => $datos) {
							echo $indice.": ".$datos."<br>";
						}			
					}
				}	
			}
		?>
		
		<form method="post">
			<input type="text" name="dni">
			<button>Buscar</button>
		</form>
		
		<br><br>
		<?php
			if (isset($_POST["dni"])) {
				buscarPersona($_POST["dni"], $personas);
			}
		?>
	</body>
</html>