Delimiter $$
	drop trigger if exists after_empleado_delete$$
	create trigger after_empleado_delete after delete on empleado 
	for each row
		begin 
            declare cadena varchar(200);
            
            set cadena = concat(now()," - ", old.numEmp," - ",old.nombre," - BORRADO");
            insert into auditemple (col1) values (cadena);
		end $$
Delimiter ;