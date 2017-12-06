CREATE DEFINER=`root`@`localhost` FUNCTION `Ejercicio06`(fecha DATE) RETURNS year(4)
BEGIN
	DECLARE a YEAR;
    SET a = YEAR(fecha);
RETURN a;
END