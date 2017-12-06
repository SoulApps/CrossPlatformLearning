-- Ejercicio 1
-- a) Seleccionar el nombre de todos los empleados.
SELECT nombre FROM empleado;

-- b) Seleccionar el cargo y el número de oficina de todos empleados.
SELECT cargo, codoficina FROM empleado;

-- c) Seleccionar la fecha del contrato y el nombre de los empleados que no superaron su cuota de ventas.
SELECT fcontrato, nombre FROM empleado WHERE cuota <= ventas;

-- d) Seleccionar los códigos de las oficinas cuyas ventas superaron los 500000 euros y que además sean del norte.
SELECT oficina FROM oficina WHERE ventas > 500000 AND region = 'norte';

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 2
-- a) Seleccionar el nombre de todos los empleados, haciendo que aparezca como cargo de la columna “Nombre de empleado”.
SELECT nombre 'Nombre de empleado'  FROM empleado;

-- b) Seleccionar el número de oficina, con encabezado “Número de oficina”, la ciudad, con encabezado “Ciudad de destino” y la región,
-- de todas las oficinas cuyo objetivo de venta sea menor de 400000.
SELECT oficina 'Número de oficina', ciudad 'Ciudad de destino', region FROM oficina WHERE objetivo < 400000;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 3
-- a) Seleccionar el nombre de cada empleado y la mitad de su cuota. El encabezado de la mitad de su cuota será “Mitad de la cuota”.
-- Sólo aparecerán los datos de los empleados para los cuales el doble de sus ventas sea mayor que 650000 y menor que 800000.
SELECT nombre, (cuota / 2) 'Mitad de la cuota' FROM empleado WHERE (ventas * 2) BETWEEN 65000 AND 80000;

-- b) Seleccionar el nombre de cada empleado y el número de años que le restan para jubilarse, encabezando estos valores con el cargo
-- “Años restantes de trabajo”. Sólo se incluirán en el resultado de la consulta a aquellos empleados mayores de 40.
SELECT nombre, 67 - (YEAR(NOW()) - YEAR(fnac)) 'Años restantes de trabajo' FROM empleado WHERE (YEAR(NOW()) - YEAR(fnac)) > 40;

-- c) Seleccionar el nombre de la ciudad, el código del director de la misma y la mitad de la diferencia entre ventas y objetivo,
-- de todas las oficinas para las que el 30 % de las ventas sea mayor que el 15 % del objetivo. El formato de la salida será:
-- Ciudad oficina: ciudad – Código director: dir – Mitad diferencia: resultado
SELECT ciudad 'Ciudad oficina', director 'Código director', ((ventas - objetivo) / 2) 'Mitad diferencia' FROM oficina WHERE ventas * .3 > objetivo * .15;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 4
/*a) Seleccionar la primera, tercera y última columna de la tabla empleados. Los registros aparecerán ordenados descendentemente por la tercera
columna de la lista de selección.*/
SELECT numemp, fnac, ventas FROM empleado ORDER BY 3 DESC;

/*b) Seleccionar el nombre y la edad de todos los empleados cuya edad esté comprendida estrictamente entre 45 y 65.
El encabezado de la primera columna será “Empleados mayores”. Los nombres aparecerán ordenados por la edad.*/
SELECT nombre 'Empleados mayores', YEAR(NOW()) - YEAR(fnac) 'Edad' FROM empleado WHERE YEAR(NOW()) - YEAR(fnac) BETWEEN 45 AND 65 ORDER BY 2;

/*c) Seleccionar la región y la ciudad de todas las oficinas que no estén en el norte ni tengan menos de 300000 euros de objetivo de ventas.
El resultado aparecerá ordenado ascendentemente por región, y descendentemente por ciudad.*/
SELECT region, ciudad FROM oficina  WHERE region != 'norte' AND objetivo > 300000 ORDER BY 1, 2 DESC;

/*d) Seleccionar el nombre de empleado y el 25 % de sus ventas. Este último dato
aparecerá con el encabezado “Beneficios de empleado”. No se incluirán en el
resultado de la consulta a aquellos empleados cuyo beneficio no sea superior a
80000. El resultado aparecerá ordenado por beneficios, ascendentemente.*/
SELECT nombre, ventas * .25 'Beneficios de empleado' FROM empleado WHERE ventas > 80000 ORDER BY 2;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 5
/*a) Seleccionar los años en los que se realizó algún pedido (sin repeticiones). Los años aparecerán ordenados cronológicamente, de mayor a menor.*/
SELECT DISTINCT YEAR(fechapedido) FROM pedido ORDER BY 1 DESC;

