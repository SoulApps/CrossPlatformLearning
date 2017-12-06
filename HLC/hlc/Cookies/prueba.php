<?php
	if (!isset($_COOKIE["contador"])) {
		setcookie("contador", 1);
		$numVeces = 1;
	}
	else {
		$numVeces = $_COOKIE["contador"] + 1;
		setcookie("contador", $numVeces);
	}		
?>
<!DOCTYPE html>
<html lang="es">
	<head></head>
	<body>
		<p>Has visitado la página <?php echo $_COOKIE["contador"]?> veces</p>
	</body>
</html>