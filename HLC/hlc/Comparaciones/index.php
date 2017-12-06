<html>
	<head></head>
	<body>
		<?php
			$personas=array("11111111A"=>array("nombre"=>"Pepe","apellidos"=>"Lopez Perez","edad"=>25),
					"33333333C"=>array("nombre"=>"Luis","apellidos"=>"Romero Lopez","edad"=>45),
					"44444444D"=>array("nombre"=>"Fernando","apellidos"=>"Jimenez Martinez","edad"=>41),
					"22222222B"=>array("nombre"=>"Ana","apellidos"=>"Lopez Rodriguez","edad"=>14),
					"55555555E"=>array("nombre"=>"Lola","apellidos"=>"Lopez Perez","edad"=>68));
					 				
			
			function comparar($persona1, $persona2) {			
				if(strnatcasecmp($persona1["apellidos"],$persona2["apellidos"])<0)
					return false;
				elseif(strnatcasecmp($persona1["apellidos"],$persona2["apellidos"])>0)
					return true;
				elseif(strnatcasecmp($persona1["apellidos"],$persona2["apellidos"])==0){
					if(strnatcasecmp($persona1["nombre"],$persona2["nombre"])<0)
						return false;
					elseif(strnatcasecmp($persona1["nombre"],$persona2["nombre"])>0)
						return true;
					else
						return false;
}
			}
			
			uasort($peronas,"comparar");

	
			//Muestro el contenido del array $personas ANTES DE ORDENAR
			echo "<h2>Antes</h2>";
			echo "<table border=\"1\">\n";
			echo "<tr>\n";
			echo "<td>DNI</td>";
			echo "<td>Nombre</td>";
			echo "<td>Apellidos</td>";
			echo "<td>Edad</td>\n";
			echo "</tr>\n";
			foreach($personas as $DNIpersona=>$persona){
				echo "<tr>\n";
				echo "<td>$DNIpersona</td>";
				echo "<td>".$persona["nombre"]."</td>";
				echo "<td>".$persona["apellidos"]."</td>";
				echo "<td>".$persona["edad"]."</td>\n";
				echo "</tr>\n";
			}
			echo "</table>\n";
			//Llamada a la funcion de oprdenación
			uasort($personas,"comparar");
			//Muestro el contenido del array $personas DESPUES DE ORDENAR
			echo "<h2>Después</h2>";
			echo "<table border=\"1\">\n";
			echo "<tr>\n";
			echo "<td>DNI</td>";
			echo "<td>Nombre</td>";
			echo "<td>Apellidos</td>";
			echo "<td>Edad</td>\n";
			echo "</tr>\n";
			foreach($personas as $DNIpersona=>$persona){
				echo "<tr>\n";
				echo "<td>$DNIpersona</td>";
				echo "<td>".$persona["nombre"]."</td>";
				echo "<td>".$persona["apellidos"]."</td>";
				echo "<td>".$persona["edad"]."</td>\n";
				echo "</tr>\n";
			}
			echo "</table>\n";
		?>

	</body>
</html>