CREATE DEFINER=`root`@`localhost` PROCEDURE `ejercicio16_b01`()
BEGIN
	declare tabla_vacia condition for sqlstate "45000";
	declare hecho, x int default 0;
    declare y, j int default 1;
    declare of int;
    declare c2 cursor for select oficina from oficina order by 1;
    
    declare continue handler for not found set hecho = 1;
    declare exit handler for tabla_vacia 
		begin 
			if (y = 0) then
				select "La tabla empleado está vacía" as "Mensaje";
			elseif (j = 0) then 
				select "La tabla oficina está vacía" as "Mensaje";
			end if;
        end;
	declare exit handler for 1146 -- Tabla no existe.
		begin 
			select "La tabla no existe" as "Mensaje";
		end;
	declare exit handler for sqlwarning, sqlexception 
		begin
			select "Se ha producido un error inesperado" as "mensaje";
		end;
        
	select count(*) into y from empleado;
    if (y = 0) then 
		signal tabla_vacia;
    end if;
    
    select count(*) into j from oficina;
    if (j = 0) then 
		signal tabla_vacía;
	end if;
    
    open c2;
		repeat
            fetch c2 into of;
			select count(*) into x from empleado where codoficina = of;
            if (x != 0) then 
				if (hecho != 1) then 
					select of as "Oficina";
					select nombre, ventas from empleado where of = codoficina order by 2 limit 2;
				end if;
			end if;
        until hecho = 1
        end repeat;
    close c2; 
END