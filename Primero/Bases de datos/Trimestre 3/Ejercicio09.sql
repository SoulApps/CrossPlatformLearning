CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio09`()
BEGIN
	SELECT nombre, Ejercicio06(fecha) FROM empleado;
END