package com.example.demo.SecurityPackage;

import static org.springframework.security.config.Customizer.withDefaults;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.ServicePackage.UserDetailserviceImpl;

@Configuration
@EnableWebSecurity
public class ConfigFile {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http.authorizeHttpRequests((req) -> req
//				 .requestMatchers("/home/admin")
//				 .hasRole("Admin")
//				 .requestMatchers("/home/employee")
//				 .hasRole("Employee").authenticated().requestMatchers("/home/normal").permitAll())
//				 	.requestMatchers("home/normal").permitAll().requestMatchers("/home/admin")
//					 .hasRole("Admin")
//					 .requestMatchers("/home/employee").hasRole("Employee")).formLogin(withDefaults());
				 
				 .requestMatchers("/home/admin").authenticated()
				 
				 .requestMatchers("/home/normal")
				 .permitAll())
		 		 .formLogin(withDefaults());
				 
				 
				 	
		 return http.build();
	}
	
	@Bean
	PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(service());
		authenticationProvider.setPasswordEncoder(encoder());
		
		return authenticationProvider;
	}
	
	
	@Bean 
	UserDetailsService service() {

//		UserDetails u1=User.withUsername("Balaji").password("{noop}Balaji").roles("Admin","Employee").build();
//		UserDetails u2=User.withUsername("BalajiNaidu").password("{noop}BalajiNaidu").roles("Employee").build();
//		return new InMemoryUserDetailsManager(u1,u2);
		return new UserDetailserviceImpl();
	}
}
