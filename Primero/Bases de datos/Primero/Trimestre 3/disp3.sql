/*3.- Disparador que no permita la inserción de más de 2 filas en una misma orden en la
tabla oficinas.*/

DELIMITER $$
DROP trigger IF EXISTS before_oficina_insert$$
CREATE TRIGGER before_oficina_insert
BEFORE insert ON oficina
FOR EACH ROW
BEGIN
	set @cont=@cont+1;
    if @cont>2 then
		signal sqlstate '45000'
        set message_text= "Ha superado el numero de insercion por orden";
	end if;
END $$
DELIMITER ;
set @cont=0; -- En oracle se hace con un trigger before for each statement 
insert into oficina(oficina) values (5),(6),(7);
select @cont;