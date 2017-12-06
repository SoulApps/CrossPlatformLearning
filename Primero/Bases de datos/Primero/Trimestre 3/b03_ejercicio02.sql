Delimiter $$
	drop trigger if exists after_notapra_insert $$
	create trigger after_notapra_insert after insert on notapra
	for each row
		begin 
        /* 2.- Disparador AFTER que controle en las inserciones que el nº de alumnos que se 
        matriculan en una práctica no pueda ser superior al valor permitido para la  misma 
        así como que la nota introducida siempre tome un valor correcto. */
			declare numAlumnosMatriculados int default 0;
            declare maximoAlumnos int(3) default 0;
            declare mensaje_error varchar(50);
            declare cupo_alumnos_completo condition for sqlstate "45000";
            declare nota_incorrecta condition for sqlstate "45001";
            declare exit handler for cupo_alumnos_completo
				begin
					resignal;
				end;
            declare exit handler for nota_incorrecta 
				begin 
					resignal;
				end;
            
            if (new.nota < 0 or new.nota > 10 ) then
				signal nota_incorrecta
                set message_text = "La nota no puede ser negativa ni superior a 10.";
            end if;
            
            select count(*) into numAlumnosMatriculados from notapra where cpra = new.cpra;
            select nal into maximoAlumnos from practica where cpra = new.cpra;
            
            if (numAlumnosMatriculados > maximoAlumnos) then 
				set mensaje_error = concat("Ya hay ",maximoAlumnos," alumnos matriculados en la práctica ", new.cpra,".");
				signal cupo_alumnos_completo 
                set message_text = mensaje_error;
            end if;
		end $$
Delimiter ;