DELIMITER $$
drop trigger if exists ejercicio2$$
create trigger ejercicio2
before update
on empleado
for each row
begin
	declare a int default 0;
	declare mensaje varchar(200);
    set mensaje='Modificación denegada de: ';
	if new.nombre!=old.nombre then
		set a=a+1;
		set mensaje=concat(mensaje, 'nombre, ');
    end if;
    if new.numemp!=old.numemp then
		set a=a+1;
		set mensaje=concat(mensaje, 'número de empleado, ');
    end if;
    if new.cuota>(old.cuota*1.1) then
		set a=a+1;
       	set mensaje=concat(mensaje, 'cuota ');
    end if;
    if a>0 then
		SIGNAL SQLSTATE '02000'
		SET MESSAGE_TEXT = mensaje;
    end if;
end;