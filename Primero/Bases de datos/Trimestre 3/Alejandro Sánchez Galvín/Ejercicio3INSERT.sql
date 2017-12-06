CREATE DEFINER=`root`@`localhost` TRIGGER `esqui`.`pista_compuesta_BEFORE_INSERT` BEFORE INSERT ON `pista_compuesta` FOR EACH ROW
BEGIN
	IF NEW.n_pista = NEW.n_pista_comp AND NEW.cod_est = NEW.cod_est_comp THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Una pista compuesta no puede pertenecer a sí misma';
	END IF;
    
    IF NEW.cod_est != NEW.cod_est_comp THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Las pistas deben pertenecer a la misma estación';
	END IF;
END