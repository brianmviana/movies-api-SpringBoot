package dev.brianmviana.api.movies.repositories.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import dev.brianmviana.api.movies.models.Usuario;
import dev.brianmviana.api.movies.repositories.filters.UsuarioFilter;

public class UsuarioRepositoryImpl  implements UsuarioRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> root = criteria.from(Usuario.class);
		
		
		//Restrinções
		Predicate[] predicates = criarRestricoes(usuarioFilter, builder, root);
		criteria.where(predicates);
		//criteria.distinct(true);
		
		TypedQuery<Usuario> query = manager.createQuery(criteria);

		adicionarRestrincoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(usuarioFilter));
	}
	
	private Predicate[] criarRestricoes(UsuarioFilter usuarioFilter, CriteriaBuilder builder, Root<Usuario> root) {

		List<Predicate> predicates = new ArrayList<Predicate>();
		
		// Lista so usuarios ativos
		predicates.add(builder.equal(root.get("status"), true));
		
		
		// Lista de usuarios não admin
		Join roles = root.join("roles");
		Predicate usersAdmin = (builder.equal(roles.get("nomeRole"), "ROLE_USER"));
		predicates.add(usersAdmin);
		
		
		if (!ObjectUtils.isEmpty(usuarioFilter.getNome())) {
			predicates.add(
				builder.like(
					builder.lower(root.get("nome")), "%" + usuarioFilter.getNome().toLowerCase() + "%"
				)
			);
		}

		if (!ObjectUtils.isEmpty(usuarioFilter.getLogin())) {
			predicates.add(
				builder.like(
					builder.lower(root.get("login")), "%" + usuarioFilter.getLogin().toLowerCase() + "%"
				)
			);
		}
		
		if (!ObjectUtils.isEmpty(usuarioFilter.getNome())) {
			predicates.add(
				builder.like(
					builder.lower(root.get("nome")), "%" + usuarioFilter.getNome().toLowerCase() + "%"
				)
			);
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestrincoesDePaginacao(TypedQuery<Usuario> query, Pageable pageable) {
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
	}

	private Long total(UsuarioFilter usuarioFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Usuario> root = criteria.from(Usuario.class);
		
		//Restrinções
		Predicate[] predicates = criarRestricoes(usuarioFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
}
