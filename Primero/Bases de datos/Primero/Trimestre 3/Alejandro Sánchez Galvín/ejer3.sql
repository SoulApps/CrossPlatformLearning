CREATE DEFINER=`root`@`localhost` TRIGGER `ventas`.`lineaspedido_BEFORE_INSERT` 
BEFORE INSERT ON `lineaspedido` 
FOR EACH ROW
begin
	declare cadena varchar(200);
	if sum(importe)>cliente.limcredito
		then
			set cadena='No tienes dinero';
	end if;
end