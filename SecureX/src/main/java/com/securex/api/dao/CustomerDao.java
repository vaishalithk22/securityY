package com.securex.api.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securex.api.model.Customer;
@Repository
public interface CustomerDao extends CrudRepository<Customer, BigInteger>
{
	
}
