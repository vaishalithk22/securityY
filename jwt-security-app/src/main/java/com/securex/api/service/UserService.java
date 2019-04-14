package com.securex.api.service;

import java.util.List;

import com.securex.api.model.customer.CustomerDto;
import com.securex.api.model.user.UserCredentials;

public interface UserService {

    
    List<UserCredentials> findAll();
    void delete(long id);
    UserCredentials findOne(String username);

    UserCredentials findById(Long id);
	UserCredentials saveCredentials(CustomerDto customerdata);
}
