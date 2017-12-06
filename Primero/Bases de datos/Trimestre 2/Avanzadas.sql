/*1.- Mostrar los datos de las líneas de pedidos cuya cantidad pedida sea igual a alguna cantidad vendida del producto 'AC345'.*/
SELECT * FROM lineaspedido WHERE cant = ANY(SELECT cant FROM lineaspedido WHERE idproducto = '773c');

/*2.- Mostrar los datos de los clientes que no han realizado ningún pedido.*/
SELECT * FROM cliente WHERE numclie != ALL(SELECT cliente FROM pedido);
SELECT * FROM cliente WHERE NOT EXISTS(SELECT cliente FROM pedido WHERE numclie = cliente);
-- SELECT numclie FROM cliente MINUS SELECT cliente FROM pedido;

/*3.- Mostrar los datos de las oficinas que no tienen ningún empleado.*/
SELECT * FROM oficina WHERE oficina != ALL(SELECT numemp FROM empleado);

/*4.- Visualizar los códigos de los productos que hayan sido vendidos por pedido en una cantidad
inferior a todas las cantidades vendidas por pedido del producto 'AC345'.*/
SELECT DISTINCT idproducto FROM lineaspedido WHERE cant < ALL(SELECT l.cant FROM lineaspedido l WHERE l.idproducto = '773c') AND idproducto = '773c';

/*5.- Visualizar los datos de los empleados cuya fecha de contrato sea anterior a alguna
fecha de contrato de los empleados de la oficina 103 y que no pertenezcan a ella.*/
SELECT * FROM empleado WHERE fcontrato < ANY(SELECT fcontrato FROM empleado WHERE codoficina = 1) AND codoficina != 1;
-- SELECT * FROM empleado WHERE fcontrato < ANY(SELECT fcontrato FROM empleado WHERE codoficina = 1)
-- MINUS SELECT * FROM empleado WHERE codoficina != 1;

/*6.- Visualizar los datos de los empleados que tengan la misma cuota y la misma venta que el empleado 134.*/
SELECT * FROM empleado WHERE (cuota, ventas) = (SELECT cuota, ventas FROM empleado WHERE numemp = 1);

/*7.- Visualizar los números de empleados que sean representantes de algún cliente además de directores de alguna oficina.*/
SELECT numemp FROM empleado WHERE EXISTS(SELECT repclie, director FROM cliente, oficina WHERE numemp = repclie AND numemp = director);
SELECT numemp FROM empleado WHERE numemp IN(SELECT repclie FROM cliente WHERE repclie = ANY(SELECT director FROM oficina));

/*8.- Visualizar los números de los empleados que no son representantes de ningún cliente.*/
SELECT numemp FROM empleado WHERE NOT EXISTS(SELECT repclie FROM cliente WHERE repclie = numemp);
SELECT numemp FROM empleado WHERE numemp != ALL(SELECT repclie FROM cliente);

/*9.- Mostrar los números de los empleados que no son directores de ninguna oficina.*/
SELECT numemp FROM empleado WHERE NOT EXISTS(SELECT director FROM oficina WHERE numemp = director);
SELECT numemp FROM empleado WHERE numemp != ALL(SELECT director FROM oficina WHERE director IS NOT NULL);
SELECT numemp FROM empleado WHERE numemp NOT IN(SELECT director FROM oficina WHERE director IS NOT NULL);
SELECT numemp FROM empleado WHERE numemp NOT IN(1, 3, 105);

/*10.- Mostrar los códigos de los productos que no hayan sido pedidos hasta el momento.*/
SELECT idproducto FROM producto p WHERE NOT EXISTS(SELECT idproducto FROM lineaspedido WHERE p.idproducto = idproducto);
SELECT idproducto FROM producto WHERE idproducto != ALL(SELECT idproducto FROM lineaspedido);

/*11.- Listar los códigos de los empleados que tienen algún pedido con importe superior a 10000 o que tengan una cuota inferior a 10000.*/
SELECT numemp FROM empleado e WHERE EXISTS(SELECT repclie FROM cliente WHERE e.numemp = repclie AND numclie = 
ANY(SELECT cliente FROM pedido WHERE cuota < 10000 OR numpedido IN(SELECT numpedido FROM lineaspedido GROUP BY 1 HAVING SUM(importe) > 10000)));

/*12.- Visualizar los números de pedidos y sus importes de aquellos pedidos en los uno
de los productos vendidos en ellos tengan como descripción “Manivela”.*/
SELECT numpedido, SUM(importe) FROM lineaspedido l WHERE EXISTS(SELECT numpedido FROM lineaspedido li, producto p
WHERE li.idproducto = p.idproducto AND descripcion = 'manivela' AND l.numpedido = li.numpedido) GROUP BY 1;

SELECT numpedido, SUM(importe) FROM lineaspedido l WHERE numpedido IN
(SELECT numpedido FROM lineaspedido WHERE idproducto =
(SELECT idproducto FROM producto WHERE descripcion = 'manivela')) GROUP BY 1;

/*13.- Listar los números de clientes asignados a Viguer Sánchez, Antonio que al menos hayan hecho un pedido superior a 30000
y aquellos clientes del representante que nunca hicieron un pedido.*/
SELECT numclie FROM cliente WHERE repclie = (SELECT numemp FROM empleado WHERE nombre = 'Sánchez Galvín, Alejandro') AND
(numclie IN (SELECT cliente FROM pedido WHERE numpedido IN(SELECT numpedido FROM lineaspedido GROUP BY numpedido HAVING SUM(importe) > 30000))) OR numclie NOT IN(SELECT cliente FROM pedido);

SELECT numclie FROM cliente WHERE repclie = (SELECT numemp FROM empleado WHERE nombre = 'Sánchez Galvín, Alejandro') AND
(numclie IN (SELECT cliente FROM pedido WHERE numpedido IN(SELECT numpedido FROM lineaspedido GROUP BY numpedido HAVING SUM(importe) > 30000)))
UNION
SELECT numclie FROM cliente WHERE numclie NOT IN(SELECT cliente FROM pedido) AND repclie = (SELECT numemp FROM empleado WHERE nombre = 'Sánchez Galvín, Alejandro');

/*14.- Listar los números de clientes que hayan solicitado todos los productos que ofrece la empresa.
Lógicamente, la solicitud de los mismos se habrá hecho en los diferentes pedidos del cliente, no todos en un único pedido.*/
SELECT numclie FROM cliente WHERE numclie IN(SELECT cliente FROM pedido WHERE numpedido IN(SELECT numpedido FROM lineaspedido WHERE idproducto =
ANY(SELECT idproducto FROM producto)));
--