/*b) Seleccionar el número de pedido y su fecha, de los 7 pedidos más antiguos.*/
SELECT numpedido, fechapedido FROM pedido ORDER BY 2 LIMIT 7;

/*c) Seleccionar el número de pedido y su fecha, de los 5 pedidos más actuales.*/
SELECT numpedido, fechapedido FROM pedido ORDER BY 2 DESC LIMIT 5;

/*d) Seleccionar el número de pedido y su fecha, para los tres primeros pedidos realizados en 1997.*/
SELECT numpedido, fechapedido FROM pedido WHERE YEAR(fechapedido) = 1997 ORDER BY 2 LIMIT 3;

/*e) Seleccionar el número de pedido y el importe de las 3 líneas de pedidos de menor importe.*/
SELECT numpedido, importe FROM lineaspedido ORDER BY 2 LIMIT 3;

/*f) Seleccionar el número de pedido y la fecha de los 10 pedidos más actuales.*/
SELECT numpedido, fechapedido FROM pedido ORDER BY 2 DESC LIMIT 10; 

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 6
/*a) Seleccionar el nombre de las regiones de las oficinas (sin repeticiones) cuyas ventas superen los 600000 euros.*/
SELECT DISTINCT region FROM oficina WHERE ventas > 600000;

/*b) Seleccionar el número de oficina y el nombre de sus ciudades cuyas ventas sean mayores de 600000 o menores de 200000,
que además cumplan que hayan vendido menos del 80 % del objetivo previsto.*/
SELECT oficina, ciudad FROM oficina WHERE ventas NOT BETWEEN 200000 AND 600000 AND ventas < objetivo * .80;

/*c) Seleccionar el nombre de la ciudad y de la región de todas las oficinas. Las filas aparecerán ordenadas por nombre de ciudad,
y sólo se mostrarán aquellas filas cuyo objetivo de ventas sea mayor de 300000.*/
SELECT DISTINCT ciudad, region FROM oficina WHERE objetivo > 300000 ORDER BY 1;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 7
/*a) Seleccionar los nombres de los empleados cuya cuota de venta esté comprendida entre 250000 y 300000,
y cuyas ventas no estén comprendidas entre 50000 y 250000 ni entre 300000 y 500000 (usa BETWEEN siempre que sea posible).*/
SELECT nombre FROM empleado WHERE cuota BETWEEN 250000 AND 300000 AND ventas NOT BETWEEN 50000 AND 250000 AND ventas NOT BETWEEN 300000 AND 500000;

/*b) Seleccionar el nombre y las fechas de los contratos de los empleados cuyos contratos se formalizasen entre 1989 y 2000,
o bien su oficina sea la 21, la 13 o la 22. (usa BETWEEN e IN).*/
SELECT nombre, fcontrato FROM empleado WHERE YEAR(fcontrato) BETWEEN 1989 AND 2000 OR codoficina IN (21, 13, 22);

/*c) Seleccionar el nombre y la edad de los empleados cuyo primer apellido no comience ni por G ni por V.*/
SELECT nombre, YEAR(NOW()) - YEAR(fnac) 'Edad' FROM empleado WHERE nombre NOT LIKE 'G%' AND nombre NOT LIKE 'V%';

/*d) Seleccionar el nombre de los empleados cuyo cargo no sea director de ningún ámbito( 'director ventas', 'director compras'.......).*/
SELECT nombre FROM empleado WHERE cargo NOT LIKE 'Director%';

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 8
/*a) Seleccionar los nombres de los empleados que no tengan jefe o no pertenezcan a ninguna oficina.*/
SELECT nombre FROM empleado WHERE jefe IS NULL OR codoficina IS NULL;

/*b) Selecciona los nombres de empleados que no tengan asignada cuota de venta.*/
SELECT nombre FROM empleado WHERE cuota IS NULL;

/*c) Seleccionar el código y el nombre de la ciudad de todas las oficinas que no tengan ni objetivo de ventas ni ventas.*/
SELECT oficina, ciudad FROM oficina WHERE objetivo IS NULL AND ventas IS NULL;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 9
/*a) Obtener una lista de todos los productos indicando para cada uno su idproducto, descripción, precio y precio con I.V.A. incluido
(es el precio anterior aumentado en un 21%).*/
SELECT idproducto, descripcion, precio 'Precio sin I.V,A.', precio * 1.21 'Precio con I.V.A.' FROM producto;

/*b) Listar de cada empleado su nombre, nº de días que lleva trabajando en la empresa y su año de nacimiento.*/
SELECT nombre, DATEDIFF(NOW(), fcontrato) 'Días trabajados', YEAR(fnac) FROM empleado;

/*c) Obtener la lista de los clientes ordenados por código de representante asignado. Se visualizarán todas las columnas de la tabla.*/
SELECT * FROM cliente ORDER BY 3;

