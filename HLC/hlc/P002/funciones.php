<?php
	function decirMayor($numero1, $numero2) {
		if ($_GET["numero1"] > $_GET["numero2"])
			return $numero1;
		else 
			return $numero2;		
	}
	
	function decirMayor3($numero1, $numero2, $numero3) {
		return decirMayor(decirMayor($numero1, $numero2), $numero3);
	}
?>