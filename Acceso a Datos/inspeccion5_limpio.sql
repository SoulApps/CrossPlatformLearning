DROP TABLE "VISITA"
DROP TABLE "ASOCIA"
DROP TABLE "MIEMBRO";
DROP TABLE "CENTRO";
DROP TABLE "USUARIO";
DROP SEQUENCE "secuencia_id_centro";
DROP SEQUENCE "secuencia_id_miembro";
DROP SEQUENCE "secuencia_id_usuario";


CREATE TABLE "ASOCIA" (
    id_inspector integer NOT NULL,
    id_centro integer NOT NULL,
    anho numeric(4,0) NOT NULL
);


CREATE SEQUENCE secuencia_id_centro
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE "CENTRO" (
    id integer DEFAULT nextval('secuencia_id_centro'::regclass) NOT NULL,
    nombre character(40) NOT NULL,
    oferta text,
    notas text,
    localidad character(40) NOT NULL
);


CREATE SEQUENCE secuencia_id_miembro
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;




CREATE TABLE "MIEMBRO" (
    id integer DEFAULT nextval('secuencia_id_miembro'::regclass) NOT NULL,
    nombre character(40) NOT NULL,
    cargo character(40) NOT NULL,
    telefono numeric(9,0),
    correo character(40),
    notas text,
    anho numeric(4,0) NOT NULL,
    id_centro integer NOT NULL
);




CREATE SEQUENCE secuencia_id_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



CREATE TABLE "USUARIO" (
    id integer DEFAULT nextval('secuencia_id_usuario'::regclass) NOT NULL,
    nombre character(40) NOT NULL,
    correo character(40),
    telefono integer,
    tipo character(1) NOT NULL,
    password character(40)
);



CREATE TABLE "VISITA" (
    id_inspector integer NOT NULL,
    id_centro integer NOT NULL,
    fecha date NOT NULL,
    motivo text,
    resolucion text
);



INSERT INTO "ASOCIA" VALUES (6, 1, 2015);
INSERT INTO "ASOCIA" VALUES (6, 1, 2016);
INSERT INTO "ASOCIA" VALUES (6, 2, 2015);
INSERT INTO "ASOCIA" VALUES (6, 3, 2015);
INSERT INTO "ASOCIA" VALUES (7, 2, 2016);
INSERT INTO "ASOCIA" VALUES (7, 4, 2015);
INSERT INTO "ASOCIA" VALUES (7, 5, 2015);
INSERT INTO "ASOCIA" VALUES (8, 1, 2015);
INSERT INTO "ASOCIA" VALUES (8, 3, 2015);
INSERT INTO "ASOCIA" VALUES (8, 3, 2016);
INSERT INTO "ASOCIA" VALUES (9, 4, 2016);
INSERT INTO "ASOCIA" VALUES (9, 5, 2013);
INSERT INTO "ASOCIA" VALUES (10, 3, 2014);
INSERT INTO "ASOCIA" VALUES (10, 5, 2014);
INSERT INTO "ASOCIA" VALUES (10, 5, 2016);



