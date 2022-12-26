package com.suresh.SecureBank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/myBalance", "/myAccount").authenticated()
				.requestMatchers("/notices", "/contacts", "/userRegistration").permitAll().and().httpBasic().and()
				.formLogin().and().build();
	}

//	@Bean
//	InMemoryUserDetailsManager createInMemoryUsers() {
//	 UserDetails adminUser = User.withDefaultPasswordEncoder().username("suresh").password("****").authorities("admin").build();
//	 UserDetails user = User.withDefaultPasswordEncoder().username("user").password("****").authorities("user").build();
//	 return new InMemoryUserDetailsManager(adminUser, user);
//	}

//	@Bean
//	UserDetailsService jdbcUsers(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}
//	

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
