<!DOCTYPE html>
<html lang="es">
 <head>
  <meta charset="UTF-8">
  <title>Examen 1er trimestre</title>
  <link rel="stylesheet" href="css/style.css">
 </head>
 <body>
  <form>
   <table>
   <tr>
      <td>DE</td>
      <td>ASUNTO</td>
      <td>FECHA</td>
      <td>MARCAR</td>
    </tr>
      <?php 
          include("php/correos.php");       
         
					foreach ($correos as $correo => $info) {	
              echo "<tr>";							
							foreach($info as $indice => $dato) {																		
									echo "<td align=center>$dato</td>";										
							}		
							echo "<td><input type='checkbox' name='correo[]' value='$correo'/></td></tr>";									
					}		              
            						
        ?>
   </table>
   <p><input type="submit" value="Enviar" /></p>
  </form>


 <?php
  //Muestro el resultado de los correos enviados. 
  if (isset($_GET['correo'])) {
      echo "Has enviado estos correos: <br>";

      foreach($_GET['correo'] as $codigo)
        echo "$codigo<br>";
  }
      
   ?>

 </body>
</html>
