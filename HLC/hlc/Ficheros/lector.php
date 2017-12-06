<?php
	class Lector {
		private $fichero;
		
		public function __construct($fichero) {
			$this->fichero = $fichero;
		}
		
		public function contarPalabras() {
			return str_word_count(file_get_contents($this->fichero), 0);
		}
		
		public function contarLetra($letra) {
			$i = 0;
			$lectura = fopen($this->fichero, "r");
			while (!feof($lectura)) 
				if ($letra == fgetc($lectura))
					$i++;
			
			fclose($lectura);
			return $i;
		}
		
		public function pasarAMayusculas() {
			$lectura = fopen($this->fichero, "r");
			$s = "";
			
			while (!feof($lectura)) 
				$s .= fgets($lectura)."\n";
			
			$s = strtoupper($s);
			fclose($lectura);
			
			$lectura = fopen($this->fichero, "w");
			fputs($lectura, $s);
			fclose($lectura);			
								
			echo $s;
		}
	}
?>