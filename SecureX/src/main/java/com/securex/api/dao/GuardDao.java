package com.securex.api.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securex.api.model.Guard;
@Repository
public interface GuardDao extends CrudRepository<Guard, BigInteger>
{
	Guard findByActivationcode(String activationcode);
}
