CREATE DEFINER=`root`@`localhost` TRIGGER `ventas`.`empleado_BEFORE_UPDATE` BEFORE UPDATE ON `empleado` FOR EACH ROW
BEGIN
	IF NEW.nombre != OLD.nombre THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error no se puede cambiar el nombre';
	ELSEIF NEW.numemp != OLD.numemp THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error no se puede cambiar el numemp';
    ELSEIF NEW.cuota > OLD.cuota * 1.1 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error no se puede incrementar la cuota en más de 10%';
	END IF;
END