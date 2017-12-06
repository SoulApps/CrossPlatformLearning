-- EJERCICIO 1
/*1. Los datos de un empleado cuyo código será el 111, su nombre es Amadeo Benítez López, su cargo es representante, su fecha de nacimiento
'12/09/1965', su jefe será el empleado 104 y su contrato tiene la fecha de hoy. Aún no se ha asignado a ninguna oficina ni se han establecido cuota ni
ventas.*/
INSERT INTO empleado VALUES(111, 'Benítez López, Amadeo', "1965-09-12", 1, 'representante', NULL, 104, NULL, NULL);

/*2. Los datos de una nueva oficina en la ciudad de Málaga, región sur. El director será el empleado 105. Su código será 29. Aún no se conocen más
datos de la misma.*/
INSERT INTO oficina(oficina, director, ciudad, region) VALUES(29, 105, 'Málaga', 'Sur');

/*3. Los datos de un nuevo producto, añadiendo, en este mismo orden, el precio será 200, la descripción manivela, su código 123 y sus existencias 20.*/
INSERT INTO producto(precio, descripcion, idproducto, existencias) VALUES(200, 'manivela', 123, 20);


/*4. Inserta en las tablas de pedidos y líneas de pedido, un pedido número 11223, fecha actual, realizado por el cliente 2106.
El producto pedido es el de código 773c. Se piden 10 unidades del mismo, con un importe de 9750.*/
INSERT INTO pedido VALUES(11223, 2106);
INSERT INTO lineaspedido VALUES(11223, 1, '773c', 10, 9750);

-- EJERCICIO 2
/*a) Los datos de un empleado cuyo código será el 111, su nombre es Benítez López, Amadeo su cargo es representante, su fecha de nacimiento '12/09/1965',
su jefe será el empleado López Gómez, José y su contrato tiene la fecha de hoy. Aún no se ha asignado a ninguna oficina ni se han establecido
cuota ni ventas.*/
INSERT INTO empleado(numemp, nombre, codoficina, fnac, jefe, cargo) SELECT 111, 'Benítez López, Amadeo', 1, '1965-09-12', numemp, 'representante'
FROM empleado WHERE nombre = 'López Gómez, José';

/*b) Crea una nueva tabla llamada InformeVentas en la BD Ventas. Dicha tabla estará compuesta por un campo de tipo texto llamado Empleado,
otro de tipo numérico llamado CodOficina, y dos campos de tipo entero llamados VentasEmpleados y VentasOficinas.
No es necesario definir ninguna clave principal para esta tabla.*/
CREATE TABLE `informeventas`(`empleado` VARCHAR(30)	NOT NULL DEFAULT 'Nombre', `codoficina` INT(10) NULL, `ventasempleado` INT(10) NULL, `ventasoficina` INT(10) NULL);

/*c) Inserta en la nueva tabla todos los empleados existentes en la tabla empleado con sus códigos de oficinas correspondientes y con sus
VentasOficina y Ventasempleado con un valor de 50000 euros cada una de ellas.*/
INSERT INTO informeventas(empleado, codoficina, ventasempleado, ventasoficina) SELECT nombre, codoficina, 50000, 50000 FROM empleado;

/*d) Insertar en la tabla InformeVentas los empleados de la oficina 50, sus datos serán
el nuevo código de oficina 80 y sus ventas de empleado correspondientes.*/
INSERT INTO informeventas(empleado, codoficina, ventasempleado) SELECT nombre, 80, ventas FROM empleado WHERE codoficina = 50;

/*e) Inserta en la tabla anterior los nombres de los empleados, los códigos de sus oficinas y las ventas del mismo y de su oficina,
para aquellos empleados que hayan superado su cuota de ventas y tengan jefe.*/
INSERT INTO informeventas(empleado, codoficina, ventasempleado, ventasoficina) SELECT nombre, codoficina, e.ventas, o.ventas FROM empleado e, oficina o
WHERE codoficina = oficina AND e.ventas > e.cuota AND jefe IS NOT NULL;

/*f) Añade a la tabla anterior los nombres de los empleados que sean representantes de algún cliente y las ventas de sus oficinas.*/
INSERT INTO informeventas(empleado, ventasoficina)
SELECT DISTINCT e.nombre, o.ventas FROM empleado e, cliente, oficina o
WHERE numemp = repclie AND codoficina = oficina;

/*g) Añade a la tabla anterior los nombres de los empleados, los códigos de sus oficinas y
las ventas de su oficina, para aquellos empleados cuyos
clientes hayan pedido alguna vez un reostato o una red.*/
INSERT INTO informeventas(empleado, codoficina, ventasoficina) SELECT DISTINCT e.nombre, codoficina, o.ventas
FROM empleado e, oficina o, cliente, pedido p, lineaspedido l, producto pro
WHERE codoficina = oficina AND numemp = repclie AND numclie = cliente AND p.numpedido = l.numpedido
AND l.idproducto = pro.idproducto AND descripcion IN ('reostato', 'red');

/*h) Crea una nueva tabla llamada ResumenEmpleados en la BD Ventas. Dicha tabla estará compuesta por un campo de tipo texto llamado Empleado
y otro de tipo numérico llamado CodOficina.*/
-- OK

/*i) Inserta en esta tabla los nombres de empleados y códigos de oficina de la tabla InformeVentas, de todos los empleados cuyas ventas supongan
más de la mitad de las ventas de su oficina y su contrato sea anterior a 1989.*/
INSERT INTO resumenempleados(empleado, codoficina)
SELECT DISTINCT empleado, i.codoficina FROM informeventas i, empleado e
WHERE ventasempleado > ventasoficina / 2 AND nombre = empleado AND i.codoficina = e.codoficina AND YEAR(fcontrato) < '1989-01-01';

