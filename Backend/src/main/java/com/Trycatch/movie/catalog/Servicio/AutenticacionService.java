package com.Trycatch.movie.catalog.Servicio;


import com.Trycatch.movie.catalog.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;

    public AutenticacionService(UsuarioRepositorio usuarioRepositorio){
        this.usuarioRepositorio=usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String nombre_usuario) throws UsernameNotFoundException {
        return usuarioRepositorio.findByNombreUsuario(nombre_usuario);
    }
}
