/*Alejandro Sánchez Galvín*/
-- Ejercicio 1 INSERT
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

-- Ejercicio 1 UPDATE
CREATE DEFINER=`root`@`localhost` TRIGGER `esqui`.`esquiador_AFTER_UPDATE` AFTER UPDATE ON `esquiador` FOR EACH ROW
BEGIN
	DECLARE fed INT(3);
    
	IF NEW.cod_equ IS NOT NULL THEN
		SELECT cod_fed INTO fed FROM equipo WHERE NEW.cod_equ = cod_equ;
        IF NEW.cod_fed != fed THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El esquiador y su equipo no son de la misma federación';
		END IF;
	END IF;
END

-- Ejercicio 2 INSERT
CREATE DEFINER=`root`@`localhost` TRIGGER `esqui`.`equipo_AFTER_INSERT` AFTER INSERT ON `equipo` FOR EACH ROW
BEGIN
	DECLARE cont INT;
    DECLARE fed INT(3);
    
    SELECT COUNT(*) INTO cont FROM equipo WHERE cod_entr = NEW.cod_entr;
    
    IF cont = 1 THEN
		SELECT cod_fed INTO fed FROM esquiador WHERE dni = NEW.cod_entr;
        IF NEW.cod_fed != fed THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El entrenador no pertenece a la misma federación que su equipo';
		END IF;
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ese entrenador ya entrena a otro equipo';
	END IF;
END

-- Ejercicio 2 UPDATE
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

-- Ejercicio 3 INSERT
CREATE DEFINER=`root`@`localhost` TRIGGER `esqui`.`pista_compuesta_BEFORE_INSERT` BEFORE INSERT ON `pista_compuesta` FOR EACH ROW
BEGIN
	IF NEW.n_pista = NEW.n_pista_comp AND NEW.cod_est = NEW.cod_est_comp THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Una pista compuesta no puede pertenecer a sí misma';
	END IF;
    
    IF NEW.cod_est != NEW.cod_est_comp THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Las pistas deben pertenecer a la misma estación';
	END IF;
END

-- Ejercicio 3 UPDATE
CREATE DEFINER=`root`@`localhost` TRIGGER `esqui`.`pista_compuesta_BEFORE_UPDATE` BEFORE UPDATE ON `pista_compuesta` FOR EACH ROW
BEGIN
	IF NEW.n_pista = NEW.n_pista_comp AND NEW.cod_est = NEW.cod_est_comp THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Una pista compuesta no puede pertenecer a sí misma';
	END IF;
    
    IF NEW.cod_est != NEW.cod_est_comp THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Las pistas deben pertenecer a la misma estación';
	END IF;
END

-- Ejercicio 4
CREATE DEFINER=`root`@`localhost` PROCEDURE `Ejercicio4`(esq VARCHAR(9))
BEGIN
	DECLARE a VARCHAR(50);
    DECLARE cont INT DEFAULT 0;
    DECLARE prueba INT(3);
    DECLARE modo INT(1);
    DECLARE done INT(1) DEFAULT 0;
    DECLARE cur CURSOR FOR SELECT p.cod_prueba, modalidad FROM prueba p, part_prueba_indi i, part_prueba_equ e WHERE dni = esq AND
		(p.cod_prueba = e.cod_prueba AND cod_equ = (SELECT cod_equ FROM esquiador WHERE dni = esq)
		OR p.cod_prueba = i.cod_prueba) GROUP BY 1;
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;
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
    
    
    SELECT COUNT(*) INTO cont FROM prueba;
    IF cont = 0 THEN
		SET done = 1;
		SET a = 'No hay pruebas';
        SELECT a 'Error';
	END IF;
    
    SELECT COUNT(*) INTO cont FROM esquiador WHERE dni = esq;
    IF cont = 0 THEN
		SET done = 1;
		SET a = 'No existe ese esquiador';
        SELECT a 'Error';
	END IF;
    
    IF done = 0 THEN
		SET done = 0;
		SET cont = 0;
		OPEN cur;
		REPEAT
			FETCH cur INTO prueba, modo;
			IF NOT done THEN
				IF modo = 1 THEN
					SET a = 'Individual';
				ELSE
					SET a = 'Equipo';
                END IF;
				SELECT prueba 'Prueba', a 'Modalidad';
				SET cont = cont + 1;
			END IF;
			UNTIL DONE
		END REPEAT;
		CLOSE cur;
		IF cont > 0 THEN
			SELECT cont 'Número de pruebas realizadas por el esquiador';
		ELSE
			SET a = 'Este esquiador no ha participado en ninguna prueba';
			SELECT a 'Error';
		END IF;
	END IF;
END