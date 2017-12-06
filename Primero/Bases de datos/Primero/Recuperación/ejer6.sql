CREATE DEFINER=`root`@`localhost` FUNCTION `ejer6`(nombre VARCHAR(15)) RETURNS varchar(2) CHARSET utf8
BEGIN
	DECLARE a VARCHAR(2);
	SELECT cod_z INTO a FROM zonas WHERE nom_z=nombre;
RETURN a;
END