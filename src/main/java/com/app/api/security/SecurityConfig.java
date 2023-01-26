package com.app.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.api.service.UserServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	//método para la autenticación
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		//credenciales en BD
		auth.userDetailsService(userServiceImpl);
		
	}
	// para los permisos
	// método para la autorización
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/producto/listar").access("hasRole('USER')")
			.antMatchers("/producto/registrar").access("hasRole('ADMIN')")
			.antMatchers("/producto/editar/*").access("hasRole('USER') and hasRole('ADMIN')")
			.antMatchers("/producto/borrar/*").access("hasRole('USER') and hasRole('ADMIN')")
			.antMatchers("/categoria/listar").access("hasRole('USER')")
			.antMatchers("/categoria/registrar").access("hasRole('ADMIN')")
			.antMatchers("/categoria/editar/*").access("hasRole('USER') and hasRole('ADMIN')")
			.antMatchers("/categoria/borrar/*").access("hasRole('USER') and hasRole('ADMIN')")
			.antMatchers("/producto_proveedor/listar").access("hasRole('USER')")
			.antMatchers("/producto_proveedor/registrar").access("hasRole('ADMIN')")
			.antMatchers("/jefe/listar").access("hasRole('USER')")
			.antMatchers("/jefe/registrar").access("hasRole('ADMIN')")
			.antMatchers("/jefe/editar/*").access("hasRole('USER') and hasRole('ADMIN')")
			.antMatchers("/jefe/borrar/*").access("hasRole('USER') and hasRole('ADMIN')")
			.antMatchers("/proveedor/listar").access("hasRole('USER')")
			.antMatchers("/proveedor/registrar").access("hasRole('ADMIN')")
			.antMatchers("/proveedor/editar/*").access("hasRole('USER') and hasRole('ADMIN')")
			.antMatchers("/proveedor/borrar/*").access("hasRole('USER') and hasRole('ADMIN')")
			.antMatchers("/user/list").access("hasRole('USER')")
			//.antMatchers("/user/register").access("hasRole('ADMIN')")
			.antMatchers("/user/edit/*").access("hasRole('ADMIN')")
			.antMatchers("/user/deactivate/*").access("hasRole('ADMIN')")
			.antMatchers("/user_role/register").access("hasRole('ADMIN')");
			
		//app rest
		http.authorizeRequests().and().csrf().disable();
			
		//basic authentication
		http.authorizeRequests().and().httpBasic();
		
		//cuentas independientes
		http.authorizeRequests().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}

    //bean para cifrar contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
