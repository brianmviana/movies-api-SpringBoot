package dev.brianmviana.api.movies.services;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.brianmviana.api.movies.models.Filme;
import dev.brianmviana.api.movies.repositories.FilmeRepository;
import dev.brianmviana.api.movies.resouces.FilmeResource;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	public List<Filme> getAllFilmes(){
		List<Filme> filmeslist = filmeRepository.findAll();
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		for (Filme filme : filmeslist) {
			long id = filme.getId();
			filme.add(linkTo(methodOn(FilmeResource.class).getFilme(id)).withSelfRel());
			filmes.add(filme);
		}
		return filmes;
	}
	
	public Filme getFilmeById(long id) {
		Filme filme = filmeRepository.findById(id);
		filme.add(linkTo(methodOn(FilmeResource.class).getAllFilme()).withRel("Lista de Filmes"));
		return filme;
	}
	
	public Filme saveFilme(Filme filme) {
		List<Filme> filmeExist = filmeRepository.findByNome(filme.getNome());
		if (!filmeExist.isEmpty()) {
			filme = filmeExist.get(0);
		}
		filmeRepository.save(filme);
		filme.add(linkTo(methodOn(FilmeResource.class).getAllFilme()).withRel("Lista de Filmes"));
		return filme;
	}
	
	public Filme deleteFilme(Filme filme) {
		filme.setStatus(false);
		filmeRepository.save(filme);
		return filme;
	}
	
}
