<html>
	<head>
		<title>Hola mundo 2</title>
	</head>
	<body>
		<?php 
			if (isset($_GET["numero1"]) && isset($_GET["numero2"])) {
				echo "Hola ".$_GET["nombre"]."<br>";
			
				/*if ($_GET["numero1"] > $_GET["numero2"]) {
					echo $_GET["numero1"]." es mayor que ".$_GET["numero2"]."<br>";
				}
				else if ($_GET["numero1"] < $_GET["numero2"]) {
					echo $_GET["numero2"]." es mayor que ".$_GET["numero1"]."<br>";
				}
				else {
					echo "Los números son iguales";
				}*/
				
				include 'funciones.php';
				echo "El mayor es ".decirMayor3($_GET["numero1"], $_GET["numero2"], $_GET["numero3"]);
			}			
			else {
				echo "No hay datos";
			}
		?>
	</body>
</html>