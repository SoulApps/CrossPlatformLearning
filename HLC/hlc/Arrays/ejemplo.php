<html>
	<head></head>
	<body>
		<?php
			$miArray[0] = 2;
			$miArray[5] = -50;
			$miArray["posicion1"] = "hola <br>";
			
			$otroArray[0] = $miArray;
			echo $otroArray[0]['posicion1'];
			
			
			$coche["marca"] = "ford";
			$coche["modelo"] = "focus";
			$coche["matricula"] = "8795AAA";
			$coche["km"] = "100000";
			$otroCoche = array("marca" => "seat", "modelo" => "ibiza", "matricula" => "1234DDD", "km" => "1200", "numPuertas" => 5);
			echo $coche["marca"]."<br>";
			echo $otroCoche["marca"]."<br>";
			
			echo "<br><br>";
			
			foreach($otroCoche as $datos) {
				echo $datos."<br>";
			}
			
			echo "<br><br>";
			
			foreach($otroCoche as $indice => $datos) {
				echo $indice.": ".$datos."<br>";
			}
			
			echo "<br><br>";
			
			foreach($otroCoche as $indice => $datos) {
				echo $indice.": ".$datos."<br>";
			}
			
			$coches = array(array("marca" => "seat", "modelo" => "ibiza", "matricula" => "1234DDD", "km" => "1200", "numPuertas" => 5),
							array("marca" => "seat2", "modelo" => "ibiza", "matricula" => "1234DDD", "km" => "1200", "numPuertas" => 5),	
							array("marca" => "seat3", "modelo" => "ibiza", "matricula" => "1234DDD", "km" => "300", "numPuertas" => 5));
			
			//Muestra los kms del seat3
			echo "<br>".$coches[2]["km"];
			
			echo "<br><br>";
			
			//Muestra los datos del seat 2
			foreach($coches[1] as $indice => $datos) {
				echo $indice.": ".$datos."<br>";
			}
			
			echo "<br><br>";
			
			//Muestra todos los coches
			foreach($coches as $coche) {
				foreach($coche as $indice => $datos) {
					echo $indice.": ".$datos."<br>";
				}
				echo "<br>";
			}

		?>
	</body>
</html>