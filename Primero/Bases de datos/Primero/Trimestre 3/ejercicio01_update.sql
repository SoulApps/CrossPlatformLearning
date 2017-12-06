Delimiter $$
	drop trigger if exists after_empleado_update$$
	create trigger after_empleado_update after update on empleado 
	for each row
		begin 
            declare cadena varchar(200);
            
            set cadena = concat(now()," - Empleado: ", old.numEmp);
            
            if (old.numEmp != new.numEmp) then 
				set cadena = concat(cadena, "- NumEmp antiguo: ", old.numEmp, " - NumEmp nuevo: ", new.numEmp);
			end if;
            
			if (old.nombre is null and new.nombre is not null) then 
				set cadena = concat(cadena," - Antiguo nombre: null - Nuevo nombre: ", new.nombre);
			elseif (old.nombre is not null and new.nombre is null) then 
				set cadena = concat(cadena, " - Antiguo nombre: ", old.nombre, " - Nuevo nombre: null");
			elseif (old.nombre != new.nombre) then 
				set cadena = concat(cadena, " - Antiguo nombre: ", old.nombre, " - Nuevo nombre: ", new.Nombre);
            end if;
            
			if (old.fnac is null and new.fnac is not null) then 
				set cadena = concat(cadena," - Antigua fnac: null - Nueva fnac: ", new.fnac);
			elseif (old.fnac is not null and new.fnac is null) then 
				set cadena = concat(cadena, " - Antigua fnac: ", old.fnac, " - Nueva fnac: null");
			elseif (old.fnac != new.fnac) then 
				set cadena = concat(cadena, " - Antigua fnac: ", old.fnac, " - Nueva fnac: ", new.fnac);
            end if;
            
            if (old.codoficina != new.codoficina) then 
				set cadena = concat(cadena, " - Antigua oficina: ", old.codoficina, " - Nueva oficina: ", new.codoficina);
            end if; 
            
			if (old.cargo is null and new.cargo is not null) then 
				set cadena = concat(cadena," - Antiguo cargo: null - Nuevo cargo: ", new.cargo);
			elseif (old.cargo is not null and new.cargo is null) then 
				set cadena = concat(cadena, " - Antiguo cargo: ", old.cargo, " - Nuevo cargo: null");
			elseif (old.cargo != new.cargo) then 
				set cadena = concat(cadena, " - Antiguo cargo: ", old.cargo, " - Nuevo cargo: ", new.cargo);
            end if;
            
			if (old.fcontrato is null and new.fcontrato is not null) then 
				set cadena = concat(cadena," - Antigua fcontrato: null - Nueva fcontrato: ", new.fcontrato);
			elseif (old.fcontrato is not null and new.fcontrato is null) then 
				set cadena = concat(cadena, " - Antigua fcontrato: ", old.fcontrato, " - Nueva fcontrato: null");
			elseif (old.fcontrato != new.fcontrato) then 
				set cadena = concat(cadena, " - Antigua fcontrato: ", old.fcontrato, " - Nueva fcontrato: ", new.fcontrato);
            end if;
            
			if (old.jefe is null and new.jefe is not null) then 
				set cadena = concat(cadena," - Antiguo jefe: null - Nuevo jefe: ", new.jefe);
			elseif (old.jefe is not null and new.jefe is null) then 
				set cadena = concat(cadena, " - Antiguo jefe: ", old.jefe, " - Nuevo jefe: null");
			elseif (old.jefe != new.jefe) then 
				set cadena = concat(cadena, " - Antiguo jefe: ", old.jefe, " - Nuevo jefe: ", new.jefe);
            end if;
			
			if (old.cuota is null and new.cuota is not null) then 
				set cadena = concat(cadena," - Antigua cuota: null - Nueva cuota: ", new.cuota);
			elseif (old.cuota is not null and new.cuota is null) then 
				set cadena = concat(cadena, " - Antigua cuota: ", old.cuota, " - Nueva cuota: null");
			elseif (old.cuota != new.cuota) then 
				set cadena = concat(cadena, " - Antigua cuota: ", old.cuota, " - Nueva cuota: ", new.cuota);
            end if;
            
			if (old.ventas is null and new.ventas is not null) then 
				set cadena = concat(cadena," - Antiguas ventas: null - Nuevas ventas: ", new.ventas);
			elseif (old.ventas is not null and new.ventas is null) then 
				set cadena = concat(cadena, " - Antiguas ventas: ", old.ventas, " - Nuevas ventas: null");
			elseif (old.ventas != new.ventas) then 
				set cadena = concat(cadena, " - Antiguas ventas: ", old.ventas, " - Nuevas ventas: ", new.ventas);
            end if;
			
            set cadena = concat(cadena, " - MODIFICADO");
            insert into auditemple (col1) values (cadena);
		end $$
Delimiter ;