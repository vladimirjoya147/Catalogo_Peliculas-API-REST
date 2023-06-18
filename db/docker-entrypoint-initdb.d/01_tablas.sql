CREATE TABLE `peliculas_directores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `peliculas` (
  `pelicula_id` int NOT NULL AUTO_INCREMENT,
  `calificacion` float NOT NULL,              
  `duracion` varchar(255) NOT NULL,
  `rutaportada` varchar(255) DEFAULT NULL,
  `sypnosis` TEXT DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `anno_lanzamiento` int DEFAULT NULL,
  `director_id` int DEFAULT NULL,
  PRIMARY KEY (`pelicula_id`),
  FOREIGN KEY (`director_id`) REFERENCES `peliculas_directores` (`id`)
);

CREATE TABLE `peliculas_generos` (
  `pelicula_id` int NOT NULL,
  `generos` varchar(255) NOT NULL,
  FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`pelicula_id`),
  PRIMARY KEY (`pelicula_id`, `generos`)
);

CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `correo_electronico` varchar(255) UNIQUE,
  `nombre` varchar(255) DEFAULT NULL,
  `nombre_usuario` varchar(255) UNIQUE,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `comentarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comentario` varchar(255) DEFAULT NULL,
  `fecha_comentario` datetime(6) DEFAULT NULL,
  `pelicula_id` int DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`pelicula_id`),
  FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  PRIMARY KEY (`id`)
);

CREATE TABLE `favoritos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pelicula_id` int DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`pelicula_id`),
  FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
);

CREATE TABLE `roles_usuario` (
  `usuario_id` bigint NOT NULL,
  `rol` varchar(255) DEFAULT NULL,
  KEY `FK69o485flaet41skdbkc54i2j0` (`usuario_id`),
  FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
);
