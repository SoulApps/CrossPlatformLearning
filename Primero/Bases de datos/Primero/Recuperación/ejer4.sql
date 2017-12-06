CREATE DEFINER=`root`@`localhost` PROCEDURE `ejer4`(IN nombre VARCHAR(15))
BEGIN
    SELECT COUNT(*) FROM casas c, viviendas v, zonas z WHERE c.calle=v.calle AND c.num=v.num AND nombre=nom_z AND v.cod_z=z.cod_z;
END