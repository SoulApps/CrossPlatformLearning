CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio04`(empleado VARCHAR(30))
BEGIN
	DECLARE a VARCHAR(30);
    -- OPCIÓN ÓPTIMA
	DECLARE EXIT HANDLER FOR 1146
		BEGIN
			SET a = 'Tabla no encontrada';
            SELECT a 'Error';
		END;
    DECLARE EXIT HANDLER FOR NOT FOUND
		BEGIN
			SET a = 'Empleado no encontrado';
            SELECT a 'Error';
		END;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN
			SET a = 'Error desconocido';
            SELECT a 'Error';
		END;
	DECLARE CONTINUE HANDLER FOR SQLWARNING BEGIN END;
	
    SELECT nombre INTO a FROM empleado WHERE nombre = empleado;
	SELECT * FROM empleado WHERE nombre = empleado;
        
	/*SELECT nombre INTO a FROM empleado WHERE nombre = empleado;
	IF a IS NULL THEN
		SELECT CONCAT('No existe el empleado ', empleado) 'Error';
	ELSE 
		SELECT * FROM empleado WHERE nombre = empleado;
	END IF;*/
        
	/*IF empleado NOT IN(SELECT nombre FROM empleado) THEN
		SELECT 'No existe ese empleado';
	ELSE
		SELECT * FROM empleado WHERE nombre = empleado;
	END IF;*/
END