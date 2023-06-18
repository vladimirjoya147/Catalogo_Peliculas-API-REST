
INSERT INTO peliculas_directores (nombre) VALUES ('Roe Minkoff');
SET @director_id = LAST_INSERT_ID();
INSERT INTO peliculas (calificacion, duracion, rutaportada, sypnosis, titulo, anno_lanzamiento, director_id)
VALUES (4.5, '115', 'https://www.aceprensa.com/wp-content/uploads/1994/10/8587-0.jpg', 'Tras la muerte de su padre, Simba deberá enfrentarse a su tío para recuperar el trono de Rey de la Selva. Timón y Pumba le acompañarán en su misión.', 'Rey León', 1994, @director_id);
INSERT INTO peliculas_generos (pelicula_id, generos)
VALUES (LAST_INSERT_ID(), 'INFANTIL');

-- Insertar la película "Avatar"
INSERT INTO peliculas_directores (nombre) VALUES ('James Cameron');
SET @director_id = LAST_INSERT_ID();
INSERT INTO peliculas (calificacion, duracion, rutaportada, sypnosis, titulo, anno_lanzamiento, director_id)
VALUES (4, '130', 'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/bqOqQ2Tawum3eHKNrc94P4EeaZB.jpg', 'Ambientada más de una década después de los acontecimientos de la primera película, Avatar: The Way of Water empieza contando la historia de la familia Sully Jake, Neytiri y sus hijos, los problemas que los persiguen, lo que tienen que hacer para mantenerse a salvo, las batallas que libran para seguir con vida y las tragedias que sufren.', 'Avatar', 2009, @director_id);
INSERT INTO peliculas_generos (pelicula_id, generos)
VALUES (LAST_INSERT_ID(), 'FANTASIA');

-- Insertar la película "Super Mario Bross"
INSERT INTO peliculas_directores (nombre) VALUES ('Michael Jelenic');
SET @director_id = LAST_INSERT_ID();
INSERT INTO peliculas (calificacion, duracion, rutaportada, sypnosis, titulo, anno_lanzamiento, director_id)
VALUES (4.1, '200', 'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg', 'Mientras trabajan bajo tierra para arreglar una tubería de agua, los plomeros de Brooklyn, y los hermanos, Mario y Luigi son transportados por una misteriosa tubería y vagan por un nuevo mundo mágico. Pero cuando los hermanos se separan, Mario se embarca en una búsqueda épica para encontrar a Luigi.', 'Super Mario Bross', 2023, @director_id);
INSERT INTO peliculas_generos (pelicula_id, generos)
VALUES (LAST_INSERT_ID(), 'INFANTIL');

-- Insertar la película "Shazam"
INSERT INTO peliculas_directores (nombre) VALUES ('David F. Sandberng');
SET @director_id = LAST_INSERT_ID();
INSERT INTO peliculas (calificacion, duracion, rutaportada, sypnosis, titulo, anno_lanzamiento, director_id)
VALUES (3.5, '120', 'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/igFLHxab9zG0M89OmEpnOM6TPXn.jpg', 'Billy Batson y sus hermanos adoptivos, que se transforman en superhéroes al decir ¡Shazam!, se ven obligados a volver a la acción y luchar contra las Hijas de Atlas, a quienes deben evitar que use un arma que podría destruir el mundo.', 'Shazam', 2023, @director_id);
INSERT INTO peliculas_generos (pelicula_id, generos)
VALUES (LAST_INSERT_ID(), 'COMEDIA');

-- Insertar la película "Smile"
INSERT INTO peliculas_directores (nombre) VALUES ('Parker Finn');
SET @director_id = LAST_INSERT_ID();
INSERT INTO peliculas (calificacion, duracion, rutaportada, sypnosis, titulo, anno_lanzamiento, director_id)
VALUES (2.1, '184', 'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/aPqcQwu4VGEewPhagWNncDbJ9Xp.jpg', 'Después de presenciar un incidente extraño y traumático que involucra a un paciente, 
        la Dra. Rose Cotter comienza a experimentar sucesos aterradores que no puede explicar.
        A medida que un terror abrumador comienza a apoderarse de su vida, Rose debe enfrentar su pasado problemático 
        para sobrevivir y escapar de su horrible nueva realidad', 'Smile', 2022, @director_id);
INSERT INTO peliculas_generos (pelicula_id, generos)
VALUES (LAST_INSERT_ID(), 'TERROR');