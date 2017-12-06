CREATE DEFINER=`root`@`localhost` FUNCTION `Ejercicio10`(a1 DATE, a2 DATE) RETURNS int(4)
BEGIN
	RETURN ABS(Ejercicio06(a1) - Ejercicio06(a2));
END