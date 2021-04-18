package dev.brianmviana.api.movies.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

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
		Iterable<Filme> filmeslist = filmeRepository.findAll();
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
		filme.add(linkTo(methodOn(FilmeResource.class).listFilme()).withRel("Filmes list"));
		return filme;
	}
	
	public Filme saveFilme(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public Filme deleteFilme(Filme filme) {
		filme.setStatus(false);
		filmeRepository.save(filme);
		return filme;
	}
	
}
