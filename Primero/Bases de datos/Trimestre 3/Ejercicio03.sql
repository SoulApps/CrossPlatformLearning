CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio03`(empleado INT(3), oficina INT(2))
BEGIN
	DECLARE EXIT HANDLER FOR 1146
		BEGIN
			SELECT 'Tabla no encontrada';
        END;
	UPDATE empleado SET codoficina = oficina WHERE numemp = empleado;
END