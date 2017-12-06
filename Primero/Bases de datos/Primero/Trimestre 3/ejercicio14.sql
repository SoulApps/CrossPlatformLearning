CREATE DEFINER=`root`@`localhost` PROCEDURE `ejercicio14_b1`(x varchar(255))
BEGIN
	declare y varchar(255);
    declare listado_vacio condition for sqlstate "45001";
	declare tabla_vacia condition for sqlstate "45000";
    declare exit handler for listado_vacio
		begin
			resignal
			set message_text = "El listado esta vacio";
		end;
    declare exit handler for tabla_vacia
		begin
			select "Tabla vacia" Error;
		end;
	declare exit handler for 1146
		begin
			select "Tabla no existe" Error;
		end;
	declare exit handler for sqlexception, sqlwarning
		begin
			select "Error desconocido" Error;
		end;
	select count(*) into y from empleado;
	if y=0 then
		signal tabla_vacia;
	else
		select count(*) into y from empleado where nombre like concat("%",x,"%");
		if y!=0 then
			select numemp, nombre from empleado where nombre like concat("%",x,"%");
            select y as "Total de empleado";
		else
			signal listado_vacio;
		end if;
	end if;
END