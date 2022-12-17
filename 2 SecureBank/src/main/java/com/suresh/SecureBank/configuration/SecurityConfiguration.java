package com.suresh.SecureBank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain mySecurityCofig(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests().anyRequest().denyAll().and().formLogin().and().httpBasic().and().build();
	}

}
