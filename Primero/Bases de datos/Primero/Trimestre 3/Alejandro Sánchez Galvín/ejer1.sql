CREATE DEFINER=`root`@`localhost` TRIGGER modIdproducto1
BEFORE UPDATE ON producto
FOR EACH ROW
BEGIN 
DECLARE a INT DEFAULT 0;
DECLARE mensaje VARCHAR(200);
SET mensaje='No se puede modificar'; 
IF NEW.idproducto!=OLD.idproducto
THEN
	set a=a+1;
    set mensaje=concat(mensaje, ': idproducto');
    end if;
if new. precio<=0
then
	set a=a+1;
    set mensaje=concat(mensaje, ' el precio del producto por que es menor o igual que 0');
    end if;
if new. existencias<=0
then
	set a=a+1;
    set mensaje=concat(mensaje, ' las existencias del producto porque es menor o igual que 0');
    end if;
if a>0 then
signal sqlstate '02000' set message_text= mensaje;
end if;
END