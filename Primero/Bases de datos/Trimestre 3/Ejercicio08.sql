CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio08`()
BEGIN
	SELECT nombre, Ejercicio06(fecha) FROM empleado;
END