/*d) Obtener las oficinas ordenadas por orden alfabético de región y dentro de cada región por ciudad.
Si hay más de una oficina en la misma ciudad entonces aparecerá primero la que tenga el número de oficina mayor.*/
SELECT * FROM oficina ORDER BY region, ciudad, oficina DESC;

/*e) Obtener los pedidos ordenados por fecha de pedido.*/
SELECT * FROM pedido ORDER BY 2;

/*f) Listar toda la información de los pedidos de marzo.*/
SELECT * FROM pedido WHERE MONTH(fechapedido) = 3;

/*g) Listar los números de los empleados que tienen una oficina asignada.*/
SELECT numemp FROM empleado WHERE codoficina IS NOT NULL;

/*h) Listar los números de las oficinas que no tienen director.*/
SELECT oficina FROM oficina WHERE director IS NULL;

/*i) Listar los datos de las oficinas de las regiones del norte y del este. Deben aparecer primero las del norte y después las del este.*/
SELECT * FROM oficina WHERE region IN ('Norte', 'Este') ORDER BY 3 DESC;

/*j) Listar los empleados de nombre Juan.*/
SELECT * FROM empleado WHERE nombre LIKE '%, %Juan%';

/*k) Listar los productos cuyo idproducto acabe en x.*/
SELECT * FROM producto WHERE idproducto LIKE '%x';

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 10
/*a) Todos los campos de las tablas producto y pedido.*/
SELECT * FROM producto, pedido;

/*b) Todos los campos de las tablas empleado y oficina.*/
SELECT * FROM empleado, oficina;

/*c) Los campos nombre, edad, oficina y cargo de la tabla empleados, y los campos oficina, ciudad y región de la tabla oficina.
No se incluirán en el resultado filas cuyo campo cargo sea “representante”.*/
SELECT nombre, YEAR(NOW()) - YEAR(fnac) Edad, codoficina, cargo, oficina, ciudad, region FROM empleado, oficina WHERE cargo != 'representante';

/*d) En este apartado efectuaremos el producto cartesiano de la tabla producto consigo misma.
Se incluirán todos los campos de la primera relación, pero sólo la descripción del producto de la segunda.*/
SELECT p.*, r.descripcion FROM producto p, producto r;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 11
/*a) Selecciona todos los campos de la tabla clientes junto a los datos de los pedidos que han realizado.*/
SELECT * FROM cliente, pedido WHERE numclie = cliente;

/*b) Selecciona todos los campos de la tabla clientes junto a los datos de los pedidos que han realizado, incluyéndose únicamente la fecha
de cada pedido y el número del pedido. Sólo se incluirán en el resultado a los clientes cuyo límite de crédito sea mayor que 40000.*/
SELECT c.*, fechapedido, numpedido FROM cliente c, pedido WHERE cliente = numclie AND limcredito > 40000;

/*c) Seleccionar el nombre de cliente, su límite de crédito, así como el nombre de su
representante y la región a la que pertenece la oficina de éste.*/
SELECT c.nombre, limcredito, e.nombre, region FROM cliente c, empleado e, oficina WHERE repclie = numemp AND codoficina = oficina;

/*d) Seleccionar el nombre de empleado (con el cargo “Nombre de empleado”), la
fecha de su contrato, el código de su oficina, el nombre de la ciudad de la
oficina, así como el nombre del jefe del empleado (con el cargo “Nombre del
jefe”).*/
SELECT e.nombre 'Nombre de empleado', e.fcontrato, e.codoficina, ciudad, j.nombre 'Nombre del jefe' FROM empleado e, oficina, empleado j
WHERE e.codoficina = oficina AND e.jefe = j.numemp;

/*e) Seleccionar el número de cada pedido, su fecha y su importe, así como la ciudad
en la que se encuentra la oficina del representante que tiene asignado. No se
incluirán en el resultado los datos de pedidos cuyo importe sea inferior a 40000
ni superior a 60000.*/
SELECT p.numpedido, fechapedido, SUM(importe) Impor, ciudad FROM pedido p, lineaspedido l, cliente, empleado, oficina
WHERE p.numpedido = l.numpedido AND cliente = numclie AND repclie = numemp AND codoficina = oficina
GROUP BY numpedido HAVING Impor NOT BETWEEN 40000 AND 60000;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 12
/*a) Se pretende obtener una relación en la que aparezcan los datos de todas las oficinas junto a los nombres
y las edades de los directores de cada una de ellas (si una oficina no tiene director entonces los datos de este aparecerán en blanco).*/
SELECT o.*, nombre, YEAR(NOW()) - YEAR(fnac) Edad FROM oficina o LEFT JOIN empleado ON numemp = director;

