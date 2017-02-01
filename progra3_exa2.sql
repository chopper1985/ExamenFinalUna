-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-02-2017 a las 16:20:11
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `progra3_exa2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author`
--

CREATE TABLE IF NOT EXISTS `author` (
  `idAuthor` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idAuthor`),
  KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `author`
--

INSERT INTO `author` (`idAuthor`, `name`) VALUES
(2, 'Calo'),
(7, 'juadsfdsfn2'),
(6, 'juan2'),
(3, 'lindo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorcontact`
--

CREATE TABLE IF NOT EXISTS `authorcontact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAuthor` int(11) NOT NULL,
  `contact` text COLLATE utf8_spanish_ci NOT NULL,
  `type` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_author` (`idAuthor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `authorcontact`
--

INSERT INTO `authorcontact` (`id`, `idAuthor`, `contact`, `type`) VALUES
(8, 2, '1313443242', 'Cel'),
(9, 2, '1313443242', 'Cel2'),
(10, 2, '1313443242', 'Cel23'),
(11, 6, '1313443242', 'Cel23'),
(12, 7, '1313443242', 'Cel23dfdsf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `idBook` int(11) NOT NULL AUTO_INCREMENT,
  `idAuthor` int(11) NOT NULL,
  `idType` int(11) NOT NULL,
  `name` text COLLATE utf8_spanish_ci NOT NULL,
  `dateRelease` date NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`idBook`),
  KEY `idAuthor` (`idAuthor`,`idType`),
  KEY `idType` (`idType`),
  KEY `idAuthor_2` (`idAuthor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `book`
--

INSERT INTO `book` (`idBook`, `idAuthor`, `idType`, `name`, `dateRelease`, `price`) VALUES
(6, 3, 5, 'harry photer', '2016-10-03', 5000),
(7, 2, 4, 'las cronicas', '2013-11-01', 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `booktype`
--

CREATE TABLE IF NOT EXISTS `booktype` (
  `idType` int(11) NOT NULL AUTO_INCREMENT,
  `type` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `booktype`
--

INSERT INTO `booktype` (`idType`, `type`) VALUES
(4, 'fision'),
(5, 'comedia'),
(6, 'accion'),
(7, 'AVENTURA');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `authorcontact`
--
ALTER TABLE `authorcontact`
  ADD CONSTRAINT `authorcontact_ibfk_2` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`idAuthor`);

--
-- Filtros para la tabla `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_3` FOREIGN KEY (`idAuthor`) REFERENCES `author` (`idAuthor`),
  ADD CONSTRAINT `book_ibfk_4` FOREIGN KEY (`idType`) REFERENCES `booktype` (`idType`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
