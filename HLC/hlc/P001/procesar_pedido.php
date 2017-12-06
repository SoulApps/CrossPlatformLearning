 <?php
    define('__PNEUMATICO', 75.5);
	define('__PACEITE', 15);
	define('__PALFOMBRILLA', 38.6);
	
	$neu = $_POST['neu'];
	$oil = $_POST['oil'];
	$alf = $_POST['alf'];
	$impNeu = $neu*__PNEUMATICO;
	$impOil = $oil*__PACEITE;
	$impAlf = $alf*__PALFOMBRILLA;
	$impTotal = $impNeu+$impOil+$impAlf;
?>
 <html>
    <head>
            <title>Pedido procesado</title>
    </head>
    
    <body>
		<h1>¡Listo!</h1>
        Pedido procesado el <?php echo date('d/M/Y H:i')?><br>
		<h2>Resumen:</h2>
		<!-- Sin tabla -->
		<?php /*if($neu > "0" or $oil > "0" or $_POST['alf'] > "0") {
			if($neu > 0) {
				echo $neu." neumáticos <br>";
			}
			if($oil > 0) {
				echo $oil." botes de aceite<br>";
			}
			if($_POST['alf'] > 0) {
				echo $alf." alfombrillas<br>";
			}
			echo "Importe final:".$impTotal;
		}
		else
			echo "Pedido vacío";
		*/?>
		
		<table border="1">
			<tr>
				<td align = "center">Pedido</td>
				<td align = "center">Cantidad</td>
				<td align = "center">Suma</td>
			</tr>
			
			<tr>
			<!-- Neumáticos -->
			<?php if($neu > 0) { ?>
				<td align = "center">Neumáticos</td>
				<td align = "center"><?php echo $neu ?> <!-- Número de neumáticos -->
				<td align = "center"><?php echo $impNeu ?> <!-- Importe neumáticos -->
			<?php } ?>
			</tr>
			
			<!-- Botes de aceite -->
			<?php if($oil > 0) ?>
			<tr>
				<?php if($oil > 0) { ?>
				<td align = "center">Aceite</td>
				<td align = "center"><?php echo $oil ?> <!-- Número de botes de aceite -->
				<td align = "center"><?php echo $impOil ?> <!-- Importe botes de aceite -->
				<?php } ?>
			</tr>
			<?php if($alf > 0) ?>
			
			<!-- Alfombrillas -->
			<tr>
				<?php if($alf > 0) { ?>
				<td align = "center">Alfombrillas</td>
				<td align = "center"><?php echo $alf ?> <!-- Número de alfombrillas -->
				<td align = "center"><?php echo $impAlf ?> <!-- Importe alfombrillas -->
				<?php } ?>
			</tr>
			
			<!-- Total -->
			<tr>
				<td align = "center">Importe total</td>
				<td colspan="2" align = "center"><?php echo $impTotal ?> <!-- Importe total -->
			</tr>
		</table>
    </body>
</html> 