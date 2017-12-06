<?php
    if (isset($_COOKIE["asientos"]))
      $asientos = $_COOKIE["asientos"];
    else
      $asientos = false;
    
    $numVeces = 0;
    if (!isset($_COOKIE["contador"]))
      setcookie("contador", $numVeces);
    else
      $numVeces = $_COOKIE["contador"];

    if (isset($_GET["la_fila"]) && isset($_GET["el_asiento"]) && isset($_GET["accion"])) {
      if ($_GET["accion"] == 0) {
        setcookie($_GET["la_fila"]."|".$_GET["el_asiento"], "", time() - 3600);
        header("Location: index.php?mensaje=Gracias por devolver la entrada.");
        $numVeces--;
      }
      elseif ($_GET["accion"] == 2) {
        if ($numVeces == 5)
          $mensaje = "Sólo se permite comprar <u>5 entradas</u> como máximo.";          
        else {     
          setcookie($_GET["la_fila"]."|".$_GET["el_asiento"]);
          header("Location: index.php?mensaje=Gracias por comprar en esta página.");
          $mensaje = "Gracias por comprar en esta página.";
          $numVeces++;
        }
      }
      else 
        $mensaje = "Las entradas sólo pueden ser devueltas por la persona que las ha comprado.";      
    }

    setcookie("contador", $numVeces);

    include("teatro.php");
    $teatro = new Teatro();
?>
<!DOCTYPE html>
<HTML lang="es">
<HEAD><TITLE>Teatro</TITLE>
   <STYLE  TYPE="text/css">
   <!--
        input
        {
          font-family : Arial, Helvetica;
          font-size : 14;
          color : #000033;
          font-weight : normal;
          border-color : #999999;
          border-width : 1;
          background-color : #FFFFFF;
        }
   -->
   </style>
</HEAD>

<BODY bgcolor="#C0C0C0" link="green" vlink="green" alink="green">

<BASEFONT face="arial, helvetica">
<TABLE border="0" align="center" cellspacing="3" cellpadding="3" width="650">
<TR><TH colspan="2" width="100%" bgcolor="green"><FONT size="6" color="white">Comprar entradas de teatro</FONT></TH>
</TR></TABLE><P>

  
  <CENTER><P>
          <TABLE border='0' width='600'>
          <TR>
             <TD valign=top align=CENTER colspan=2>
              <H2> ¡Bienvenid@ a la página de reserva de localidades!    </H2><BR>
             </TD></TR></TABLE>

          <?php
            if (isset($_GET["mensaje"]))
              echo "<font size='3' color='green'>".$_GET['mensaje']."</font>";
            else
              if (isset($mensaje))
                echo "<font size='3' color='red'>$mensaje</font>";
          ?>

  	<P><HR><TABLE BORDER='0' cellspacing='5' cellpadding='0' align='center' width='600'>
  	<TR>
  	     <TD bgcolor='green' align=center width=130><FONT size=-1 color='white'>Nombre teatro</FONT></TD>
  	        <?php  $teatro->mostrarNombreTeatro();?>
  	     <TD bgcolor='green' align=center width=130><FONT size=-1 color='white'>Nombre obra teatral</FONT></TD>
             <?php  $teatro->mostrarNombreObra();?>
        </TR><TR>
             <TD bgcolor='green' align=center width=130><FONT size=-1 color='white'>Sesión</FONT></TD>
             <TD colspan=3><FONT size=-1>Hora : <?php  $teatro->mostrarSesion();?></B></FONT></TD>
             <TD colspan=3><FONT size=-1>Día : <?php  $teatro->mostrarDia();?></FONT></TD>
        </TR>     
        </TABLE><CENTER><TABLE BORDER='0' cellspacing='1' cellpadding='0' align='center' width='200'>
        	<TR><TD align=center>Escenario<BR><HR></TD></TR>
              </TABLE><BR>
          <?php $teatro->mostrarAsientos() ?>
          <BR>Nota: se puede reservar un máximo de 5 localidades por persona.
<P>
<TABLE>
	<TR><TD bgcolor=lime><img src=1px.gif height=10 width=10 border=0></TD><TD><font size=2>&nbsp;Butaca libre.</font></TD></TR>
	<TR><TD bgcolor=orange><img src=1px.gif height=10 width=10 border=0></TD><TD><font size=2>&nbsp;Butaca reservada.</font></TD></TR>
	<TR><TD bgcolor=red><img src=1px.gif height=10 width=10 border=0></TD><TD><font size=2>&nbsp;Butaca ocupada.</font></TD></TR>
</TABLE>

</BODY>
</HTML>