package com.suresh.SecureBank.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests().requestMatchers("/myBalance","/myAccount").authenticated().requestMatchers("/notices", "/contacts").permitAll().and().httpBasic().and().formLogin().and().build();
	}

}
