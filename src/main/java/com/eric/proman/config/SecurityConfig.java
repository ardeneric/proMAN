package com.eric.proman.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web
		.ignoring()
		.antMatchers("/css/**", "/fonts/**", "/img/**", "/js/**", "/sass/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()	
				.antMatchers("/userList").hasRole("SUPERUSER")
				.antMatchers("/**").authenticated()			
				.and()
				.formLogin()
					.loginPage("/login").permitAll()
					.failureUrl("/login-error")
					.and()
					.exceptionHandling()
					.accessDeniedPage("/login");
					
		          
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder() );
			//.inMemoryAuthentication()
				//.withUser("user").password("password").roles("USER");
	}
}
