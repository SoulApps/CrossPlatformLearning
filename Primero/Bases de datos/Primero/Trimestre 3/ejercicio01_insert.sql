Delimiter $$
	drop trigger if exists after_empleado_insert$$
	create trigger after_empleado_insert after insert on empleado 
	for each row
		begin 
            declare cadena varchar(200);
            
            set cadena = concat(now()," - ", new.numEmp," - ",new.nombre," - INSERCION");
            insert into auditemple (col1) values (cadena);
		end $$
Delimiter ;