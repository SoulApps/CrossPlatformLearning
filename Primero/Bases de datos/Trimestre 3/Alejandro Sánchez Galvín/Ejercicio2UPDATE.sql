CREATE DEFINER=`root`@`localhost` TRIGGER `esqui`.`equipo_AFTER_UPDATE` AFTER UPDATE ON `equipo` FOR EACH ROW
BEGIN
	DECLARE cont INT;
    DECLARE fed INT(3);
    
    SELECT COUNT(*) INTO cont FROM equipo q WHERE q.cod_entr = NEW.cod_entr;
    
    IF cont = 1 THEN
		SELECT cod_fed INTO fed FROM esquiador WHERE dni = NEW.cod_entr;
        IF NEW.cod_fed != fed THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El entrenador no pertenece a la misma federación que su equipo';
		END IF;
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ese entrenador ya entrena a otro equipo';
	END IF;
END