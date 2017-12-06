-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: iessaladillo
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aula` (
  `planta` tinyint(1) NOT NULL,
  `codAula` smallint(3) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`planta`,`codAula`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (0,-1,'Biblioteca'),(0,-2,'SUM');
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hardware`
--

DROP TABLE IF EXISTS `hardware`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hardware` (
  `codBarras` varchar(30) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `unidadesTotales` smallint(5) unsigned NOT NULL,
  `unidadesEnUso` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`codBarras`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hardware`
--

LOCK TABLES `hardware` WRITE;
/*!40000 ALTER TABLE `hardware` DISABLE KEYS */;
/*!40000 ALTER TABLE `hardware` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidencia`
--

DROP TABLE IF EXISTS `incidencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidencia` (
  `codIncidencia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codProf` int(11) NOT NULL,
  `codMaterial` int(10) NOT NULL,
  `fecha` datetime NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `historial` varchar(500) DEFAULT NULL,
  `estado` enum('SOLUCIONADO','REVISADO','NUEVO') NOT NULL DEFAULT 'NUEVO',
  PRIMARY KEY (`codIncidencia`,`codProf`,`codMaterial`),
  KEY `FK_incidencia_profesor_idx` (`codProf`),
  KEY `FK_incidencia_material_idx` (`codMaterial`),
  CONSTRAINT `FK_incidencia_material` FOREIGN KEY (`codMaterial`) REFERENCES `material` (`codMaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_incidencia_profesor` FOREIGN KEY (`codProf`) REFERENCES `profesor` (`codProf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidencia`
--

LOCK TABLES `incidencia` WRITE;
/*!40000 ALTER TABLE `incidencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `codMaterial` int(10) NOT NULL,
  `codBarras` varchar(30) NOT NULL,
  `planta` tinyint(1) NOT NULL,
  `codAula` smallint(3) NOT NULL,
  PRIMARY KEY (`codMaterial`,`codBarras`,`planta`,`codAula`),
  KEY `FK_reparto_aula_idx` (`planta`,`codAula`),
  KEY `FK_reparto_material_idx` (`codBarras`),
  CONSTRAINT `FK_material_aula` FOREIGN KEY (`planta`, `codAula`) REFERENCES `aula` (`planta`, `codAula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_material_hardware` FOREIGN KEY (`codBarras`) REFERENCES `hardware` (`codBarras`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `codProf` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `tipo` enum('NORMAL','TIC','DIRECCION') NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) DEFAULT NULL,
  `token` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`codProf`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `fecha` date NOT NULL,
  `planta` tinyint(1) NOT NULL,
  `codAula` smallint(3) NOT NULL,
  `codTramo` tinyint(1) unsigned NOT NULL,
  `codProf` int(11) NOT NULL,
  KEY `FK_reserva_profesor_idx` (`codProf`),
  KEY `FK_reserva_aula_idx` (`planta`,`codAula`),
  KEY `FK_reserva_tramohorario_idx` (`codTramo`),
  CONSTRAINT `FK_reserva_aula` FOREIGN KEY (`planta`, `codAula`) REFERENCES `aula` (`planta`, `codAula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_reserva_profesor` FOREIGN KEY (`codProf`) REFERENCES `profesor` (`codProf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_reserva_tramohorario` FOREIGN KEY (`codTramo`) REFERENCES `tramohorario` (`codTramo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tramohorario`
--

DROP TABLE IF EXISTS `tramohorario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tramohorario` (
  `codTramo` tinyint(1) unsigned NOT NULL,
  `horaInicio` time NOT NULL,
  `horaFin` time NOT NULL,
  PRIMARY KEY (`codTramo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tramohorario`
--

LOCK TABLES `tramohorario` WRITE;
/*!40000 ALTER TABLE `tramohorario` DISABLE KEYS */;
INSERT INTO `tramohorario` VALUES (1,'08:15:00','09:15:00'),(2,'09:15:00','10:15:00'),(3,'10:15:00','11:15:00'),(4,'11:45:00','12:45:00'),(5,'12:45:00','13:45:00'),(6,'13:45:00','14:45:00');
/*!40000 ALTER TABLE `tramohorario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-07  9:13:24
