package com.Trycatch.movie.catalog.Controller;

import com.Trycatch.movie.catalog.DTO.DatosAutenticacionUsuario;
import com.Trycatch.movie.catalog.Entidad.Role;
import com.Trycatch.movie.catalog.Entidad.Usuario;
import com.Trycatch.movie.catalog.DTO.DTOJWTToken;
import com.Trycatch.movie.catalog.Security.TokenService;
import com.Trycatch.movie.catalog.Servicio.PeliculasServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private final AuthenticationManager authenticationManager;
    private TokenService tokenService;
    private final PeliculasServicio servicio;

    public UsuarioController(PeliculasServicio peliculasServicio,TokenService tokenService, AuthenticationManager
            authenticationManager){
        this.servicio=peliculasServicio;
        this.tokenService=tokenService;
        this.authenticationManager=authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.nombre_usuario(),
                datosAutenticacionUsuario.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);

        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DTOJWTToken(JWTtoken));

    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario){
        usuario.setRoles(Collections.singleton(Role.ROLE_USER));
        Usuario nuevousuario = servicio.almacenarUsuario(usuario);
        return ResponseEntity.ok("Usuario registrado con exito!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id){
        servicio.eliminarUsuarioId(id);
        return ResponseEntity.ok("Usuario eliminado ecitosamente");
    }


}
