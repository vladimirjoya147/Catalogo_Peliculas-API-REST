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