/*b) Obtener una relación que contenga los nombres y cargos de los empleados así como los códigos y la ciudad de las oficinas
de los mismos que pertenezcan a la región 'este'. Aparecerán también los empleados que no estén asignados a ninguna oficina.*/
SELECT nombre, cargo, coficina, ciudad FROM empleado LEFT JOIN oficina ON codoficina = oficina WHERE region = 'este';

/*c) Una relación en la que aparezcan los empleados con los nombres de sus jefes, aparecerán también los empleados que no tienen jefe.*/
SELECT e.nombre, j.nombre FROM empleado e LEFT JOIN empleado j ON j.numemp = e.jefe;
SELECT e.nombre, j.nombre FROM empleado j RIGHT JOIN empleado e ON j.numemp = e.jefe;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 13
/*a) Listar las oficinas del este indicando para cada una de ellas su número, ciudad, números y nombres de sus empleados.
Hacer una versión en la que aparecen sólo las que tienen empleados y otra en las que aparezcan también las oficinas del este que no tienen empleados.*/
SELECT oficina, ciudad, numemp, nombre FROM oficina LEFT JOIN empleado ON codoficina = oficina AND region = 'este';
SELECT oficina, ciudad, numemp, nombre FROM oficina, empleado WHERE codoficina = oficina AND region = 'este';

/*b) Listar los pedidos mostrando su número, nombre del cliente y el límite de crédito del cliente correspondiente.*/
SELECT numpedido, nombre, limcredito FROM pedido, cliente WHERE cliente = numclie;

/*c) Listar los datos de cada uno de los empleados, la ciudad y región en donde trabaja.*/
SELECT e.*, ciudad, region FROM empleado e, oficina WHERE codoficina = oficina;

/*d) Listar las oficinas con objetivo superior a 600.000 indicando para cada una de ellas el nombre de su director.*/
SELECT oficina, nombre FROM oficina LEFT JOIN empleado ON numemp = director WHERE objetivo > 600000 AND oficina = oficina;

/*e) Hallar los empleados que realizaron su primer pedido el mismo día en que fueron contratados.*/
SELECT * FROM empleado WHERE fcontrato = (SELECT MIN(fechapedido) FROM pedido, cliente WHERE repclie = numemp AND cliente = numclie);

/*f) Listar los empleados con una cuota superior a la de su jefe; para cada empleado sacar sus datos y el número, nombre y cuota de su jefe.*/
SELECT e.*, j.numemp, j.nombre, j.cuota FROM empleado e, empleado j WHERE e.jefe = j.numemp AND e.cuota > j.cuota;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 14
/*a) Se pretende calcular la media de las edades de los empleados mayores de 50 años. 
Este resultado aparecerá con la cabecera de columna “Media de mayores”.*/
SELECT AVG(YEAR(NOW()) - YEAR(fnac)) 'Media de mayores' FROM empleado WHERE YEAR(NOW()) - YEAR(fnac) > 50;

/*b) Halla la suma de las cuotas de los empleados que trabajan en las oficinas de Valencia o de Castellón.*/
SELECT SUM(cuota) FROM empleado, oficina WHERE codoficina = oficina AND ciudad IN('Valencia', 'Castellón');
SELECT SUM(cuota) FROM empleado WHERE codoficina IN (SELECT oficina FROM oficina WHERE ciudad IN('Valencia', 'Castellón'));

/*c) Halla la suma de los importes del pedido 12345.*/
SELECT SUM(importe) FROM lineaspedido WHERE numpedido = 12345;

/*d) Queremos visualizar el número de filas obtenido al realizar el producto cartesiano de la tabla pedidos y la tabla clientes.*/
SELECT COUNT(*) FROM pedido, cliente;

/*e) Visualizar la mayor edad de entre los empleados contratados antes de 1988.*/
SELECT MAX(YEAR(NOW()) - YEAR(fnac)) FROM empleado WHERE YEAR(fcontrato) < 1988;

/*f) Visualizar la mayor edad de los empleados cuya oficina esté en la zona este o en la ciudad de A Coruña.*/
SELECT MAX(YEAR(NOW()) - YEAR(fnac)) FROM empleado, oficina WHERE codoficina = oficina AND (region = 'este' OR ciudad ='A Coruña');

/*g) Visualizar la fecha del último pedido que hizo el cliente 1234.*/
SELECT MAX(fechapedido) FROM pedido WHERE cliente = 1234;

/*h) Visualizar la media de los importes asociados al producto bisagra.*/
SELECT AVG(importe) FROM producto p, lineaspedido l WHERE p.idproducto = l.idproducto AND descripcion = 'bisagra';

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 15
/*a) La edad media de los trabajadores que tienen el mismo cargo. Se incluirá el cargo en la salida.*/
SELECT AVG(YEAR(NOW()) - YEAR(fnac)), cargo FROM empleado GROUP BY cargo;

