package com.Trycatch.movie.catalog.Security;

import com.Trycatch.movie.catalog.Entidad.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final SecurityFilter securityFilter;

    public SecurityConfiguration(SecurityFilter securityFilter){
        this.securityFilter=securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .requestMatchers(HttpMethod.POST,"usuarios/login","usuarios/registro" )
                .permitAll()
                .requestMatchers(HttpMethod.GET, "/movies","/buscar")
                .permitAll()
                .requestMatchers(HttpMethod.POST,"/movies/registrar","/registrar/{peliculaId}/usuario/{usuarioId}",
                        "/favoritos/registrar/{peliculaId}/usuario/{usuarioId}")
                .hasAnyAuthority(Role.ROLE_USER.name(), Role.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/buscar/{id}")
                .hasAnyAuthority(Role.ROLE_USER.name(), Role.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.PATCH, "/{id}")
                .hasAnyAuthority(Role.ROLE_USER.name(), Role.ROLE_ADMIN.name())
                .requestMatchers(HttpMethod.DELETE, "/usuarios/{id}","/movies/{id}")
                .hasAuthority(Role.ROLE_ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public AuthenticationManager  authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
