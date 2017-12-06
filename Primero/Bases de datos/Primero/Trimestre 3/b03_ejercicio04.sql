Delimiter $$
	drop trigger if exists before_notapra_insert $$
	create trigger before_notapra_insert before insert on notapra
	for each row
		begin 
        /* 4.- Disparador BEFORE que impida matricularse a un alumno en una nueva práctica 
        si no tiene aprobadas todas las prácticas en las que está matriculado. Explica por 
        qué crees que obligo a hacerlo con este momento de disparo. */
			declare numTotalMat int default 0;
            declare numMatAprob int default 0;
            declare algun_suspenso condition for sqlstate "45000";
            
            select count(*) into numTotalMat from notapra where nmat = new.nmat;
            select count(*) into numMatAprob from notapra where nmat = new.nmat and nota >= 5;
            
            if (numTotalMat != numMatAprob) then 
				signal algun_suspenso
                set message_text = "Imposible matricular al alumno, ya que tiene alguna práctica suspensa.";
            end if;
		end $$
Delimiter ;