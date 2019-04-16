package com.securex.api.service;

import com.securex.api.model.Administrator;
import com.securex.api.request.AdminRequest;
import com.securex.api.security.UserCredentials;

public interface AdminService 
{
	Administrator saveAdmin(AdminRequest admin,UserCredentials user);
}
