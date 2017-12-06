CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio13`()
BEGIN
	DECLARE a VARCHAR(30);
    DECLARE b INT(3);
	DECLARE c INT(1) DEFAULT 0;
	DECLARE done INT(1) DEFAULT 0;
    DECLARE nom VARCHAR(30);
    DECLARE ven INT(6);
    DECLARE cur CURSOR FOR SELECT SUBSTRING_INDEX(nombre, ',', 1) 'Apellido Empleado', ventas FROM empleado;
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN
			SET a = 'Error desconocido';
            SELECT a 'Error';
		END;
	DECLARE CONTINUE HANDLER FOR SQLWARNING BEGIN END;
    
    OPEN cur;
    REPEAT
		FETCH cur INTO nom, ven;
		IF NOT done THEN
			SELECT nom, ven;
			SET c = c + 1;
		END IF;
	UNTIL done OR c = 5
	END REPEAT;
    CLOSE cur;
    
    IF c = 0 THEN
		SELECT 'Listado vacío';
	END IF;
    
    -- Sin cursor.
    /*SELECT COUNT(*) INTO b FROM empleado;
	IF b = 0 THEN
		SELECT 'Tabla vacía';
	ELSE
		SELECT SUBSTRING_INDEX(nombre, ',', 1) 'Apellido Empleado', ventas FROM empleado ORDER BY 2 DESC LIMIT 5; -- Para el apellido este.
		-- SELECT SUBSTRING_INDEX(nombre, ',', -1) 'Nombre Empleado', ventas FROM empleado ORDER BY 2 DESC LIMIT 5; -- Para el nombre este.
    END IF;*/
END