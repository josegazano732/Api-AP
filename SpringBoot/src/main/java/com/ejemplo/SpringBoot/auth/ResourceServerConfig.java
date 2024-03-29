
package com.ejemplo.SpringBoot.auth;

import java.util.Arrays;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author JLG
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/personas","/api/proyecto","/api/educacion","/api/experiencia","/api/hardskill","/api/softskill").permitAll()
         /*.antMatchers(HttpMethod.GET, "/api/personas/{id}","/api/proyecto/{id}","/api/educacion/{id}","/api/experiencia/{id}","/api/hardskill/{id}","/api/softskill/{id}").permitAll()
         .antMatchers(HttpMethod.DELETE,"/api/personas/borrar/{id}","/api/proyecto/borrar/{id}","/api/educacion/borrar{id}","/api/experiencia/borrar/{id}","/api/hardskill/borrar/{id}","/api/softskill/borrar/{id}").hasRole("USER")//no
         .antMatchers(HttpMethod.PUT,"/api/hardskill/actualizar/{id}","/api/softskill/actualizar/{id}").hasRole("USER")
         .antMatchers(HttpMethod.POST,"/api/hardskill/nueva").hasRole("USER")*/ 
         //.antMatchers("/api/personas/**","/api/proyecto/**","/api/educacion/**","/api/experiencia/**","/api/softskill/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and().cors().configurationSource(corsConfigurationSource());
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("https://ap-jlg.web.app"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
    
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return bean;
	}

    
    
}
