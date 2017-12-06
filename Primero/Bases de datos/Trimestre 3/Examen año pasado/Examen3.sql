CREATE DEFINER=`root`@`localhost` TRIGGER `ventas`.`pedido_BEFORE_INSERT` BEFORE INSERT ON `pedido` FOR EACH ROW
BEGIN
	DECLARE a INT;
    DECLARE b INT;
    SELECT SUM(importe) INTO a FROM lineaspedido l, pedido p WHERE l.numpedido = p.numpedido AND cliente = NEW.cliente GROUP BY cliente, numpedido;
    SELECT limcredito INTO b FROM cliente WHERE numclie = NEW.cliente;
    
    IF a > b THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ERROR, NO TIENES PASTA NIGGA';
	END IF;
END