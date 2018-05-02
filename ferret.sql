-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 02-05-2018 a las 06:20:22
-- Versión del servidor: 5.7.19
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ferret`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `id_categoria` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` bigint(20) NOT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `dui` varchar(255) DEFAULT NULL,
  `p_apellido` varchar(255) DEFAULT NULL,
  `p_nombre` varchar(255) DEFAULT NULL,
  `s_apellido` varchar(255) DEFAULT NULL,
  `s_nombre` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `id_direccion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `FKkp8f7vr3wdfk6cdv5khmc7a7k` (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

DROP TABLE IF EXISTS `detalle_ventas`;
CREATE TABLE IF NOT EXISTS `detalle_ventas` (
  `id_detalle_venta` bigint(20) NOT NULL,
  `cantidad` double DEFAULT NULL,
  `precio_venta` double DEFAULT NULL,
  `id_producto` bigint(20) DEFAULT NULL,
  `id_venta` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_venta`),
  KEY `FK7n95cag4p1jy8dajap81mg56a` (`id_producto`),
  KEY `FK6457hpcqok31dpejm2gv2x5uu` (`id_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion_clientes`
--

DROP TABLE IF EXISTS `direccion_clientes`;
CREATE TABLE IF NOT EXISTS `direccion_clientes` (
  `id_direccion` bigint(20) NOT NULL,
  `direccion_cliente` varchar(255) DEFAULT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_direccion`),
  KEY `FKibctslfbc7ohx1u0olmi6y5t2` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `existencias` double DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `id_categoria` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FKdtoa37luoxhhvbicrfiu5ygbj` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE IF NOT EXISTS `ventas` (
  `id_venta` bigint(20) NOT NULL,
  `fecha_hora` datetime DEFAULT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `FKleerof1mym3gc1ah8hsarel3f` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `FKkp8f7vr3wdfk6cdv5khmc7a7k` FOREIGN KEY (`id_direccion`) REFERENCES `direccion_clientes` (`id_direccion`);

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `FK6457hpcqok31dpejm2gv2x5uu` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`),
  ADD CONSTRAINT `FK7n95cag4p1jy8dajap81mg56a` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `direccion_clientes`
--
ALTER TABLE `direccion_clientes`
  ADD CONSTRAINT `FKibctslfbc7ohx1u0olmi6y5t2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `FKdtoa37luoxhhvbicrfiu5ygbj` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `FKleerof1mym3gc1ah8hsarel3f` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
