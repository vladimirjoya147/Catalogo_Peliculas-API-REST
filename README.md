# team-26-backend

## Proyecto 7 Catálogo de películas

### Listado de requerimiento

- Registro y edición de películas (título, género, año, - director, sinopsis, etc.).
- Listado y búsqueda de películas.
- Visualización de detalles de películas.
- Eliminación de películas.
- Gestión de categorías y géneros de películas.
- Registro y gestión de calificaciones y reseñas de - películas.

## Ejecutar el proyecto

```console
cd team-26-backend
docker-compose up -d
```

El servicio se desplegará en la siguiente ruta base

```
http://localhost:8080/movies
```

## Administración y manual de uso de endpoints
cada usuario por defecto en su registro se le asignara el rol de usuario en la base de datos designado como ROL_USER,
en la creacion de los contenedores se ingresan 5 peliculas con sus propiedades y dos usuarios con ROL_ADMIN que tiene acceso a todos los endpoints, los usuarios son:

- usuario: lysandra1980 - contraseña: 123456789
- usuario: morrison2000 - contraseña: 987654321



<br>
EndPoints Libres:

```   
     - Get:    http://localhost:8080/movies
     - Get:    http://localhost:8080/buscar
     - Post:   http://localhost:8080/usuarios/login
     - Post:   http://localhost:8080/usuarios/registro
```
  EndPoints ROLE_USER:
```
    - Get:    http://localhost:8080/movies/buscar/{id}
    - Post:   http://localhost:8080/movies/{id} 
    - Post:   http://localhost:8080/favoritos/registrar/{peliculaId}/usuario/{usuarioId}
    - Post:   http://localhost:8080/registrar/{peliculaId}/usuario/{usuarioId}
```
  EndPoints ROLE_ADMIN: 
```
    - Delete: http://localhost:8080/movies/{id} 
    - Delete: http://localhost:8080/usuarios/{id}       
```

LOGIN:
- la API está protegida con Spring Security y utiliza JWT para manejar la autenticación y autorización, con los datos de usuario en Json haciendo peticion POST si se ingresa correctamente y esta en la base de datos se genera un token que tiene una vida útil de dos horas ya que debe renovarse periódicamente para evitar el acceso no autorizado.


<p align="center">
  <img src=https://github.com/vladimirjoya147/Encriptador/assets/121407957/80ad1de0-bd16-443e-b08e-ed635033179c width="500">
</p>



- todos los request consecuentes necesitaran el JWT, copiar el token seleccionar el tipo de autenticacion en tu sofware de cliente API, el tipo de autenticacion es Bearer token 


<p align="center">
  <img src="https://github.com/vladimirjoya147/Encriptador/assets/121407957/0fcc9376-b3f4-4e44-90b2-5e95ef01dfec" width="500">
</p>

- podras ingresar a los endpoint dependiendo tu rol de usuario 

## Herramientas usadas:

<a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> <a href="https://www.w3.org/html/" target="_blank" rel="noreferrer"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank" rel="noreferrer"> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>

## Contactame

<h5>Autor</h5>

| [<img src="https://github.com/vladimirjoya147/Catalogo_Peliculas-API-REST/assets/121407957/86ec0e96-c4a6-433d-a78d-1c0973c3c8f1" width=115><br><sub>Vladimir Joya Rojas</sub>](https://github.com/vladimirjoya147) |
| :---: | 

- [Linkedin](https://www.linkedin.com/in/vladimir-joya-rojas1990/)
- [Mail](mailTo:vladimirjoya148@gmail.com)
