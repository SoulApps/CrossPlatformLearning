CREATE DEFINER=`root`@`localhost` PROCEDURE `Examen5`(oficina INT(3))
BEGIN
	DECLARE a VARCHAR(30) DEFAULT 'No existe esa oficina';
	DECLARE b INT(3);
    DECLARE empleados, representantes INT;
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
    
	SELECT COUNT(*) INTO b FROM empleado;
	IF b = 0 THEN
		SELECT 'Tabla vacía';
	ELSE
		SELECT Examen5(oficina) INTO b;
		IF b = 1 THEN
			SELECT COUNT(*) INTO empleados FROM empleado WHERE codoficina = oficina;
			SELECT COUNT(*) INTO representantes FROM empleado WHERE codoficina = oficina AND numemp IN(SELECT repclie FROM cliente);
			SELECT oficina 'CÓDIGO OFICINA', empleados 'NÚMERO TOTAL DE EMPLEADOS', representantes 'NÚMERO DE REPRESENTANTES';
		ELSE
			SELECT a 'Error';
		END IF;
    END IF;
END