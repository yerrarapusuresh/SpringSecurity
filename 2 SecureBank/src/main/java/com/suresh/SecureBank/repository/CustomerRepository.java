package com.suresh.SecureBank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suresh.SecureBank.model.Customers;


@Repository
public interface CustomerRepository extends CrudRepository<Customers, Long> {


	public List<Customers> findByEmail(String email); 

}
