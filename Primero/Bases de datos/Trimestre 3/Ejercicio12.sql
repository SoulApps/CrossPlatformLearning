CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio12`(numero INT(3))
BEGIN
	DECLARE a VARCHAR(30);
    DECLARE b INT(3);
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
	DECLARE EXIT HANDLER FOR 1451
		BEGIN
			SET a = 'Empleado ocupa un cargo';
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
		SELECT numemp INTO b FROM empleado WHERE numemp = numero;
		DELETE FROM empleado WHERE numemp = numero;
        SET a = 'Empleado borrado correctamente';
        SELECT a 'OK';
    END IF;
    
		
END