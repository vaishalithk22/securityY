package com.securex.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securex.api.security.UserCredentials;

@Repository
public interface UserDao extends CrudRepository<UserCredentials, Long> {
    UserCredentials findByUsername(String username);
}
