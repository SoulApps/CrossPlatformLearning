CREATE DEFINER=`root`@`localhost` FUNCTION `Examen5`(codoficina INT(3)) RETURNS tinyint(1) -- Boolean = tinyint(1)
BEGIN
	DECLARE booleano BOOLEAN DEFAULT FALSE;
    DECLARE a INT DEFAULT 0;
    
    SELECT COUNT(*) INTO a FROM oficina WHERE oficina = codoficina;
    
    IF a > 0 THEN
		SET booleano = TRUE;
	END IF;
RETURN booleano;
END