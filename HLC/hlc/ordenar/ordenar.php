<html lang="es">
 <head>
  <meta charset="utf-8" />
 </head>
 <body>
<?php
 $palabras=array("1"=>"amazona","2"=>"leon","3"=>"zozobra",
				 "4"=>"sabueso", "5"=>"bondad","6"=>"obus");
				 
 foreach($palabras as $indice=>$valor){
	echo $indice.": ".$valor."<br />";
 }

 //arsort($palabras); //ordena por contenido descendente (SI mantiene asociacion de indice/valor)
 //asort($palabras);//ordena por contenido ascendente (SI mantiene asociacion de indice/valor)
 //rsort($palabras); //ordena por contenido descendente (NO mantiene asociacion de indice/valor)
 //sort($palabras); //ordena por contenido ascendente (NO mantiene asociacion de indice/valor)
 //ksort($palabras); //ordena por indice ascendente (SI mantiene asociacion de indice/valor)
 //krsort($palabras); //ordena por indice descendente (SI mantiene asociacion de indice/valor)
 //shuffle($palabras); //ordena por conteniodo de forma aleatoria (NO mantiene asociacion de indice/valor)
function compara($a,$b)
{
	return (substr($a,5,1)>substr($b,5,1));
}

uasort($palabras,"compara");

 echo "<br /><br />";
 foreach($palabras as $indice=>$valor){
	echo $indice.": ".$valor."<br />";
 }

?>
 </body>
</html>