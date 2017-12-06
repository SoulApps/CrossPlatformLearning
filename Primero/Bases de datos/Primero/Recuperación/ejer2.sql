CREATE DEFINER=`root`@`localhost` TRIGGER `recuperacion`.`viviendas_AFTER_UPDATE` AFTER UPDATE ON `viviendas` FOR EACH ROW
BEGIN
	DECLARE a INT DEFAULT 0;
    DECLARE mensaje VARCHAR(200);
    SET mensaje='Ese valor no es válido';
    
    IF
		NEW.tipo_viv!='B'
        THEN SET a=a+1;
    END IF;
    
   IF
		a>0 
		THEN 
		SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT= mensaje;
	END IF;
END