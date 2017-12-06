CREATE DEFINER=`root`@`localhost` TRIGGER `ventas`.`empleado_BEFORE_DELETE` BEFORE DELETE ON `empleado` FOR EACH ROW
BEGIN
	DECLARE a VARCHAR(200);
    
    SET a = CONCAT('[Fecha: ', NOW(), '] [N: ', OLD.numemp, '] [Nombre: ', OLD.nombre, '] [Acción: BORRADO]');
    
    INSERT INTO auditemple(col1) VALUES (a);
END