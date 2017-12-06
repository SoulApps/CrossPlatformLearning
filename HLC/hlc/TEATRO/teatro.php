<?php
	class Teatro {
		
		private $nombreTeatro;
		private $nombreObra;
		private $sesion;
		private $dia;
		private $asientos;
		
		public function __construct() {
			$this->leerFichero();				
		}

		public function mostrarNombreTeatro() {
			echo "<TD><FONT size=-1><B>".$this->nombreTeatro."</B></FONT></TD>";
		}

		public function mostrarNombreObra() {
			echo "<TD><FONT size=-1><B>".$this->nombreObra."</B></FONT></TD>";
		}

		public function mostrarSesion() {
			echo "<B>".$this->sesion."</B>";
		}

		public function mostrarDia() {
			echo "<B>".$this->dia."</B>";
		}

		public function mostrarAsientos() {
			echo "<TABLE BORDER='0' cellspacing='3' cellpadding='0' align='center'>";
			$numFila = 0;

			foreach ($this->asientos as $i=>$fila) {		
				echo "<tr><td><font size=1>".++$numFila."</font></td>";		
				foreach ($fila as $j=>$asiento) {									
					if (isset($_COOKIE["$i|$j"])) {				
						echo "<TD bgcolor=orange><A href=index.php?operacion=exec_comprar&la_fila=".$i."&el_asiento=".$j."&accion=0>
                		<img alt='Comprar/Devolver' src=1px.gif height=10 width=10 border=1></A></TD>";
					}
					else {
						if ($this->asientos[$i][$j] == 0)
							echo "<TD bgcolor=lime><A href=index.php?operacion=exec_comprar&la_fila=".$i."&el_asiento=".$j."&accion=2>
                			<img alt='Comprar/Devolver' src=1px.gif height=10 width=10 border=1></A></TD>";
						elseif ($this->asientos[$i][$j] == 1)
							echo "<TD bgcolor=red><A href=index.php?operacion=exec_comprar&la_fila=".$i."&el_asiento=".$j."&accion=1>
                			<img alt='Comprar/Devolver' src=1px.gif height=10 width=10 border=1></A></TD>";
					}
				}
				echo "</tr>";
			}

			
			echo "<tr>";
			for ($j = 0; $j <= 20; $j++) {
				if ($j != 0)
					echo "<td><font size=1>".$j."</font>";
				else
					echo "<td><font size=1></font>";
			}
			echo "</tr>";
			echo "</TABLE>";
		}




		public function leerFichero() {
			$linea = 0;
			
			$lectura = fopen("asientos_teatro.txt", "r");
			while (!feof($lectura)) {
				$s = fgets($lectura);
				if ($linea == 0) {
					$datos = explode("|", $s);
					$this->nombreTeatro = $datos[0];
					$this->nombreObra = $datos[1];
					$this->sesion = $datos[2];
					$this->dia = $datos[3];
				}
				else {
					$i = 0;
					while ($i < 20) {
						$this->asientos[$linea - 1][$i] = substr($s, $i, 1);
						$i++;
					}
				}
				$linea++;				
			}
		}
	}
?>