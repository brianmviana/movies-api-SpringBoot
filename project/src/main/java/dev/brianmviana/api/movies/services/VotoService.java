package dev.brianmviana.api.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.brianmviana.api.movies.models.Filme;
import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.models.Voto;
import dev.brianmviana.api.movies.repositories.FilmeRepository;
import dev.brianmviana.api.movies.repositories.UsuarioRepository;
import dev.brianmviana.api.movies.repositories.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Voto> getAllVotos(){
		List<Voto> votoslist = votoRepository.findAll();
		return votoslist;
	}
	
	public Voto votar(Voto voto) {
		Filme filme = filmeRepository.getOne(voto.getFilme().getId());
//		Usuario usuario = usuarioRepository.findByLogin(voto.getUsuario().getLogin());
//		if (isDuplicatedVoto(filme, usuario)) {
//			return updateNota(voto.getNota(), voto.getId());
//		}
		return votar(voto.getNota(), filme);
	}
	
//	public boolean isDuplicatedVoto(Filme filme, Usuario usuario) {
//		for (Voto votoUsuario : usuario.getVotos()) {
//			if (filme.equals(votoUsuario.getFilme())) {
//				return true;
//			}
//				
//		}
//		return false;
//	}

	public Voto votar(Integer nota, Filme filme) {
		if (notaIsValid(nota)) {
			Voto voto = new Voto();
			voto.setNota(nota);
			voto.setFilme(filme);
			//voto.setUsuario(usuario);
			return votoRepository.save(voto);
		}
		return null;
	}
	
	public Voto updateNota(Integer nota, Long votoId) {
		Voto voto = votoRepository.getOne(votoId);
		voto.setNota(nota);
		return votoRepository.save(voto);
	}
	
	private Boolean notaIsValid(Integer nota) {
		if(nota >= 0 && nota <= 4) {
			return true;
		}
		return false;
	}
	
	
}
