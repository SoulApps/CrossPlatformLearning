/*1.- Órdenes de creación de las tablas.*/
-- Click derecho en la tabla > copy to clipboard > create statement.

/*2.- Códigos de los proveedores que suministran al proyecto 'AUTOVIA DEL SUR'.*/
SELECT DISTINCT cprov FROM suministro WHERE cproy =(SELECT cproy FROM proyecto WHERE tit = 'AUTOVIA DEL SUR');
-- SELECT cprov FROM suministro WHERE cproy =(SELECT cproy FROM proyecto WHERE tit = 'AUTOVIA DEL SUR') GROUP BY 1;

/*3.- Códigos de los proveedores que no suministran al proyecto 'AUTOVIA DEL SUR'.*/
SELECT cprov FROM proveedor p WHERE NOT EXISTS (SELECT cprov FROM suministro WHERE p.cprov= cprov AND cproy =
(SELECT cproy FROM proyecto WHERE tit = 'AUTOVIA DEL SUR'));

/*4.- Piezas suministradas por los proveedores de  la ciudad 123 en orden ascendente de sus nombres.*/
SELECT nomp FROM pieza WHERE cp IN(SELECT cp FROM suministro WHERE cprov IN(SELECT cprov FROM proveedor WHERE cci = 123)) ORDER BY 1;

/*5.- Códigos de proyectos suministrados únicamente por el proveedor  'PR01'.*/
SELECT DISTINCT cproy FROM suministro WHERE cprov = 'PR01' AND cproy NOT IN(SELECT cproy FROM suministro WHERE cprov != 'PR01');

/*6.- Para cada proyecto su nombre y la cantidad media de piezas que recibe por envío.*/
SELECT tit, AVG(cant) FROM suministro s, proyecto p WHERE s.cproy = p.cproy GROUP BY 1;

/*7.- Cantidad total de piezas enviadas a cada proyecto.*/
SELECT cproy, SUM(cant) FROM suministro GROUP BY 1;

/*8.- Número de envíos hechos por cada proveedor*/
SELECT cprov, COUNT(*) FROM suministro GROUP BY 1;
SELECT p.cprov, COUNT(cproy) FROM proveedor p LEFT JOIN suministro s ON p.cprov = s.cprov GROUP BY 1; -- Para que salga 0 tengo que contar por algo que no vaya a contarse por estar en nulo.

/*9.- Suministros del proveedor 'FERRALLA S.A' cuyas cantidades sean superiores a la media de las cantidades de todos los suministros.*/
SELECT s.* FROM suministro s, proveedor p WHERE s.cprov = p.cprov AND cant > (SELECT AVG(cant) FROM suministro) AND nprov = 'FERRALLA S.A';

/*10.- Proyecto con mayor número de piezas distintas suministradas.*/
SELECT cproy FROM suministro GROUP BY 1 HAVING COUNT(DISTINCT cp) =
(SELECT COUNT(DISTINCT cp) FROM suministro GROUP BY cproy ORDER BY 1 DESC LIMIT 1);

/*11.- Ciudades en las que se localice algún proyecto y donde además resida algún proveedor. Hacerlo de dos formas distintas.*/
SELECT DISTINCT proy.cci FROM proyecto proy, proveedor prov WHERE proy.cci = prov.cci;
SELECT DISTINCT cci FROM proyecto WHERE cci = ANY(SELECT cci FROM proveedor);

/*12.- Proyectos suministrados por todos los proveedores con  estatus mayor que 20.*/
SELECT DISTINCT cproy FROM suministro WHERE cprov IN(SELECT cprov FROM proveedor WHERE st > 20);

/*13.- Proveedores con una cantidad mayor que alguna del proveedor 'PR05'.*/
SELECT cprov FROM suministro WHERE cprov != 'PR05' GROUP BY 1 HAVING MAX(cant) > ANY(SELECT cant FROM suministro WHERE cprov = 'PR05');
SELECT DISTINCT cprov FROM suministro WHERE cprov != 'PR05' AND cant > (SELECT MIN(cant) FROM suministro WHERE cprov = 'PR05');

/*14.- Proveedores con una cantidad mayor que cualquiera de 'PR06'.*/
SELECT cprov FROM suministro GROUP BY 1 HAVING MAX(cant) > ALL(SELECT cant FROM suministro WHERE cprov = 'PR06');
SELECT DISTINCT cprov FROM suministro WHERE cant > (SELECT MAX(cant) FROM suministro WHERE cprov = 'PR06');

/*15.- Piezas con un peso menor que todas las piezas de color rojo.*/
SELECT cp FROM pieza WHERE pe < ALL(SELECT pe FROM pieza WHERE col = 'rojo');

/*16.- Borrar todos los datos relativos del proyecto 'PY03'.*/
DELETE FROM suministro WHERE cproy = 'PY03';
DELETE FROM proyecto WHERE cproy = 'PY03'; -- ON DELETE CASCADE si quisiese del tirón.

/*17-  Incrementar en un 20% todas las cantidades suministradas al proyecto más reciente.*/
UPDATE suministro s, proyecto p SET cant = cant * 1.2 WHERE s.cproy = p.cproy AND fproy = (SELECT MAX(fproy) FROM proyecto);
UPDATE suministro s, proyecto p SET cant = cant * 1.2 WHERE s.cproy = p.cproy AND fproy >= ALL(SELECT fproy FROM proyecto);

/*18.- Borrar todos los suministros del proveedor ‘PR01’ realizados  al proyecto ‘PY03’.*/
DELETE FROM suministro WHERE cprov = 'PR01' AND cproy = 'PY03';

/*19.- El proveedor ‘PR01’ va a suministrar 50 unidades de todas las piezas de color ‘ROJO’ al proyecto ‘PY01’.
Realizar la orden de inserción en suministros.*/
INSERT INTO suministro (cprov, cp, cproy, cant) SELECT 'PR01', cp, 'PY01', 50 FROM pieza WHERE col = 'rojo';
INSERT INTO suministro (cprov, cp, cproy, cant) SELECT DISTINCT 'PR01', cp, 'PY01', 50 FROM pieza WHERE col = 'rojo';

/*20.- Aumentar el peso en 10 unidades a aquellas piezas que son suministradas por el proveedor ‘PR05’ y que son de color ‘ROJO’.*/
UPDATE pieza SET pe = pe + 10 WHERE cp IN(SELECT cp FROM suministro WHERE cprov = 'PR05') AND col = 'rojo';
