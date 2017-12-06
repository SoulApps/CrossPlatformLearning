<html>
	<head></head>
	<body bgcolor="#003399">
		<center>
			<hr><img src=motos_gp.png>
				<h1><font color="white">CLASIFICACIÓN</font></h1>
				<hr>
				<form action="info.php" method="post">
					<P><font face="Georgia, Times New Roman, Times, serif" size="3" color=white>
						Seleccione el piloto que desea consultar: 
					<select name="el_piloto">													
						<?php
							require('datos.php');
							foreach ($datos_pilotos as $piloto => $valor)
								echo "<option value=\"".$piloto."\">".$piloto."</option>";
						?>
					</select>&nbsp;&nbsp;
					<input type="submit" value="Buscar">
					</font></p>
				</form>
		</center>
	</body>
</html>