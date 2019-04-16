package com.securex.api.service;

import com.securex.api.model.admin.AdminDto;
import com.securex.api.model.customer.CustomerDto;
import com.securex.api.model.dispatcher.DispatcherDto;
import com.securex.api.model.guard.GuardDto;
import com.securex.api.model.user.UserCredentials;

public interface UserService {

    
//    List<UserCredentials> findAll();
//    void delete(long id);
//    UserCredentials findOne(String username);

   // UserCredentials findById(Long id);
	UserCredentials saveCredentials(CustomerDto customerdata);
	UserCredentials saveCredentials(GuardDto guarddata);
	UserCredentials saveCredentials(AdminDto admindata);
	UserCredentials saveCredentials(DispatcherDto dispatcherdata);
	
}
