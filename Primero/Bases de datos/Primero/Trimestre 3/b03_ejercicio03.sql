CREATE DEFINER=`root`@`localhost` PROCEDURE `b03_Ejercicio03`(cpra int)
BEGIN
	/* 3.- Procedimiento que modifique el grado de dificultad de una práctica cuyo 
    código se pasará en la llamada aumentando el grado en una unidad (siempre que sea 
    posible)  y   sólo cuando se compruebe que en dicha práctica están matriculados 
    el nº máximo de alumnos permitidos. */
    declare contador, numMaxAlumnos, alumnosMatriculados, dificultad int default 0;
    declare mensaje_error varchar(70);
    declare error_salida condition for sqlstate "45002";
    declare tabla_vacia condition for sqlstate "45000";
    declare practicaNoEncontrada condition for sqlstate "45001";
    
    declare exit handler for tabla_vacia 
		begin 
			resignal;
        end;
	declare exit handler for practicaNoEncontrada
		begin
			resignal;
        end;
	declare exit handler for error_salida
		begin
			resignal;
        end;
	declare exit handler for 1146 -- Tabla no existe.
		begin 
			select "Error, tabla inexistente." as "Mensaje";
		end;
	declare exit handler for sqlwarning, sqlexception 
		begin
			select "Se ha producido un error inesperado" as "mensaje";
		end;
        
    select count(*) into contador from practica;
    if (contador = 0) then 
		signal tabla_vacia 
        set message_text = "La tabla práctica está vacía.";
    end if;
    
    select count(*) into contador from practica p where p.cpra = cpra;
    if (contador = 0) then 
		set mensaje_error = concat("No se encontró la práctica ", nmat, " en la tabla práctica.");
		signal practicaNoEncontrada
        set message_text = mensaje_error;
    end if;
    
    select nal into numMaxAlumnos from practica p where p.cpra = cpra;
    select count(*) into alumnosMatriculados from notapra n where n.cpra = cpra;
	select ifnull(gra,0) into dificultad from practica p where p.cpra = cpra;
    
    if (numMaxAlumnos = alumnosMatriculados) then 
		if (dificultad < 3) then
			update practica p set gra = dificultad+1 where p.cpra = cpra;
            commit;
		else 
			set mensaje_error = concat("El grado de dificultad de la práctica ",cpra," está al máximo");
			signal error_salida 
            set message_text = mensaje_error;
        end if;
	else 
		signal error_salida 
        set message_text = "El cupo de alumnos no está completo";
    end if;
	
    select concat("Grado de dificultad de la práctica \"", cpra, "\" aumentado a ", dificultad+1) as "Mensaje";
END