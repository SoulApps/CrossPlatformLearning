Delimiter $$
	drop trigger if exists before_profesor_insert $$
	create trigger before_profesor_insert before insert on profesor
	for each row
		begin 
        /* 1.- Disparador ( BEFORE INSERT ) que impida dar de alta un profesor si el 
        número total de profesores que ya tiene la universidad es 5. Una vez hecho 
        cambiar el momento del disparo por AFTER y explicar qué sucede. */
            declare x int default 0;
            
            select count(*) into x from profesor;
			if (x >= 5) then 
				signal sqlstate "45000"
                set message_text = "Plantilla llena, ya hay 5 profesores en la universidad";
            end if;

		end $$
Delimiter ;