CREATE DEFINER=`root`@`localhost` PROCEDURE `ejercicio13_b1`()
BEGIN
	declare x int;
	declare tabla_vacia condition for sqlstate "45000";
    declare exit handler for tabla_vacia
		begin
			select "Tabla vacia" Error;
		end;
	/* declare exit handler for not found
		begin
			select "Tabla vacia";  SUSTITUYE LA CONDICION!!
		end; */
	declare exit handler for 1146
		begin
			select "Tabla no existe" Error;
		end;
	declare exit handler for sqlexception, sqlwarning
		begin
			select "Error desconocido" Error;
		end;
	
	select count(*) into x from empleado; /* COUNT(*) NO SE PONDRIA CON EL NOT FOUND SINO CON COLUMNA DE LA TABLA  */
    if x=0 then
		signal tabla_vacia; /* EL IF TAMPOCO SE PONDRIA */
	end if;
	select substring_index(nombre,',',1), ventas from empleado order by 2 desc limit 5;   
END