-- phpMyAdmin SQL Dump
-- version 4.0.10.14
-- http://www.phpmyadmin.net
--
-- Servidor: sql.byethost27.org:3306
-- Tiempo de generación: 18-01-2017 a las 14:55:03
-- Versión del servidor: 5.6.32-78.0
-- Versión de PHP: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `angelpdi_bidi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE IF NOT EXISTS `provincia` (
  `idProvincia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `provincia` varchar(50) NOT NULL,
  `provinciaseo` varchar(50) NOT NULL,
  `provincia3` char(3) DEFAULT NULL,
  PRIMARY KEY (`idProvincia`),
  UNIQUE KEY `provinciaseo` (`provinciaseo`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=53 ;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`idProvincia`, `provincia`, `provinciaseo`, `provincia3`) VALUES
(1, 'Álava', 'alava', 'ALV'),
(2, 'Castellón', 'castellon', 'CAS'),
(3, 'León', 'leon', 'LEO'),
(4, 'Salamanca', 'salamanca', 'SAL'),
(5, 'Albacete', 'albacete', 'ABC'),
(6, 'Ceuta', 'ceuta', 'CEU'),
(7, 'Lleida', 'lleida', 'LLE'),
(8, 'Segovia', 'segovia', 'SGV'),
(9, 'Alicante', 'alicante', 'ALA'),
(10, 'Ciudad Real', 'ciudad-real', 'CRE'),
(11, 'Lugo', 'lugo', 'LUG'),
(12, 'Sevilla', 'sevilla', 'SVL'),
(13, 'Almería', 'almeria', 'ALM'),
(14, 'Córdoba', 'cordoba', 'CBA'),
(15, 'Madrid', 'madrid', 'MAD'),
(16, 'Soria', 'soria', 'SOR'),
(17, 'Asturias', 'asturias', 'AST'),
(18, 'A Coruña', 'coruna', 'LCO'),
(19, 'Málaga', 'malaga', 'MAL'),
(20, 'Tarragona', 'tarragona', 'TRN'),
(21, 'Ávila', 'avila', 'AVL'),
(22, 'Cuenca', 'cuenca', 'CNC'),
(23, 'Melilla', 'melilla', 'MEL'),
(24, 'S.C. Tenerife', 'tenerife', 'SCT'),
(25, 'Badajoz', 'badajoz', 'BDJ'),
(26, 'Girona', 'girona', 'GIR'),
(27, 'Murcia', 'murcia', 'MUR'),
(28, 'Teruel', 'teruel', 'TER'),
(29, 'Baleares', 'baleares', 'BAL'),
(30, 'Granada', 'granada', 'GND'),
(31, 'Navarra', 'navarra', 'NVR'),
(32, 'Toledo', 'toledo', 'TOL'),
(33, 'Barcelona', 'barcelona', 'BCN'),
(34, 'Guadalajara', 'guadalajara', 'GLJ'),
(35, 'Ourense', 'ourense', 'OUR'),
(36, 'Valencia', 'valencia', 'VAL'),
(37, 'Burgos', 'burgos', 'BRG'),
(38, 'Guipúzcoa', 'guipuzcoa', 'GPZ'),
(39, 'Palencia', 'palencia', 'PAL'),
(40, 'Valladolid', 'valladolid', 'VLL'),
(41, 'Cáceres', 'caceres', 'CAC'),
(42, 'Huelva', 'huelva', 'HLV'),
(43, 'Las Palmas', 'palmas', 'LPA'),
(44, 'Vizcaya', 'vizcaya', 'VZC'),
(45, 'Cádiz', 'cadiz', 'CDZ'),
(46, 'Huesca', 'huesca', 'HSC'),
(47, 'Pontevedra', 'pontevedra', 'PNV'),
(48, 'Zamora', 'zamora', 'ZAM'),
(49, 'Cantabria', 'cantabria', 'CTB'),
(50, 'Jaén', 'jaen', 'JAE'),
(51, 'La Rioja', 'rioja', 'LRJ'),
(52, 'Zaragoza', 'zaragoza', 'ZAR');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
