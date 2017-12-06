Delimiter $$
	drop trigger if exists after_profesor_insert $$
	create trigger after_profesor_insert after insert on profesor
	for each row
		begin 
        /* 1.- Disparador ( BEFORE INSERT ) que impida dar de alta un profesor si el 
        número total de profesores que ya tiene la universidad es 5. Una vez hecho 
        cambiar el momento del disparo por AFTER y explicar qué sucede. */
            declare x int default 0;
            declare plantilla_llena condition for sqlstate "45000";
            declare exit handler for plantilla_llena 
            begin
				resignal;
            end;
            
            select count(*) into x from profesor;
			if (x > 5) then 
				signal plantilla_llena 
                set message_text = "Plantilla llena, ya hay 5 profesores en la universidad";
            end if;

		end $$
Delimiter ;