/*b) La fecha del contrato más antiguo de los empleados de cada oficina. Se incluirá el número de cada oficina.*/
SELECT MIN(fcontrato), codoficina FROM empleado GROUP BY 2;

/*c) De entre los empleados que tienen el mismo jefe se obtendrá la cuota máxima. Se incluirá el código del jefe.*/
SELECT MAX(cuota), jefe FROM empleado WHERE cuota IS NOT NULL GROUP BY 2;

/*d) El número de empleados que tiene a su cargo cada empleado que es jefe. Se incluirá el código del jefe.
Implementa otra versión que además incluya el nombre del jefe.*/
SELECT COUNT(*), jefe FROM empleado WHERE jefe IS NOT NULL GROUP BY 2;
SELECT COUNT(*), e.jefe, j.nombre FROM empleado e, empleado j WHERE e.jefe IS NOT NULL AND e.jefe = j.numemp GROUP BY 2, 3;

/*e) Para cada región, la máxima venta de sus trabajadores.*/
SELECT MAX(e.ventas) FROM oficina, empleado e WHERE codoficina = oficina GROUP BY region;

/*f) Para cada grupo de empleados que tengan la misma cuota se calculará la fecha de contrato más antigua y más moderna.
El resultado debe incluir la cuota. No se tendrán en cuenta para calcular el resultado a los empleados cuya edad sea menor de 35.*/
SELECT MIN(fcontrato), MAX(fcontrato), cuota FROM empleado WHERE YEAR(NOW()) - YEAR(fnac) >= 35 GROUP BY cuota;

/*g) Para cada producto el importe total vendido.*/
SELECT idproducto, SUM(importe) FROM lineaspedido GROUP BY idproducto;
SELECT descripcion, l.idproducto, SUM(importe) FROM lineaspedido l, producto p WHERE l.idproducto = p.idproducto GROUP BY 1, 2;

/*h) El importe total de cada producto vendido a partir de 1995. Se incluirá en la salida el código del producto.*/
SELECT idproducto, SUM(importe) FROM lineaspedido l, pedido p WHERE l.numpedido = p.numpedido AND YEAR(fechapedido) > 1995 GROUP BY 1;

/*i) La cantidad total de cada producto vendido a partir de 1995. Se incluirá en la salida el código del producto.*/
SELECT idproducto, SUM(cant) FROM lineaspedido l, pedido p WHERE l.numpedido = p.numpedido AND YEAR(fechapedido) > 1995 GROUP BY 1;

/*j) El número de pedidos en los que se ha visto involucrado cada producto. Sólo se tendrán en cuenta los productos cuyo precio sea
mayor que 200 y menor que 2000.*/
SELECT p.idproducto, COUNT(numpedido) FROM lineaspedido l, producto p
WHERE l.idproducto = p.idproducto AND precio BETWEEN 200 AND 2000 GROUP BY 1;

/*k) El importe medio que se ha vendido a cada cliente que tenga un límite de crédito inferior a 50000. En la salida se incluirá el código del cliente.*/
SELECT cliente, AVG(importe) FROM pedido p, lineaspedido l WHERE cliente IN(SELECT numclie FROM cliente WHERE limcredito < 50000)
AND p.numpedido = l.numpedido GROUP BY 1;

/*l) El importe máximo que se ha vendido a cada cliente. Sólo se tendrán en cuenta los clientes que tengan asignado un representante mayor de 40 años.
En la salida se incluirá el código del cliente.*/
SELECT cliente, MAX(importe) FROM pedido p, lineaspedido l WHERE cliente IN(SELECT numclie FROM cliente, empleado WHERE repclie = numemp AND
YEAR(NOW()) - YEAR(fnac) > 40) AND p.numpedido = l.numpedido GROUP BY 1;

/*m) Para cada producto, la mayor edad de los empleados que lo vendieron. Se incluirá en el resultado el código del producto.*/
SELECT idproducto, MAX(YEAR(NOW()) - YEAR(fnac)) FROM empleado, cliente, pedido p, lineaspedido l
WHERE numemp = repclie AND p.numpedido = l.numpedido GROUP BY 1;

/*n) Para cada producto, el mayor objetivo de las oficinas de los empleados que lo vendieron. Se incluirá en el resultado el código del producto.*/
SELECT idproducto, MAX(objetivo) FROM empleado, oficina, cliente, pedido p, lineaspedido l
WHERE oficina = codoficina AND numemp = repclie AND numclie = cliente AND p.numpedido = l.numpedido GROUP BY 1;

