CREATE DEFINER=`root`@`localhost` TRIGGER `ventas`.`producto_AFTER_DELETE` 
AFTER DELETE ON `producto`
FOR EACH ROW 
begin 
	declare cadena varchar(200);
            
	set cadena =' ';
	insert into lineaspedido (idproducto) values (cadena);
end