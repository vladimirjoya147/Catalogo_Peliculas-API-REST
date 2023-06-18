package com.Trycatch.movie.catalog.Repositorio;

import com.Trycatch.movie.catalog.Entidad.Role;
import com.Trycatch.movie.catalog.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    UserDetails findByNombreUsuario(String nombreUsuario);

    List<Usuario> findByNombreUsuarioAndRoles(String nombreUsuario, Role rol);


}
