CREATE DEFINER=`root`@`localhost` TRIGGER `ventas`.`producto_BEFORE_DELETE` BEFORE DELETE ON `producto` FOR EACH ROW
BEGIN
	DECLARE a INT DEFAULT 0;
    SELECT COUNT(*) INTO a FROM lineaspedido WHERE idproducto = OLD.idproducto;
    
    IF a != 0 THEN
		DELETE FROM lineaspedido WHERE idproducto = OLD.idproducto;
	END IF;
END