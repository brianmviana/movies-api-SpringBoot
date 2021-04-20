package dev.brianmviana.api.movies.repositories.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import dev.brianmviana.api.movies.models.Filme;
import dev.brianmviana.api.movies.repositories.filters.FilmeFilter;

public class FilmeRepositoryImpl implements FilmeRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Filme> filtrar(FilmeFilter filmeFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Filme> criteria = builder.createQuery(Filme.class);
		Root<Filme> root = criteria.from(Filme.class);
		
		
		//Restrinções
		Predicate[] predicates = criarRestricoes(filmeFilter, builder, root);
		criteria.where(predicates);
		//criteria.distinct(true);
		
		TypedQuery<Filme> query = manager.createQuery(criteria);

		adicionarRestrincoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(filmeFilter));
	}

	private Predicate[] criarRestricoes(FilmeFilter filmeFilter, CriteriaBuilder builder, Root<Filme> root) {

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!ObjectUtils.isEmpty(filmeFilter.getNome())) {
			predicates.add(
				builder.like(
					builder.lower(root.get("nome")), "%" + filmeFilter.getNome().toLowerCase() + "%"
				)
			);
		}

		if (!ObjectUtils.isEmpty(filmeFilter.getDiretor())) {
			predicates.add(
				builder.like(
					builder.lower(root.get("diretor")), "%" + filmeFilter.getDiretor().toLowerCase() + "%"
				)
			);
		}
		
		if (!ObjectUtils.isEmpty(filmeFilter.getGenero())) {
			predicates.add(
				builder.like(
					builder.lower(root.get("genero")), "%" + filmeFilter.getGenero().toLowerCase() + "%"
				)
			);
		}
		
		if (!ObjectUtils.isEmpty(filmeFilter.getAtor())) {
			
			predicates.add(
					builder.like(
						builder.lower(root.get("ator")), "%" + filmeFilter.getAtor().toLowerCase() + "%"
					)
				);
//			for(Atores ator : filmeFilter.getAtores()) {
//				predicates.add(
//					builder.equal(root.join("atores").get("nomeAtor"), ator.getNomeAtor())
//				);				
//			}
		}

		if (!ObjectUtils.isEmpty(filmeFilter.getAno())) {
			predicates.add(
				builder.like(
					builder.lower(root.get("ano")), "%" + filmeFilter.getAno().toLowerCase() + "%"
				)
			);
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestrincoesDePaginacao(TypedQuery<Filme> query, Pageable pageable) {
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
	}

	private Long total(FilmeFilter filmeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Filme> root = criteria.from(Filme.class);
		
		//Restrinções
		Predicate[] predicates = criarRestricoes(filmeFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
