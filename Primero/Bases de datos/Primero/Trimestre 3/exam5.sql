 /*5.- Select que obtenga los códigos de matrícula de los 
 alumnos matriculados en todas las prácticas que hayan de su curso.*/
 select nmat from notaprac group by 1 having count(*) = 
 (select count(*) from practicas where cur = 
 (select cur from matriculas where mat=nmat));