CREATE DEFINER=`root`@`localhost` FUNCTION `Ejercicio11`(a1 DATE, a2 DATE) RETURNS int(11)
BEGIN
	RETURN TRUNCATE(Ejercicio10(a1, a2) / 3, 0);
END