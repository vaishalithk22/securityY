package com.securex.api.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securex.api.model.Company;

@Repository
public interface CompanyDao extends CrudRepository<Company, BigInteger> {
	Company findByName(String username);
}
