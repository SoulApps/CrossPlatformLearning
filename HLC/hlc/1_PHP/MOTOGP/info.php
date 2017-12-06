<html>
	<head></head>
	<body bgcolor="#003399">
		<center>
			<hr><img src=motos_gp.png>
			<h1><font color="white">INFORMACIÓN PILOTO</font></h1>
			<hr>
			<?php require('datos.php'); ?>
				<p><font face="Georgia, Times New Roman, Times, serif" size="3" color=white>
					La clasificación del piloto  <b><font size=+1> '<?php echo $_POST["el_piloto"].""; ?>'</font></b> es:	</font></p>

					<table border=2 width=300>													
						<tr>
							<td width=70 align="center"><b><font color="white"> Gran Premio </font></b></td>		
							<td width=70 align="center"><b><font color="white"> Posición </font></b></td>
							<td width=70 align="center"><b><font color="white"> Puntos </font></b></td>
						</tr>
						
						<?php
							$i = 0;
							foreach ($datos_pilotos as $piloto => $info) {	
								if ($piloto == $_POST["el_piloto"]) {
									foreach($info as $indice => $datos) {
										echo "<tr>";
										foreach($datos as $posicion => $dato) {
											echo "<td align=center><font color=white>".$dato."</font></td>";
											if ($posicion == "Puntos")
												$i += $dato;
										}		
										echo "</tr>";
									}
								}	
							}
						?>																							
					</table>
				<p>
			<font color=white>N&uacute;mero total de puntos conseguidos en el campeonato: 
				<b><?php echo $i; ?></b>
			</font>
			<p><input type="button" value="<- Volver atr&aacute;s" onclick="history.back();">
		</center>
	</body>
</html>