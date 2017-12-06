CREATE DEFINER=`root`@`localhost` PROCEDURE `Examen4`(pedido INT(6))
BEGIN
	DECLARE a VARCHAR(50);
    DECLARE b INT(3);
    DECLARE done INT(1) DEFAULT 0;
    DECLARE linea, can, imp, id, pre INT;
    DECLARE des VARCHAR(15);
    DECLARE cur CURSOR FOR SELECT numlinea, cant, importe, idproducto FROM lineaspedido WHERE numpedido = pedido;
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done = 1;
	DECLARE EXIT HANDLER FOR 1146
		BEGIN
			SET a = 'Tabla no encontrada';
            SELECT a 'Error';
		END;
    DECLARE EXIT HANDLER FOR NOT FOUND
		BEGIN
			SET a = 'Pedido no encontrado';
            SELECT a 'Error';
		END;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN
			SET a = 'Error desconocido';
            SELECT a 'Error';
		END;
	DECLARE CONTINUE HANDLER FOR SQLWARNING BEGIN END;
    
    SELECT COUNT(*) INTO b FROM pedido;
	IF b = 0 THEN
		SET a = 'Tabla vacía';
		SELECT a 'Error';
	END IF;
    
	SELECT COUNT(*) INTO b FROM lineaspedido WHERE numpedido = pedido;
	IF b = 0 THEN
		SET a = 'No hay líneas de pedido para ese pedido';
		SELECT a 'Error';
	ELSE
		OPEN cur;
		REPEAT
			FETCH cur INTO linea, can, imp, id; -- Lee el cursor
            IF NOT done THEN
				SELECT descripcion INTO des FROM producto WHERE idproducto = id;
				SELECT precio INTO pre FROM producto WHERE idproducto = id;
				SELECT linea 'Nº LÍNEA', des 'DESCIPCIÓN PRODUCTO', pre 'PRECIO', can 'UNIDADES' , imp 'IMPORTE';
			END IF;
		UNTIL done
		END REPEAT;
		CLOSE cur;
		SELECT SUM(importe) 'Total pedido' FROM lineaspedido WHERE numpedido = pedido;
	END IF;
END