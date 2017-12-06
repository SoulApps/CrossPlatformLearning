<?php
	class Coche {
		
		private $matricula;
		private $marca;
		private $modelo;
		private $color;
		private $numPuertas;
		
		/*public function __construct0() {
			$this->matricula = "";
			$this->marca = "";
			$this->modelo = "";
			$this->color = "";
			$this->numPuertas = 0;
		}*/
		
		public function __construct($matricula, $marca, $modelo, $color, $numPuertas) {
			$this->matricula = $matricula;
			$this->marca = $marca;
			$this->modelo = $modelo;
			$this->color = $color;
			$this->numPuertas = $numPuertas;
		}
		
		public function getNumPuertas() {
			return $this->numPuertas;
		}
		
		public function mostrarToString() {
			print <<<fin
			<h2>DATOS DEL VEHÍCULO</h2>
			<p><b>Matrícula: </b>$this->matricula</p>
			<p><b>Marca: </b>$this->marca</p>
			<p><b>Modelo: </b>$this->modelo</p>
			<p><b>Color: </b>$this->color</p>
			<p><b>Número de puertas: </b>$this->numPuertas</p>
fin;
		}
		
		public function __destruct() {
			echo "Destruir el objeto<br>";
		}
	}
?>