package dev.brianmviana.api.movies.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAuthorizationServer
@EnableResourceServer
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private ImplementsUserDetailsService userDetailsService;
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http.csrf().disable().authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/filmes").permitAll()
//		//.antMatchers(HttpMethod.GET, "/filmes").hasRole("ADMIN")
//		.antMatchers(HttpMethod.POST, "/filmes").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and().formLogin().permitAll()
//		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(userDetailsService)
//		.passwordEncoder(new BCryptPasswordEncoder());
//	}
	

	
//	@Override
//	public void configure(WebSecurity web) throws Exception{
//		web.ignoring().antMatchers("/swagger-ui**");
//	}
	
}
