package com.suresh.SecureBank.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests().requestMatchers("/myBalance","/myAccount").authenticated().requestMatchers("/notices", "/contacts").permitAll().and().httpBasic().and().formLogin().and().build();
	}
	
//	@Bean
//	InMemoryUserDetailsManager createInMemoryUsers() {
//	 UserDetails adminUser = User.withDefaultPasswordEncoder().username("suresh").password("****").authorities("admin").build();
//	 UserDetails user = User.withDefaultPasswordEncoder().username("user").password("****").authorities("user").build();
//	 return new InMemoryUserDetailsManager(adminUser, user);
//	}
	
	@Bean
	UserDetailsService jdbcUsers(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
