CREATE DEFINER=`root`@`localhost` PROCEDURE `ejer5`(in calle varchar(20),in num int(2))
BEGIN
	SELECT nom_p from habitapisos h, pisos p WHERE h.calle=p.calle and h.num=c.num;
END