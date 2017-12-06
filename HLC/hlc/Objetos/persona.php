<?php
	class Persona {
		private $dni;
		private $nombre;
		private $sexo;
		private $peso;
		private $altura;
		private $fechaNacimiento;
		
		public function __construct($dni, $nombre, $sexo, $peso, $altura, $fechaNacimiento) {
			$this->dni = $dni;
			$this->nombre = $nombre;
			$this->sexo = $sexo;
			$this->peso = $peso;
			$this->altura = $altura;
			$this->fechaNacimiento = $fechaNacimiento;
		}
		
		public function calcularIMC() {		
			$imc = $this->peso / pow(($this->altura / 100), 2);
			if ($imc < 18)
				return -1;
			else if ($imc >= 25)
				return 1;
			else
				return 0;
		}
		
		public function esMayorDeEdad() {
			if (intval((strtotime("now") - strtotime($this->fechaNacimiento))/31536000) < 18)
				echo "No es mayor de edad";
			else
				echo "Es mayor de edad";
		}
		
		public function NIF() {
			$modulo = $this->dni % 23;
			$letras = array('T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E');												
			return $this->dni.$letras[$modulo];
		}
		
		public function toString() {
			print <<<fin
			<p><b>Dni: </b>$this->dni</p>
			<p><b>Nombre: </b>$this->nombre</p>
			<p><b>Sexo: </b>$this->sexo</p>
			<p><b>Peso: </b>$this->peso</p>
			<p><b>Altura: </b>$this->altura</p>
			<p><b>Fecha de nacimiento: </b>$this->fechaNacimiento</p>
fin;
		}
	}
?>