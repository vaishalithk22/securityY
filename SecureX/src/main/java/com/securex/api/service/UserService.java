package com.securex.api.service;

import com.securex.api.request.AdminRequest;
import com.securex.api.request.CustomerRequest;
import com.securex.api.request.DispatcherRequest;
import com.securex.api.request.GuardRequest;
import com.securex.api.security.UserCredentials;

public interface UserService {

    
//    List<UserCredentials> findAll();
//    void delete(long id);
//    UserCredentials findOne(String username);

   // UserCredentials findById(Long id);
	UserCredentials saveCredentials(CustomerRequest customerdata);
	UserCredentials saveCredentials(GuardRequest guarddata);
	UserCredentials saveCredentials(AdminRequest admindata);
	UserCredentials saveCredentials(DispatcherRequest dispatcherdata);
	
}
