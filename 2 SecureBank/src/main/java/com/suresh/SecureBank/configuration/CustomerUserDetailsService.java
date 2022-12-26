package com.suresh.SecureBank.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.suresh.SecureBank.model.Customers;
import com.suresh.SecureBank.repository.CustomerRepository;


@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customers> customer = customerRepository.findByEmail(username);
		if (customer.size() < 1)
			throw new UsernameNotFoundException("user not found");

		String userName = customer.get(0).getEmail();
		String password = customer.get(0).getPassword();
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add((new SimpleGrantedAuthority(customer.get(0).getRole())));
		return new User(userName, password, authorities);
	}

}
