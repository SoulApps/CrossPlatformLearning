CREATE DEFINER=`root`@`localhost` TRIGGER `ventas`.`empleado_BEFORE_INSERT` BEFORE INSERT ON `empleado` FOR EACH ROW
BEGIN
	DECLARE a VARCHAR(200);
    
    SET a = CONCAT('[Fecha: ', NOW(), '] [N: ', NEW.numemp, '] [Nombre: ', NEW.nombre, '] [Acción: INSERCIÓN]');
    
    INSERT INTO auditemple(col1) VALUES (a);
END