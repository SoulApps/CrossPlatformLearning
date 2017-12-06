-- 1
-- PRUEBA INDIVIDUAL
CREATE TABLE `esqui`.`prueba_individual` (
  `cod_prueba` INT(3) NOT NULL COMMENT '',
  `max_part` INT(3) NOT NULL COMMENT '',
  PRIMARY KEY (`cod_prueba`)  COMMENT '',
  CONSTRAINT `FK_prind_prueba`
    FOREIGN KEY (`cod_prueba`)
    REFERENCES `esqui`.`prueba` (`cod_prueba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- PRUEBA EQUIPO
CREATE TABLE `esqui`.`prueba_equipo` (
  `cod_prueba` INT(3) NOT NULL COMMENT '',
  `max_equ` INT(3) NOT NULL COMMENT '',
  PRIMARY KEY (`cod_prueba`)  COMMENT '',
  CONSTRAINT `FK_prequ_prueba`
    FOREIGN KEY (`cod_prueba`)
    REFERENCES `esqui`.`prueba` (`cod_prueba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- PART PRUEBA INDI
CREATE TABLE `esqui`.`part_prueba_indi` (
  `dni` VARCHAR(9) NOT NULL COMMENT '',
  `cod_prueba` INT(3) NOT NULL COMMENT '',
  `tiempo` TIME NOT NULL COMMENT '',
  `posicion` INT(3) NOT NULL COMMENT '',
  PRIMARY KEY (`dni`)  COMMENT '',
  INDEX `FK_ppi_pruebaind_idx` (`cod_prueba` ASC)  COMMENT '',
  CONSTRAINT `FK_ppi_esq`
    FOREIGN KEY (`dni`)
    REFERENCES `esqui`.`esquiador` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ppi_pruebaind`
    FOREIGN KEY (`cod_prueba`)
    REFERENCES `esqui`.`prueba_individual` (`cod_prueba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- PART PRUEBA EQU
CREATE TABLE `esqui`.`part_prueba_equ` (
  `cod_equ` INT(5) NOT NULL COMMENT '',
  `cod_prueba` INT(3) NOT NULL COMMENT '',
  `tiempo` TIME NOT NULL COMMENT '',
  `posicion` INT(3) NOT NULL COMMENT '',
  PRIMARY KEY (`cod_equ`)  COMMENT '',
  INDEX `FK_ppe_pruebaequ_idx` (`cod_prueba` ASC)  COMMENT '',
  CONSTRAINT `FK_ppe_equ`
    FOREIGN KEY (`cod_equ`)
    REFERENCES `esqui`.`equipo` (`COD_EQU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ppe_pruebaequ`
    FOREIGN KEY (`cod_prueba`)
    REFERENCES `esqui`.`prueba_equipo` (`cod_prueba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- PISTA COMPUESTA
CREATE TABLE `pista_compuesta` (
  `cod_est_comp` int(5) NOT NULL,
  `n_pista_comp` int(2) NOT NULL,
  `cod_est` int(5) NOT NULL,
  `n_pista` int(2) NOT NULL,
  PRIMARY KEY (`cod_est_comp`,`n_pista_comp`),
  KEY `FK_dfd_idx` (`n_pista_comp`),
  KEY `FK_pc_pista_idx` (`n_pista`),
  KEY `d_idx` (`cod_est`,`n_pista`),
  CONSTRAINT `FK_pc_estacion` FOREIGN KEY (`cod_est`) REFERENCES `estacion` (`COD_EST`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_pc_pista` FOREIGN KEY (`cod_est`, `n_pista`) REFERENCES `pista` (`COD_EST`, `N_PISTA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- PRUEBA
CREATE TABLE `prueba` (
  `cod_prueba` int(3) NOT NULL,
  `nom_prueba` varchar(30) NOT NULL,
  `fec_prueba` date NOT NULL,
  `modalidad` int(1) NOT NULL,
  `cod_est` int(5) NOT NULL,
  `n_pista` int(2) NOT NULL,
  `cod_tipo` int(2) NOT NULL,
  PRIMARY KEY (`cod_prueba`),
  UNIQUE KEY `nom_prueba_UNIQUE` (`nom_prueba`),
  KEY `FK_prueba_tipoprueba_idx` (`cod_tipo`),
  KEY `FK_prueba_estacion_idx` (`cod_est`),
  KEY `FK_prueba_pista_idx` (`n_pista`),
  KEY `FK_prueba_pista_idx1` (`n_pista`,`cod_est`),
  KEY `FK_prueba_pista` (`cod_est`,`n_pista`),
  CONSTRAINT `FK_prueba_estacion` FOREIGN KEY (`cod_est`) REFERENCES `estacion` (`COD_EST`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_prueba_pista` FOREIGN KEY (`cod_est`, `n_pista`) REFERENCES `pista` (`COD_EST`, `N_PISTA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_prueba_tipoprueba` FOREIGN KEY (`cod_tipo`) REFERENCES `tipoprueba` (`COD_TIPO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 2
SELECT * FROM prueba WHERE cod_prueba IN(SELECT cod_prueba FROM prueba_individual WHERE
cod_prueba IN(SELECT cod_prueba FROM part_prueba_indi WHERE dni IN(SELECT dni FROM esquiador WHERE cod_fed =
(SELECT cod_fed FROM federacion WHERE com_fed = 'Andalucía'))))
OR cod_prueba IN(SELECT cod_prueba FROM prueba_equipo WHERE cod_prueba IN(SELECT cod_prueba FROM part_prueba_equ WHERE cod_equ IN
(SELECT cod_equ FROM esquiador WHERE cod_fed IN(SELECT cod_fed FROM federacion WHERE com_fed = 'Andalucía'))));

-- 3
SELECT cod_est FROM estacion WHERE cod_est IN(SELECT cod_est FROM prueba);

-- 4
SELECT COUNT(*) FROM prueba_individual WHERE max_part > 10;

-- 5
SELECT cod_est FROM pista GROUP BY 1 HAVING COUNT(n_pista) <= ALL(SELECT COUNT(n_pista) FROM pista GROUP BY cod_est);

-- 6
SELECT * FROM federacion WHERE cod_fed IN(SELECT cod_fed FROM esquiador GROUP BY 1 HAVING AVG(YEAR(NOW()) - YEAR(f_nac)) >=
ALL(SELECT AVG(YEAR(NOW()) - YEAR(f_nac)) FROM esquiador GROUP BY cod_fed));

-- 7
SELECT dni FROM esquiador WHERE dni IN(SELECT dni FROM part_prueba_indi WHERE cod_prueba IN(SELECT cod_prueba FROM prueba WHERE modalidad IN(1, 2)));

-- 8
SELECT p.cod_est, p.n_pista, COUNT(pc.n_pista_comp) 'Número de pistas' FROM pista p LEFT JOIN pista_compuesta pc ON pc.cod_est = p.cod_est GROUP BY 1;

-- 9
SELECT DISTINCT cod_equ, f.* FROM esquiador, federacion f WHERE cod_equ IS NOT NULL;

-- 10
SELECT dni FROM part_prueba_indi WHERE cod_prueba = ALL(SELECT cod_prueba FROM prueba_individual);

-- 11
SELECT cod_prueba, COUNT(*) 'Número de participantes' FROM part_prueba_indi
UNION
SELECT cod_prueba, COUNT(*) 'Número de participantes' FROM part_prueba_equ;

-- 12
SELECT dni FROM esquiador ORDER BY f_nac DESC LIMIT 10;

-- 13
SELECT dific, COUNT(*) 'Número de pistas' FROM pista GROUP BY dific ORDER BY dific;

-- 14
SELECT f.cod_fed, COUNT(dni) 'Número de federados' FROM federacion f LEFT JOIN esquiador e ON f.cod_fed = e.cod_fed GROUP BY 1; 

-- 15
SELECT * FROM esquiador WHERE dni IN(SELECT dni FROM part_prueba_equ) AND dni NOT IN(SELECT dni FROM part_prueba_indi);

-- 16
SELECT dni FROM esquiador WHERE dni IN(SELECT cod_entr FROM equipo GROUP BY 1 HAVING COUNT(cod_entr) > 2);

-- 17
SELECT den, COUNT(p.cod_tipo) FROM tipoprueba t, prueba p WHERE t.cod_tipo = p.cod_tipo GROUP BY t.cod_tipo ORDER BY 1, 2;

-- 18
SELECT * FROM equipo WHERE cod_equ IN(SELECT cod_equ FROM part_prueba_equ WHERE posicion = 1);

-- 19
SELECT ent.*, equ.* FROM esquiador ent, equipo equ WHERE dni = cod_entr;

-- 20
SELECT n_pista FROM pista WHERE (n_pista, cod_est) NOT IN(SELECT n_pista_comp, cod_est_comp FROM pista_compuesta) AND cod_est =
(SELECT cod_est FROM estacion WHERE nom_est ='Formigal');

-- 21
INSERT INTO pista(cod_est, n_pista, kms, dific) SELECT cod_est, n_pista, kms, dific FROM pista WHERE
cod_est = (SELECT cod_est FROM estacion WHERE nom_est ='Kandanchú')
AND n_pista IN(SELECT n_pista FROM pista WHERE n_pista = 1 AND cod_est = (SELECT cod_est FROM estacion WHERE nom_est = 'Formigal'))
AND kms IN(SELECT kms FROM pista WHERE n_pista = 1 AND cod_est = (SELECT cod_est FROM estacion WHERE nom_est = 'Formigal'))
AND dific IN(SELECT dific FROM pista WHERE n_pista = 1 AND cod_est = (SELECT cod_est FROM estacion WHERE nom_est = 'Formigal'));

# El correcto es este.
INSERT INTO pista(cod_est) SELECT (SELECT cod_est FROM estacion WHERE nom_est = 'Formigal'), n_pista FROM estacion WHERE nom_est = 'Formigal';


-- 22
UPDATE pista SET kms = kms * 1.10 WHERE n_pista NOT IN(SELECT n_pista FROM pista_compuesta)
AND cod_fed = (SELECT cod_fed FROM federacion WHERE com_fed = 'Huesca');
UPDATE pista SET dific = 'N' WHERE n_pista NOT IN(SELECT n_pista FROM pista_compuesta)
AND cod_fed = (SELECT cod_fed FROM federacion WHERE com_fed = 'Huesca');