/*o) Seleccionar el número de pedido e importe de los tres pedidos de menor importe.*/
SELECT numpedido, SUM(importe) FROM lineaspedido GROUP BY 1 ORDER BY 2 DESC LIMIT 3;

/*p) Seleccionar el número de pedido e importe de los 10 pedidos más actuales.*/
SELECT l.numpedido, SUM(importe) FROM lineaspedido l, pedido p WHERE p.numpedido = l.numpedido GROUP BY 1 ORDER BY fechapedido LIMIT 10;

/*q) Lista código de cliente, número de pedido, fecha del pedido e importe total de aquellos clientes cuyo límite de crédito sea mayor de 40000.*/
SELECT numclie, p.numpedido, fechapedido, SUM(importe) FROM cliente, pedido p, lineaspedido l
WHERE numclie = cliente AND limcredito > 40000 AND p.numpedido = l.numpedido GROUP BY 1, 2;

/*r) Listar los pedidos mostrando su número, importe, nombre de cliente y el límite de crédito del cliente.*/
SELECT p.numpedido, nombre, limcredito, SUM(importe) FROM pedido p, lineaspedido l, cliente WHERE p.numpedido = l.numpedido AND numclie= cliente
GROUP BY 1, 2, 3;

/*s) Listar los pedidos superiores a 25000 de importe incluyendo el nombre del empleado que tomó el pedido y el nombre del cliente que lo solicitó.*/
SELECT p.numpedido, e.nombre, c.nombre FROM pedido p, lineaspedido l, empleado e, cliente c WHERE l.numpedido = p.numpedido AND cliente = numclie
AND repclie = numemp GROUP BY 1, 2, 3 HAVING SUM(importe) > 25000;

/*t) Listar los códigos de los empleados que tienen algún pedido con importe superior a 10000 o que tengan una cuota inferior a 10000.*/
SELECT DISTINCT numemp FROM empleado, cliente, pedido p, lineaspedido l WHERE numemp = repclie AND numclie = cliente AND p.numpedido = l.numpedido
AND cuota < 10000 GROUP BY p.numpedido HAVING SUM(importe) > 10000; -- UNION

/*u) Halla la suma de los importes de las líneas de los pedidos en los que se haya solicitado el producto con descripción 'Manivela'.*/
SELECT SUM(importe) FROM lineaspedido l, producto p WHERE l.idproducto = p.idproducto AND descripcion = 'Manivela';
-- Proyectar los numpedido y sus importes de aquellos pedidos en los que se solicitó Manivela
SELECT l.numpedido, SUM(importe) FROM lineaspedido l, producto pro WHERE l.idproducto = pro.idproducto AND descripcion = 'Manivela' GROUP BY 1;

/*v) La suma de las ventas de los empleados de cada oficina. Se incluirá en el resultado el código de cada oficina.
No se incluirán en el resultado las oficinas cuyas ventas totales sean menores de 200000. Hacerlo con HAVING y sin HAVING.*/
SELECT codoficina, SUM(e.ventas) SumaVentas FROM empleado e, oficina o WHERE codoficina = oficina AND SumaVentas >= 200000 GROUP BY 1; -- No puedo agrupar antes de sumar, por lo que no se puede hacer sin HAVING.
SELECT codoficina, SUM(e.ventas) SumaVentas FROM empleado e, oficina o WHERE codoficina = oficina GROUP BY 1 HAVING SumaVentas >= 200000;

/*w) La suma de las unidades vendidas de cada producto vendido al cliente 1234.
No se incluirán en el resultado final aquellas filas cuya suma de unidades al cuadrado sea menor de 1000.*/
SELECT idproducto, SUM(cant) Suma FROM pedido p, lineaspedido l WHERE p.numpedido = l.numpedido AND cliente = 1234
GROUP BY 1 HAVING Suma * Suma >= 1000;

/*x) Por cada empleado, sacar la media del limite de crédito de sus clientes, el código del empleado y su nombre.
No se tendrán en cuenta los clientes cuyo límite de crédito sea inferior a 30000.
Deben salir aquellos empleados cuyo nombre empiecen por M o A. Por último ordena el resultado por el promedio.*/
SELECT AVG(limcredito), numemp, e.nombre FROM empleado e, cliente WHERE numemp = repclie AND (e.nombre LIKE '%, M%' OR e.nombre LIKE '%, A%')
AND limcredito >= 30000 GROUP BY 2, 3 ORDER BY 1;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 16
/*a) ¿Cuáles son la cuota media y las ventas medias de todos los empleados?*/
SELECT AVG(cuota), AVG(ventas) FROM empleado; 

