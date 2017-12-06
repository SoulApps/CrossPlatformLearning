CREATE DEFINER=`root`@`localhost` TRIGGER `esqui`.`esquiador_AFTER_INSERT` AFTER INSERT ON `esquiador` FOR EACH ROW
BEGIN
	DECLARE fed INT(3);
    
	IF NEW.cod_equ IS NOT NULL THEN
		SELECT cod_fed INTO fed FROM equipo WHERE NEW.cod_equ = cod_equ;
        IF NEW.cod_fed != fed THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El esquiador y su equipo no son de la misma federación';
		END IF;
	END IF;
END