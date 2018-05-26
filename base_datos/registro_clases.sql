-- phpMyAdmin SQL Dump
-- version 4.7.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-05-2018 a las 09:11:21
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `registro_clases`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id` int(11) NOT NULL,
  `numero_control` int(8) NOT NULL,
  `nombre` text NOT NULL,
  `apellidos` text NOT NULL,
  `correo` text NOT NULL,
  `telefono` text NOT NULL,
  `id_direccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno_clase`
--

CREATE TABLE `alumno_clase` (
  `id` int(11) NOT NULL,
  `id_clase` int(11) NOT NULL,
  `id_alumno` int(11) NOT NULL,
  `fecha_inscripcion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clase`
--

CREATE TABLE `clase` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `descripcion` text,
  `fecha_hora` datetime NOT NULL,
  `id_maestro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `id` int(11) NOT NULL,
  `calle` text NOT NULL,
  `numero` text NOT NULL,
  `colonia` text NOT NULL,
  `ciudad` text NOT NULL,
  `estado` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestro`
--

CREATE TABLE `maestro` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `apellidos` text NOT NULL,
  `correo` text NOT NULL,
  `telefono` text NOT NULL,
  `id_direccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `alumno_direccion_id_fk` (`id_direccion`);

--
-- Indices de la tabla `alumno_clase`
--
ALTER TABLE `alumno_clase`
  ADD PRIMARY KEY (`id`),
  ADD KEY `alumno_clase_clase_id_fk` (`id_clase`),
  ADD KEY `alumno_clase_alumno_id_fk` (`id_alumno`);

--
-- Indices de la tabla `clase`
--
ALTER TABLE `clase`
  ADD PRIMARY KEY (`id`),
  ADD KEY `clase_maestro_id_fk` (`id_maestro`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `maestro`
--
ALTER TABLE `maestro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `maestro_direccion_id_fk` (`id_direccion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `alumno_clase`
--
ALTER TABLE `alumno_clase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `clase`
--
ALTER TABLE `clase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `maestro`
--
ALTER TABLE `maestro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `alumno_direccion_id_fk` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id`);

--
-- Filtros para la tabla `alumno_clase`
--
ALTER TABLE `alumno_clase`
  ADD CONSTRAINT `alumno_clase_alumno_id_fk` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id`),
  ADD CONSTRAINT `alumno_clase_clase_id_fk` FOREIGN KEY (`id_clase`) REFERENCES `clase` (`id`);

--
-- Filtros para la tabla `clase`
--
ALTER TABLE `clase`
  ADD CONSTRAINT `clase_maestro_id_fk` FOREIGN KEY (`id_maestro`) REFERENCES `maestro` (`id`);

--
-- Filtros para la tabla `maestro`
--
ALTER TABLE `maestro`
  ADD CONSTRAINT `maestro_direccion_id_fk` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