/*b) Halla el importe medio de pedidos, el importe total de pedidos y el precio medio
de venta (el precio de venta es el precio unitario en cada pedido).*/
SELECT numpedido, AVG(importe), SUM(importe), AVG(precio) FROM lineaspedido l, producto p WHERE l.idproducto = p.idproducto GROUP BY 1;

/*c) Halla el precio medio de los productos.*/
SELECT AVG(precio) FROM producto;

/*d) ¿Cuál es el importe total de los pedidos realizados por el empleado Vicente Pantalla?*/
SELECT SUM(importe) FROM lineaspedido l, pedido p, cliente WHERE l.numpedido = p.numpedido AND cliente = numclie AND nombre = 'Vicente Pantalla'
GROUP BY l.numpedido;

/*e) Halla en qué fecha se realizó el primer pedido.*/
SELECT MIN(fechapedido) FROM pedido;

/*f) Halla cuántos pedidos hay de más de 25000. (Tener en cuenta las consideraciones sobre el anidamiento de funciones del apartado GROUP BY).*/
SELECT COUNT(COUNT(*)) FROM lineaspedido GROUP BY numpedido HAVING SUM(importe) > 25000; -- En oracle funcionaría.
SELECT COUNT(*) FROM pedido WHERE numpedido IN(SELECT numpedido FROM lineaspedido GROUP BY 1 HAVING SUM(importe) > 25000);

/*g) Lista cuántos empleados están asignados a cada oficina, indicar el número de oficina y cuántos tiene asignados.*/
SELECT codoficina, COUNT(*) FROM empleado GROUP BY codoficina;

/*h) Para cada empleado, obtener su número, nombre, e importe vendido por ese empleado a cada cliente indicando el número de cliente.*/
SELECT numemp, e.nombre, numclie, SUM(importe) FROM empleado e, cliente, pedido p, lineaspedido l
WHERE numemp = repclie AND numclie = cliente AND p.numpedido = l.numpedido GROUP BY 1, 2, 3;

/*i) Para cada empleado cuyos total de importe de los pedidos de sus clientes sumen más de 30000 euros, hallar su importe medio de pedidos.
En el resultado aparecerá el número de empleado y su importe medio de pedidos.*/
SELECT numemp, AVG(importe) FROM empleado, cliente, pedido p, lineaspedido l
WHERE numemp = repclie AND numclie = cliente AND p.numpedido = l.numpedido GROUP BY 1 HAVING SUM(importe) > 30000;

/*j) Obtén para cada producto, su descripción, precio y cantidad total pedida, incluyendo sólo los productos cuya cantidad total pedida
sea superior al 75% del stock; y ordenado por cantidad total pedida.*/
SELECT descripcion, precio, SUM(cant) Cantidad FROM lineaspedido l, producto p WHERE l.idproducto = p.idproducto GROUP BY p.idproducto, 1, 2, existencias
HAVING SUM(cant) > existencias * .75 ORDER BY 3; -- Hay que agrupar también por existencias porque lo necesito en el HAVING.
SELECT descripcion, precio, SUM(cant) Cantidad FROM lineaspedido l, producto p WHERE l.idproducto = p.idproducto GROUP BY p.idproducto
HAVING SUM(cant) > (SELECT existencias * .75 FROM producto pro WHERE pro.idproducto = p.idproducto) * .75 ORDER BY 3;

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 17
/*a) Las ciudades de las oficinas, los nombres de los empleados y sus fechas de contrato, de todos los empleados
cuyas ventas sean menores que la media de ventas de todas las oficinas.*/
SELECT ciudad, nombre, fcontrato FROM oficina, empleado e WHERE codoficina = oficina AND e.ventas > (SELECT AVG(ventas) FROM oficina);

/*b) Selecciona el nombre de aquellos empleados cuyas oficinas estén en el norte o en el oeste. Hacerlo de dos formas distintas.*/
SELECT nombre FROM empleado WHERE codoficina IN (SELECT oficina FROM oficina WHERE region IN ('norte', 'oeste'));
SELECT nombre FROM empleado, oficina WHERE codoficina = oficina AND region IN ('norte', 'oeste');

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 18
/*a) Los nombres de los empleados, que sean representantes, cuyas ventas sean menores que el total de ventas de
todas las oficinas de las regiones este y centro juntas.*/
SELECT DISTINCT nombre FROM empleado WHERE cargo = 'representante' AND ventas < (SELECT SUM(ventas) FROM oficina WHERE region IN ('este', 'centro'));

/*b) Selecciona el código y el nombre del cliente cuyo empleado representante trabaje en una oficina del oeste.*/
SELECT numclie, nombre FROM cliente WHERE repclie IN (SELECT numemp FROM empleado, oficina WHERE codoficina = oficina AND region = 'oeste');

