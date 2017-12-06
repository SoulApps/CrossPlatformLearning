CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio02`(INOUT cadena VARCHAR(255))
BEGIN
	SET cadena = REVERSE(cadena);
    SELECT cadena;
END