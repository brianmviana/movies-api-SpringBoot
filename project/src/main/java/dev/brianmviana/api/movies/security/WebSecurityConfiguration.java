package dev.brianmviana.api.movies.security;

//@Configuration
//@EnableWebSecurity
//@EnableAuthorizationServer
//@EnableResourceServer
public class WebSecurityConfiguration {//extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private ImplementsUserDetailsService userDetailsService;
	
//	@Bean
//	@Override
//	protected AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
	
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
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
//	@Override
//	public void configure(WebSecurity web) throws Exception{
//		web.ignoring().antMatchers("/swagger-ui**");
//	}
	
}