/*c) Selecciona todos los datos de aquellos clientes cuyos representantes tienen una cuota mayor que sus ventas. Hacerlo de dos formas distintas.*/
SELECT * FROM cliente, empleado WHERE repclie = numemp AND cuota > ventas;
SELECT * FROM cliente WHERE repclie IN (SELECT numemp FROM empleado WHERE cuota > ventas);

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 19
/*a) Los nombres de los clientes y su límite de crédito, para todos los clientes que tengan un representante que pertenezca a
una oficina que tenga objetivo y venta mayores que 10000.*/
SELECT nombre, limcredito FROM cliente WHERE repclie IN (SELECT numemp FROM empleado WHERE codoficina IN
(SELECT oficina FROM oficina WHERE objetivo > 10000 AND ventas > 10000));

/*b) Saca empleados que estén en las oficinas del Oeste.*/
SELECT * FROM empleado WHERE codoficina IN (SELECT oficina FROM oficina WHERE region = 'oeste');

/*c) Saca empleados que no están en las oficinas del Oeste.*/
SELECT * FROM empleado WHERE codoficina NOT IN (SELECT oficina FROM oficina WHERE region = 'oeste');

/*d) Saca la descripción de productos para los que se hayan hecho líneas de pedidos donde la cantidad sea mayor que 9.*/
SELECT descripcion FROM producto WHERE idproducto IN (SELECT idproducto FROM lineaspedido WHERE cant > 9);

/*e) Saca empleadoscuyo jefe sea director en oficinas del Oeste.*/
SELECT numemp FROM empleado WHERE jefe IN (SELECT director FROM oficina WHERE region = 'oeste');

-------------------------------------------------------------------------------------------------------------------------------------------
-- Ejercicio 20
/*a) Listar los nombres de los clientes que tienen asignado el representante Jaumes
López, Alvaro .*/
SELECT nombre FROM cliente WHERE repclie IN (SELECT numemp FROM empleado WHERE nombre LIKE '%, Jaumes %');

/*b) Listar los vendedores (numemp, nombre, y nº de oficina) que trabajan en oficinas que tienen ventas superiores a su objetivo.*/
SELECT numemp, nombre, codoficina FROM empleado WHERE codoficina IN (SELECT oficina FROM oficina WHERE ventas > objetivo);

/*c) Listar los vendedores que no trabajan en oficinas dirigidas por el empleado 108.*/
SELECT * FROM empleado WHERE codoficina IN (SELECT oficina FROM oficina WHERE director = 108);

/*d) Listar los productos ( idproducto y descripción) para los cuales no se haya hecho ningún pedido de 250 euros o más.
Hacer una segunda versión donde aparezcan también los productos que nunca hayan sido pedidos.*/
SELECT idproducto, descripcion FROM producto WHERE idproducto IN (SELECT idproducto FROM lineaspedido GROUP BY numpedido HAVING SUM(importe) >= 250);

SELECT idproducto, descripcion FROM producto WHERE idproducto IN (SELECT idproducto FROM lineaspedido GROUP BY numpedido HAVING SUM(importe) >= 250)
UNION SELECT idproducto, descripcion FROM producto WHERE idproducto NOT IN(SELECT idproducto FROM lineaspedido);

/*e) Listar los números de clientes asignados a Viguer Sánchez, Antonio que al menos hayan hecho un pedido superior a 30000.*/
SELECT numclie FROM cliente WHERE repclie IN
(SELECT numemp FROM empleado WHERE nombre = 'Viguer Sánchez, Antonio' AND numemp IN
(SELECT repclie FROM cliente WHERE numclie IN
(SELECT cliente FROM pedido WHERE numpedido IN
(SELECT numpedido FROM lineaspedido GROUP BY 1 HAVING SUM(importe) > 30000))));


/*f) Listar todos los datos de losclientes del representante del ejercicio anterior que nunca hayan hecho un pedido.*/
SELECT numclie FROM cliente WHERE repclie IN
(SELECT numemp FROM empleado WHERE nombre = 'Viguer Sánchez, Antonio' AND numemp IN
(SELECT repclie FROM cliente WHERE numclie IN
(SELECT cliente FROM pedido WHERE numpedido NOT IN
(SELECT numpedido FROM lineaspedido GROUP BY 1 HAVING SUM(importe) > 30000))));

/*g) Listar las oficinas que tengan un objetivo menor que la suma de las cuotas de los empleados de las oficinas del Oeste.*/
SELECT oficina FROM oficina WHERE objetivo < (SELECT SUM(cuota) FROM empleado WHERE codoficina IN
(SELECT oficina FROM oficina WHERE region = 'oeste') GROUP BY codoficina);