INSERT INTO "CENTRO" VALUES (1, 'CEIP San Bernardo                       ', '<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta content="text/html; charset=ISO-8859-1"
 http-equiv="content-type">
  <title></title>
</head>
<body>
<br>
<h5>EDUCACION INFANTIL.- 3-6 años</h5>
<ul>
<li><span style="font-size:13px;line-height:19px;">Enseñanza bilingüe (curriculum integrado hispano-británico, según convenio MECD-British Council).</span></li>
<li><span style="font-size:13px;line-height:19px;">Logopedia: estimulación del lenguaje por parte de la especialista en Audición y Lenguaje.</span></li>
<li><span style="font-size:13px;line-height:19px;">Pedagogía Terapéutica.</span></li>
<li><span style="font-size:13px;line-height:19px;">Servicio de Orientación Educativa (Orientadora y Trabajadora Social).</span></li>
<li><span style="font-size:13px;line-height:19px;">Tutoría de Acogida.</span></li>
<li><span style="font-size:13px;line-height:19px;">Sesiones de lengua y cultura rumanas.</span></li>
</ul>
<h5>&nbsp;EDUCACION PRIMARIA.- 6-12 años</h5>
<ul>
<li><span style="font-size:13px;line-height:19px;">Enseñanza bilingüe (curriculum integrado hispano-británico, según convenio MECD-British Council). Actualmente en primero de Primaria.</span></li>
<li><span style="font-size:13px;line-height:19px;">Segunda lengua extranjera (francés) en el tercer ciclo de Primaria (quinto y sexto).</span></li>
<li><span style="font-size:13px;line-height:19px;">Tutoría de Acogida.</span></li>
<li><span style="font-size:13px;line-height:19px;">Logopedia y Pedagogía Terapéutica.</span></li>
<li><span style="font-size:13px;line-height:19px;">Nuevas tecnologías en la escuela (tablets PC-Pizarra Digital)</span></li>
<li><span style="font-size:13px;line-height:19px;">Programa de Refuerzo, Orientación y Apoyo educativos (PROA).</span></li>
<li><span style="font-size:13px;line-height:19px;">Sesiones de lengua y cultura rumanas.</span>
</body>
</html>
', 'Impartimos clases de <strong><span style="color: #0000ff;">Inglés</span></strong> desde Infantil de tres años y a partir de quinto de Educación Primaria se incorpora el <strong><span style="color: #0000ff;">Alemán</span></strong> como segunda Lengua Extranjera.&nbsp; Además, desde ya hace varios años participamos en&nbsp; el Proyecto CLIL, con <strong><span style="color: #0000ff;">una sesión semanal de Conocimiento del Medio en Inglés. El presente curso escolar participa en el proyecto&nbsp;</span><span style="color: #0000ff;">2º y 3er curso.</span></strong></p>
<p style="text-align: justify;">Disponemos de servicio de <strong><span style="color: #0000ff;">Acogida Temprana</span></strong>, con el fin de conciliar vida laboral y familiar. Asimismo, por las tardes la AMPA del centro ofrece <span style="color: #0000ff;"><strong>un amplio abanico de actividades extraescolares.</strong></span></p>
<p style="text-align: justify;">También en horario de tarde, se ofertan <strong><span style="color: #0000ff;">clases de árabe</span></strong>, en convenio entre el Ministerio de Asuntos Exteriores y el Gobierno Marroquí. Debemos destacar también que somos centro colaborador de <strong><span style="color: #0000ff;">Radio ECCA</span></strong>, cediendo nuestras instalaciones para sus clases, así como para el <strong><span style="color: #0000ff;">Centro de Educación de Personas Adultas</span></strong> (CEPA) de Santa Lucía.</p>ç', 'Algeciras                               ');
INSERT INTO "CENTRO" VALUES (4, 'IES Kursaal                             ', '<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta content="text/html; charset=ISO-8859-1"
 http-equiv="content-type">
  <title></title>
</head>
<body>
<br>
<span style="font-size: 10pt;">Bilingüe y TIC</span>
<p style="text-align: center;">E.S.O.</p>
<p style="text-align: center;">P.C.P.I. (Auxiliar
Informático)</p>
<p style="text-align: center;">Formación Profesional Básica</p>
<p style="text-align: center;">Bachilleratos de Ciencias y
de Humanidades y Ciencias Sociales</p>
<p style="text-align: center;">Educación Secundaria de
Adultos Semipresencial: Niveles I y II</p>
<p style="text-align: center;">Bachillerato de Adultos
Presencial (Ciencias)</p>
<p style="text-align: center;"><span>Bachillerato de
Adultos&nbsp;</span>Semipresencial (Humanidades y Ciencias
Sociales)</p>
<p style="text-align: center;">Ciclo Formativo Grado Medio
(Explotación de Sistemas Informáticos)</p>
<p style="text-align: center;">Ciclo Formativo Grado
Superior (Administración de Sistemas Informáticos)</p>
</body>
</html>
', '<a href="/index.php/actividades/29-infantil">Infantil</a>
			
						
				
					</li>
							<li>
			<a href="/index.php/actividades/30-primer-ciclo">Primer Ciclo</a>
			
						
				
					</li>
							<li>
			<a href="/index.php/actividades/31-segundo-ciclo">Segundo Ciclo</a>
			
						
				
					</li>
							<li>
			<a href="/index.php/actividades/32-tercer-ciclo">Tercer Ciclo</a>
			
						
				
					</li>
							<li>
			<a href="/index.php/actividades/33-generales">Generales</a>', 'Algeciras                               ');
INSERT INTO "CENTRO" VALUES (5, 'IES Saladillo                           ', '<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta content="text/html; charset=ISO-8859-1"
 http-equiv="content-type">
  <title></title>
</head>
<body>
<br>
<h1 class="content-headline">Oferta educativa</h1>
<p>El IES Saladillo tiene en la actualidad la siguiente oferta
educativa:<br>
* Enseñanza Secundaria Obligatoria.<br>
* Bachillerato de Ciencias y Tecnología.<br>
* Bachillerato de Humanidades y Ciencias Sociales.<br>
* Formación Profesional Básica Informática y Comunicaciones.<br>
* Ciclo Formativo de Grado Medio Sistemas Microinformáticos y Redes.<br>
* Ciclo Formativo de Grado Superior Desarrollo de Aplicaciones
Multiplataforma.</p>
</body>
</html>
', '<h1 class="content-headline">Datos de interés</h1>
		<ul>
<ul>
<li><strong>Denominación</strong>: I.E.S. Saladillo.</li>
<li><strong>Localidad</strong>: Algeciras.</li>
<li><strong>Código</strong>: 11008446.</li>
<li><strong>Horario de Secretaría</strong>: 9:30h – 12:30h</li>
<li><strong>Lema</strong>: <em>Ex me melior exibis</em> (de aquí saldrás mejor).</li>
<li><strong>Logo</strong>: <a title="Logo del IES Saladillo" href="http://dl.dropbox.com/u/67422/iessaladillo/Datos%20de%20interes/logo.gif" target="_blank">descargar</a>.</li>
<li><strong>Dirección postal</strong>: Avda. Duque de Rivas s/n C.P. 11207 Algeciras (Cádiz).</li>
<li><strong>Teléfonos</strong>: 956604947 y 956670813 (491813 corporativo).</li>
<li><strong>Fax</strong>: 956573834 y 956670819 (491819 corporativo).</li>
<li><strong>e-mail</strong>: <a title="e-mail del IES Saladillo" href="mailto:11008446.edu@juntadeandalucia.es" target="_blank">11008446.edu@juntadeandalucia.es</a>.</li>
<li><strong>Página web</strong>: <a title="Página web del IES Saladillo" href="http://www.iessaladillo.es/" target="_blank">http://www.iessaladillo.es/</a>.</li>
<li><strong>Plataforma Helvia</strong>: <a href="http://www.juntadeandalucia.es/averroes/centros-tic/11008446/helvia/" target="_blank">http://www.juntadeandalucia.es/averroes/centros-tic/11008446/helvia/</a>.</li>
<li><strong>Cómo llegar</strong>: <a title="Cómo llegar" href="http://www.iessaladillo.es/web/nuestro-centro/como-llegar/" target="_blank">Página informativa sobre cómo llegar</a>.</li>
<li><strong>Coordenadas GPS</strong>: W 5.45163 N 36.12091</li>', 'Algeciras                               ');
INSERT INTO "CENTRO" VALUES (2, 'Los Pinos                               ', '<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta content="text/html; charset=ISO-8859-1"
 http-equiv="content-type">
  <title></title>
</head>
<body>
<br>
“La Menacha”.
<p><iframe
 src="https://maps.google.es/maps?client=firefox-a&amp;ie=UTF8&amp;q=google+maps+colegio+los+pinos+algeciras&amp;fb=1&amp;gl=es&amp;hq=colegio+los+pinos&amp;hnear=0xd0c9496ba5d5751:0xa626ca859cd81ce9,Algeciras,+C%C3%A1diz&amp;cid=0,0,1813275018216560976&amp;t=m&amp;ll=36.154959,-5.461278&amp;spn=0.006064,0.012875&amp;z=16&amp;iwloc=A&amp;output=embed"
 marginwidth="0" marginheight="0" frameborder="0"
 height="350" scrolling="no" width="600"></iframe><br>
<small><a style="color: rgb(0, 0, 255); text-align: left;"
 href="https://maps.google.es/maps?client=firefox-a&amp;ie=UTF8&amp;q=google+maps+colegio+los+pinos+algeciras&amp;fb=1&amp;gl=es&amp;hq=colegio+los+pinos&amp;hnear=0xd0c9496ba5d5751:0xa626ca859cd81ce9,Algeciras,+C%C3%A1diz&amp;cid=0,0,1813275018216560976&amp;t=m&amp;ll=36.154959,-5.461278&amp;spn=0.006064,0.012875&amp;z=16&amp;iwloc=A&amp;source=embed"
 target="_blank">Ver mapa más grande</a></small></p>
<p>El Colegio los Pinos está situado en la Colonia San Miguel,
Calle Tamarindo S/núm. Código postal 11205, en Algeciras, Cádiz</p>
</body>
</html>
', '<strong>SECRETARÍA</strong></span></span></p>
<p style="text-align: center;">&nbsp;</p> </div><div class="n module-type-text diyfeLiveArea "> <p><span style="font-size:16px;">Nuestro horario de Secretaría:</span></p>
<p><span style="font-size:16px;"><strong>Lunes a Viernes de 9:00 a 10:00 horas</strong></span></p> </div><div class="n module-type-hr diyfeLiveArea "> <div style="padding: 0px 0px">
    <div class="hr"></div>
</div>
 </div><div class="n module-type-spacer diyfeLiveArea "> <div class="the-spacer id28315324" style="height: 33px;">
</div>
 </div><div class="n module-type-text diyfeLiveArea "> <p><span style="color:#7803b2;"><span style="font-size:16px;"><strong>HORARIO DEL ALUMNADO</strong></span></span></p>
<ul>
<li><span style="font-size:16px;"><strong>Septiembre y Junio</strong>:</span></li>
</ul>
<p><span style="font-size:16px;">De 9:00 a 13:00 horas.</span></p>
<ul>
<li><strong><span style="font-size:16px;">De Octubre a Mayo:</span></strong></li>
</ul>
<p><span style="font-size:16px;">De 9:00 a 14:00 horas.</span>', 'Los Barrios                             ');
INSERT INTO "CENTRO" VALUES (3, 'El patio de mi casa                     ', '<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta content="text/html; charset=ISO-8859-1"
 http-equiv="content-type">
  <title></title>
</head>
<body>
<br>
<span style="font-family: Calibri;" face="Calibri">A
continuación le mostramos la oferta educativa del CEIP Las Granjas para
el curso escolar 2013/14.</span>
<p><span style="font-size: small;" size="3"><span
 style="font-family: Calibri;" face="Calibri"><span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman">&nbsp;<span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman"> </span></span></span></span></p>
<table style="border-collapse: collapse;" border="1"
 cellpadding="0" cellspacing="0">
  <tbody>
    <tr>
      <td
 style="border: 1pt solid windowtext; padding: 0cm 5.4pt; background: rgb(218, 238, 243) none repeat scroll 0%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial; width: 432.2pt;"
 valign="top" width="576"><span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-size: small;" size="3"><span
 style="font-family: Calibri;" face="Calibri">EDUCACIÓN
INFANTIL</span></span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-size: small;" size="3"><span
 style="font-family: Calibri;" face="Calibri">Segundo
Ciclo</span></span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-size: small;" size="3"><span
 style="font-family: Calibri;" face="Calibri">Inf.l 3
años <b>3 unidades&nbsp; &nbsp; &nbsp;&nbsp; </b>Inf.
4 años <b>3 unidades&nbsp; &nbsp; &nbsp; &nbsp; </b>Inf.
5 años <b>3 unidades</b></span></span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span></td>
    </tr>
  </tbody>
</table>
<p><span style="font-size: small;" size="3"><span
 style="font-family: Calibri;" face="Calibri"><span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman"><span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman"><span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman"><span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman">&nbsp;</span></span></span></span></span></span></p>
<table style="border-collapse: collapse;" border="1"
 cellpadding="0" cellspacing="0">
  <tbody>
    <tr>
      <td
 style="border: 1pt solid windowtext; padding: 0cm 5.4pt; background: rgb(218, 238, 243) none repeat scroll 0%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial; width: 432.2pt;"
 valign="top" width="576"><span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-size: small;" size="3"><span
 style="font-family: Calibri;" face="Calibri">EDUCACIÓN
PRIMARIA</span></span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-family: Calibri;" face="Calibri"><span
 style="font-size: small;" size="3">Primer
Ciclo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Segundo
Ciclo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Tercer Ciclo</span></span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp; </span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri;" face="Calibri"><span
 style="font-size: small;" size="3">1º
Primaria&nbsp;&nbsp; 3 unidades&nbsp;&nbsp; 3º
Primaria&nbsp;&nbsp; 4
unidades&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp; 5º
Primaria&nbsp;&nbsp;&nbsp;4 unidades</span></span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri;" face="Calibri"><span
 style="font-size: small;" size="3">2º
Primaria&nbsp;&nbsp;&nbsp;3 unidades&nbsp;&nbsp; 4º
Primaria&nbsp;&nbsp;&nbsp;4
unidades&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
6º Primaria&nbsp;&nbsp;&nbsp;3 unidades</span></span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span></td>
    </tr>
  </tbody>
</table>
<p>&nbsp;</p>
<table style="border-collapse: collapse;" border="1"
 cellpadding="0" cellspacing="0">
  <tbody>
    <tr>
      <td
 style="border: 1pt solid windowtext; padding: 0cm 5.4pt; background: rgb(218, 238, 243) none repeat scroll 0%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial; width: 432.2pt;"
 valign="top" width="576"><span
 style="font-family: Times New Roman; font-size: small;" size="3"
 face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-size: small;" size="3"><span
 style="font-family: Calibri;" face="Calibri">COMUNES</span></span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-size: small;" size="3"><span
 style="font-family: Calibri;" face="Calibri">Educación
Especial</span></span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><b><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri;" face="Calibri"><span
 style="font-size: small;" size="3">1
Aula&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Audición y
Lenguaje&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span></p>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri;" face="Calibri"><span
 style="font-size: small;" size="3"></span></span><span
 style="font-family: Calibri;" face="Calibri"><span
 style="font-size: small;" size="3">2
Aulas&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pedagogía
Terapéutica&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><b><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></b></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span>
      <p style="margin: 0cm 0cm 0pt; line-height: normal;"><span
 style="font-family: Calibri; font-size: small;" size="3"
 face="Calibri">&nbsp;</span></p>
      <span style="font-family: Times New Roman; font-size: small;"
 size="3" face="Times New Roman"></span></td>
    </tr>
  </tbody>
</table>
<p>&nbsp;</p>
</body>
</html>
', '<h4 style="text-align: left" class="vc_custom_heading">¿Qué es un huerto escolar ecológico?</h4>
	<div class="wpb_text_column wpb_content_element ">
		<div class="wpb_wrapper">
			<p class="p1">El huerto escolar es un lugar en el que vamos a tener experiencias con el entorno,<span class="Apple-converted-space">&nbsp; </span>y podemos poner en práctica actitudes y hábitos de cuidado y responsabilidad medioambiental.</p>
<p class="p1">Que nuestro huerto sea ecológico supone conocer unas técnicas respetuosas con nuestra salud y el medio ambiente.</p>

		</div>
	</div>
</div></div></div><div class="wpb_column vc_column_container vc_col-sm-6"><div class="vc_column-inner "><div class="wpb_wrapper">
	<div class="wpb_single_image wpb_content_element vc_align_left">
		
		<figure class="wpb_wrapper vc_figure">
			<div class="vc_single_image-wrapper   vc_box_border_grey"><img src="http://ceipsierranevada.org/wp-content/uploads/2016/08/20160419_164445_HDR.jpg" class="vc_single_image-img attachment-full" alt="20160419_164445_HDR" srcset="http://ceipsierranevada.org/wp-content/uploads/2016/08/20160419_164445_HDR.jpg 1600w, http://ceipsierranevada.org/wp-content/uploads/2016/08/20160419_164445_HDR-300x169.jpg 300w, http://ceipsierranevada.org/wp-content/uploads/2016/08/20160419_164445_HDR-768x432.jpg 768w, http://ceipsierranevada.org/wp-content/uploads/2016/08/20160419_164445_HDR-1024x576.jpg 1024w, http://ceipsierranevada.org/wp-content/uploads/2016/08/20160419_164445_HDR-150x84.jpg 150w" sizes="(max-width: 1600px) 100vw, 1600px" width="1600" height="900">', 'Los Barrios                             ');


INSERT INTO "MIEMBRO" VALUES (1, 'MariaJosé                               ', 'Director/a                              ', 111111111, 'mj@gmail.com                            ', NULL, 2015, 1);
INSERT INTO "MIEMBRO" VALUES (2, 'Jose                                    ', 'Vicedirector/a                          ', 222222222, 'jose@gmail.com                          ', NULL, 2015, 1);
INSERT INTO "MIEMBRO" VALUES (4, 'Alejandro                               ', 'Director/a                              ', 444444444, 'alex@gmail.com                          ', NULL, 2016, 1);
INSERT INTO "MIEMBRO" VALUES (5, 'Javier                                  ', 'Director/a                              ', 555555555, 'javier@gmail.com                        ', NULL, 2016, 2);
INSERT INTO "MIEMBRO" VALUES (6, 'Isabel                                  ', 'Vicedirector/a                          ', 666666666, 'isabel@gmail.com                        ', NULL, 2016, 2);
INSERT INTO "MIEMBRO" VALUES (7, 'Hayone                                  ', 'Jefe/a de Estudios                      ', 777777777, 'hayone@gmail.com                        ', NULL, 2016, 2);
INSERT INTO "MIEMBRO" VALUES (9, 'Margarita                               ', 'Director/a                              ', 999999999, 'margarita@gmail.com                     ', NULL, 2016, 3);
INSERT INTO "MIEMBRO" VALUES (10, 'Rocío                                   ', 'Director/a                              ', 121212121, 'rocio@gmail.com                         ', NULL, 2014, 4);
INSERT INTO "MIEMBRO" VALUES (11, 'Edurne                                  ', 'Director/a                              ', 123123123, 'edurne@gmail.com                        ', NULL, 2016, 4);
INSERT INTO "MIEMBRO" VALUES (12, 'Anacleto                                ', 'Vicedirector/a                          ', 456456456, 'anacleto@gmail.com                      ', NULL, 2016, 4);
INSERT INTO "MIEMBRO" VALUES (13, 'Paco                                    ', 'Jefe/a de Estudios                      ', 789789789, 'paco@gmail.com                          ', NULL, 2016, 4);
INSERT INTO "MIEMBRO" VALUES (14, 'Inmaculada                              ', 'Director/a                              ', 412412412, 'inma@gmail.com                          ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" VALUES (15, 'Antonia                                 ', 'Jefe/a de Estudios                      ', 512512512, 'toñi@gmail.com                          ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" VALUES (16, 'Manolo                                  ', 'Jefe/a de Estudios                      ', 541541544, 'manolo@gmail.com                        ', NULL, 2014, 5);
INSERT INTO "MIEMBRO" VALUES (17, 'Pilar                                   ', 'Vicedirector/a                          ', 654654654, 'pilar@gmail.com                         ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" VALUES (18, 'Ana                                     ', 'FEIE                                    ', 778977897, 'ana@gmail.com                           ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" VALUES (19, 'Jose Manuel                             ', 'Extraescolares                          ', 998799874, 'josem@gmail.com                         ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" VALUES (20, 'Pedro                                   ', 'TIC                                     ', 898878864, 'pedro@gmail.com                         ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" VALUES (3, 'Laura                                   ', 'Jefe/a de Estudios                      ', 333333333, 'laura@gmail.com                         ', NULL, 2016, 1);
INSERT INTO "MIEMBRO" VALUES (8, 'Raul                                    ', 'Vicedirector/a                          ', 888888888, 'raul@gmail.com                          ', NULL, 2016, 3);


INSERT INTO "USUARIO" VALUES (2, 'Rocio Salas                             ', 'roc@gmail.com                           ', 222222222, 'C', '123                                     ');
INSERT INTO "USUARIO" VALUES (1, 'Ramiro Souto                            ', 'ram@gmail.com                           ', 111111111, 'C', '123                                     ');
INSERT INTO "USUARIO" VALUES (3, 'Esther Seijas                           ', 'est@gmail.com                           ', 333333333, 'C', '123                                     ');
INSERT INTO "USUARIO" VALUES (4, 'Dina Casas                              ', 'dina@gmail.com                          ', 444444444, 'C', '123                                     ');
INSERT INTO "USUARIO" VALUES (5, 'Luis Peña                               ', 'luis@gmail.com                          ', 555555555, 'C', '123                                     ');
INSERT INTO "USUARIO" VALUES (6, 'Sofía Castro                            ', 'sofi@gmail.com                          ', 666666666, 'I', '123                                     ');
INSERT INTO "USUARIO" VALUES (7, 'Ada Castro                              ', 'ada@gmail.com                           ', 777777777, 'I', '123                                     ');
INSERT INTO "USUARIO" VALUES (8, 'Santiago Salgado                        ', 'santi@gmail.com                         ', 888888888, 'I', '123                                     ');
INSERT INTO "USUARIO" VALUES (9, 'Mercedes Platas                         ', 'merchy@gmail.com                        ', 999999999, 'I', '123                                     ');
INSERT INTO "USUARIO" VALUES (10, 'Manolo Ventoso                          ', 'manolo@gmail.com                        ', 121212121, 'I', '123                                     ');



INSERT INTO "VISITA" VALUES (6, 1, '2015-09-01', 'rutina', 'ok');
INSERT INTO "VISITA" VALUES (6, 1, '2015-12-01', 'programaciones', 'ok');
INSERT INTO "VISITA" VALUES (6, 1, '2016-09-01', 'rutina', 'ok');
INSERT INTO "VISITA" VALUES (6, 1, '2017-02-15', 'horario', 'ok');
INSERT INTO "VISITA" VALUES (6, 1, '2017-03-01', 'finanzas', 'errores -> nueva visita');
INSERT INTO "VISITA" VALUES (6, 1, '2017-03-11', 'finanzas', 'ok');
INSERT INTO "VISITA" VALUES (7, 2, '2017-02-20', 'finanzas', 'ok');
INSERT INTO "VISITA" VALUES (7, 2, '2017-02-25', 'rutina', 'errores horarios');
INSERT INTO "VISITA" VALUES (8, 3, '2016-09-15', 'horario', 'ok');
INSERT INTO "VISITA" VALUES (8, 3, '2017-02-25', 'rutina', 'ok');


SELECT pg_catalog.setval('secuencia_id_centro', 5, true);



SELECT pg_catalog.setval('secuencia_id_miembro', 20, true);


SELECT pg_catalog.setval('secuencia_id_usuario', 10, true);



ALTER TABLE ONLY "ASOCIA"
    ADD CONSTRAINT pk_asocia PRIMARY KEY (id_inspector, id_centro, anho);



ALTER TABLE ONLY "MIEMBRO"
    ADD CONSTRAINT pk_equipo PRIMARY KEY (id, id_centro, anho);


ALTER TABLE ONLY "CENTRO"
    ADD CONSTRAINT pk_id PRIMARY KEY (id);



ALTER TABLE ONLY "USUARIO"
    ADD CONSTRAINT pk_id_usuario PRIMARY KEY (id);




ALTER TABLE ONLY "VISITA"
    ADD CONSTRAINT pk_visita PRIMARY KEY (id_inspector, id_centro, fecha);




ALTER TABLE ONLY "ASOCIA"
    ADD CONSTRAINT fk_centro FOREIGN KEY (id_centro) REFERENCES "CENTRO"(id);




ALTER TABLE ONLY "VISITA"
    ADD CONSTRAINT fk_centro FOREIGN KEY (id_centro) REFERENCES "CENTRO"(id);



ALTER TABLE ONLY "MIEMBRO"
    ADD CONSTRAINT fk_centro FOREIGN KEY (id_centro) REFERENCES "CENTRO"(id);




ALTER TABLE ONLY "ASOCIA"
    ADD CONSTRAINT fk_inspector FOREIGN KEY (id_inspector) REFERENCES "USUARIO"(id);



ALTER TABLE ONLY "VISITA"
    ADD CONSTRAINT fk_inspector FOREIGN KEY (id_inspector) REFERENCES "USUARIO"(id);




