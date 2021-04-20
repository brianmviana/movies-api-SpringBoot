package dev.brianmviana.api.movies.models;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIgnoreProperties({	
			"hibernateLazyInitializer", 
			"handler", 
			"authorities", 
			"enabled",
			"accountNonExpired", 
			"credentialsNonExpired", 
			"accountNonLocked",
			"username", //UserDatails
			"password" //UserDatails
		})
@Entity
public class Usuario extends RepresentationModel<Usuario> implements UserDetails, Comparator<Usuario> {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	private String login;
	
	@NotNull
	private String nome;
	
	@NotBlank
	private String senha;
	
	@NotNull
	private Boolean status;
	
	@JsonIgnoreProperties({ "usuarios", "authority", "authorities" })
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( 
	        name = "usuarios_roles", 
	        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"), 
        	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
	private List<Role> roles;
	
	@JsonIgnoreProperties({ "filmes", "usuarios", "id" })
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Voto> votos;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public int compare(Usuario user1, Usuario user2) {
		return  user1.getNome().compareTo(user2.getNome());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
