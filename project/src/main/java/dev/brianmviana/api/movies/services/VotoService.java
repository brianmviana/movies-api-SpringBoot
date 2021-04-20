package dev.brianmviana.api.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.brianmviana.api.movies.models.Filme;
import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.models.Voto;
import dev.brianmviana.api.movies.models.utils.VotoRequest;
import dev.brianmviana.api.movies.repositories.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private FilmeService filmeService;

	@Autowired
	private UsuarioService usuarioService;
	
	public List<Voto> getVotosByFilme(Long id){
		Filme filme = filmeService.getFilmeById(id);
		return filme.getVotos();
	}
	

	public List<Voto> getVotosByUsuario(String login) {
		Usuario usuario = usuarioService.getUsuarioByLogin(login);
		return usuario.getVotos();
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

	public Voto votar(Long idFilme, VotoRequest votoRequest) {
		if (notaIsValid(votoRequest.getNota())) {
		
			Filme filme = filmeService.getFilmeById(idFilme);
			Usuario usuario = usuarioService.getUsuarioByLogin(votoRequest.getLogin());
			Voto voto = new Voto();
			
			voto.setNota(votoRequest.getNota());
			voto.setFilme(filme);
			voto.setUsuario(usuario);

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
