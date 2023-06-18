package com.Trycatch.movie.catalog.Servicio;

import com.Trycatch.movie.catalog.Entidad.Peliculas;
import com.Trycatch.movie.catalog.Entidad.Usuario;
import com.Trycatch.movie.catalog.Repositorio.PeliculasRepositorio;
import com.Trycatch.movie.catalog.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculasServicioImpl implements PeliculasServicio {

	private final PeliculasRepositorio repositorio;
	private final UsuarioRepositorio usuarioRepositorio;

	public PeliculasServicioImpl(PeliculasRepositorio repositorio, UsuarioRepositorio usuarioRepositorio) {
		this.repositorio = repositorio;
		this.usuarioRepositorio=usuarioRepositorio;
	}

	@Override
	public List<Peliculas> buscarPeliculaPorNombre(String nombre) {
		return repositorio.buscarPorNombre(nombre);
	}

	@Override
	public Page<Peliculas> listapeliculas(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	@Override
	public Peliculas obtenerPeliculaPorId(Integer id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Peliculas guardarPeliculas(Peliculas peliculas) {
		return repositorio.save(peliculas);
	}

	@Override
	public void eliminarPeliculaId(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public Peliculas actualizarPelicula(Peliculas peliculas) {
		return repositorio.save(peliculas);
	}

	@Override
	public Usuario almacenarUsuario(Usuario usuario){return usuarioRepositorio.save(usuario);}

	@Override
	public Usuario buscarUsuarioPorId(Long id){
		return usuarioRepositorio.findById(id).get();
	}

	@Override
	public void eliminarUsuarioId(Long id) { usuarioRepositorio.deleteById(id);

	}
}
