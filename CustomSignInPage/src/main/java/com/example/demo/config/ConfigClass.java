package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ConfigClass {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(req -> req
                .requestMatchers("/admin").authenticated()
                .anyRequest().permitAll()).formLogin(foam -> foam.loginPage("/loginpage").permitAll()
                .loginProcessingUrl("/login"));
//          http.authorizeHttpRequests(req->req.anyRequest().authenticated()).formLogin(withDefaults());      
		return http.build();
	}
	@Bean
	UserDetailsService details() {
		UserDetails u1=User.withUsername("balaji").password("{noop}123").build();
		return new InMemoryUserDetailsManager(u1);
	}
	
	
//	@Bean
//    ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("templates/");
//        //resolver.setSuffix(".html");
//        return resolver;
//    }

}