INSERT INTO resumenempleados(empleado, codoficina)
SELECT DISTINCT empleado, i.codoficina FROM informeventas i, empleado e, oficina o
WHERE e.ventas > o.ventas / 2 AND nombre = empleado AND i.codoficina = e.codoficina AND YEAR(fcontrato) < '1989-01-01';

/*j) Añade a esta tabla los nombres de todos los representantes cuyos clientes hayan realizado algún pedido con un importe mayor de 5000.*/
INSERT INTO resumenempleados(empleado) SELECT e.nombre FROM empleado e, cliente, pedido p, lineaspedido l
WHERE numemp = repclie AND cliente = numclie AND p.numpedido = l.numpedido AND SUM(importe) > 5000;

-- EJERCICIO 3
/*a) Añadir una nueva tabla, llamada ejercicio31, a la BD Ventas. Esta nueva tabla contendrá los códigos de todos los productos existentes,
sus precios y sus existencias, así como el número total de unidades vendidas. A este último campo se llamará cantidadvendida con valor 0
por defecto si el producto no se ha vendido nunca.*/


/*b) Cambia todos los valores del campo cantidadvendida de la tabla anterior que sean menores que 10 por el valor 0.*/
UPDATE ejercicio31 SET cantidadvendida = 0 WHERE cantidadvendida < 10;

/*c) Incrementa el nivel de existencias de todos los productos cuyo código comience por 41 en 25 unidades.*/
UPDATE ejercicio31 SET existencias = existencias + 25 WHERE idproducto LIKE '41%';

/*d) Rebaja el precio a la mitad de los artículos cuyo código comienza por 2. No se tocará el precio de un artículo si ya es menor de 100 €.*/
UPDATE ejercicio31 SET precio = precio / 2 WHERE idproducto LIKE '2%' AND precio >= 100;

/*e) Incrementa en un 15% el precio de todos los productos de la tabla ejercicio31 para los que la cantidad vendida suponga al menos el 20%
de las existencias actuales.*/
UPDATE ejercicio31 SET precio = precio * 1.15 WHERE cantidadvendida >= existencias * .2;

/*f) Rebaja en un 5% el precio de todos los productos que cuesten menos de 1000 € y cuyo nivel de existencias sea mayor del doble de la media
de las existencias de todos los productos.*/
UPDATE ejercicio31 SET precio = precio / 1.05 WHERE precio < 1000 AND existencias > (SELECT AVG(existencias)) * 2;

/*g) Resta 10 al campo cantidadvendida de todos los productos que tengan un valor en este campo mayor que 10 y para los cuales se hayan realizado 
al menos dos ventas.*/
UPDATE ejercicio31 SET cantidadvendida = cantidadvendida - 10 WHERE cantidadvendida > 10 AND idproducto IN(SELECT idproducto FROM lineaspedido GROUP BY 1 HAVING COUNT(*) > 2);
UPDATE ejercicio31 e SET cantidadvendida = cantidadvendida - 10 WHERE cantidadvendida > 10 AND (SELECT COUNT(*) FROM lineaspedido l WHERE l.idproducto = e.idproducto) > 2;

-- EJERCICIO 4
/*a) Elimina todos los registros de la tabla ejercicio31 para los que la cantidad vendida sea menor de 8.*/
DELETE FROM ejercicio31 WHERE cantidadvendida < 8;

/*b) Elimina todos los productos de la tabla ejercicio31 que alguna vez fueron pedidos por clientes con un representante de la zona oeste.*/
DELETE FROM ejercicio31 WHERE idproducto IN (SELECT idproducto FROM lineaspedido l, pedido p, cliente, empleado, oficina 
WHERE p.numpedido = l.numpedido AND cliente = numclie AND repclie = numemp AND codoficina = oficina AND region = 'Oeste');

/*c) Elimina los productos de la tabla ejercicio31 que nunca fueron vendidos.*/
DELETE FROM ejercicio31 WHERE idproducto NOT IN (SELECT idproducto FROM lineaspedido);

/*d) Elimina todos los productos de la tabla ejercicio31 que sean rodamientos, reostatos o redes.*/
DELETE FROM ejercicio31 WHERE idproducto IN (SELECT idproducto FROM producto WHERE descripcion
IN('rodamiento', 'reostato', 'red'));

/*e) Elimina todos los registros que queden en la tabla ejercicio31.*/
DELETE FROM ejercicio31;
TRUNCATE ejercicio31;

/*f) Elimina la tabla ejercicio31.*/
DROP TABLE ejercicio31;

-- EJERCICIO 5
/*a) Añade los datos de un alumno llamado Rafael Gutiérrez Moreno con DNI 33456540. El DNI de su padre será 41443332. Analiza el resultado obtenido al
intentar realizar esta inserción.*/
INSERT INTO alumno VALUES (33456540, 'Rafael', 'Gutiérrez Moreno', 41443332);

/*b) Intenta eliminar el registro que contiene los datos del padre llamado Antonio Merino Jiménez. Analiza el resultado obtenido.*/
DELETE FROM padre WHERE nombpadre = 'Antonio' AND apellpadre = 'Merino Jiménez';

/*c) Intenta cambiar el valor del campo DNI del padre Juan Romero Reyes por 77665544. Analiza el resultado obtenido.*/
UPDATE padre SET dni = 77665544 WHERE nombpadre = 'Juan' AND apellpadre = 'Romero Reyes';
