package dev.brianmviana.api.movies.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.brianmviana.api.movies.models.Filme;
import dev.brianmviana.api.movies.repositories.FilmeRepository;
import dev.brianmviana.api.movies.repositories.filters.FilmeFilter;
import dev.brianmviana.api.movies.resouces.FilmeResource;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;
	
	public Page<Filme> pesquisar(FilmeFilter filmeFilter, Pageable pageable){
		Page<Filme> filmeslist = filmeRepository.filtrar(filmeFilter, pageable);
//		ArrayList<Filme> filmes = new ArrayList<Filme>();
		for (Filme filme : filmeslist.getContent()) {
			filme.add(linkTo(methodOn(FilmeResource.class).buscarFilme(filme.getId())).withSelfRel());
//			filmes.add(filme);
		}
		
//		filmes.sort(new Filme());
		//filmeslist.getContent().sort(new Filme());
		return filmeslist;
	}
	

	public Filme getFilmeById(Long id) {
		Filme filme = filmeRepository.getOne(id);
		if(filme == null) {
			throw new EmptyResultDataAccessException(1);
		}
		filme.add(linkTo(methodOn(FilmeResource.class).pesquisar(new FilmeFilter(), null)).withRel("Lista de Filmes"));
		return filme;
	}
	
	public Filme saveFilme(Filme filme) {
		List<Filme> filmeExist = filmeRepository.findByNome(filme.getNome());
		if (!filmeExist.isEmpty()) {
			filme = filmeExist.get(0);
		}
		filmeRepository.save(filme);
		filme.add(linkTo(methodOn(FilmeResource.class).pesquisar(new FilmeFilter(), null)).withRel("Lista de Filmes"));
		return filme;
	}
	
	public void deleteFilme(Long id) {
		Filme filme = filmeRepository.getOne(id);
		filme.setStatus(false);
		filmeRepository.save(filme);
	}
	
	public Filme updateFilme(Long id, Filme filme) {
		Filme filmeSaved = getFilmeById(id);
		BeanUtils.copyProperties(filme, filmeSaved, "id");
		return filmeRepository.save(filmeSaved);
	}
	
}
