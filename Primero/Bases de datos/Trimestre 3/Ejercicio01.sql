CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio01`(INOUT cadena VARCHAR(255))
BEGIN
	SET cadena = UPPER(cadena);
    SELECT cadena;
END