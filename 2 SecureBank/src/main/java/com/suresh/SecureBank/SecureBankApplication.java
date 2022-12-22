package com.suresh.SecureBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SecureBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureBankApplication.class, args);
	}

}
