CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio05`()
BEGIN
	DECLARE a VARCHAR(30);
    
	DECLARE EXIT HANDLER FOR 1146
		BEGIN
			SET a = 'Tabla no encontrada';
            SELECT a 'Error';
		END;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN
			SET a = 'Error desconocido';
            SELECT a 'Error';
		END;
	DECLARE CONTINUE HANDLER FOR SQLWARNING BEGIN END;
    
	SELECT nombre, fcontrato FROM empleado ORDER BY 1, 2;
END