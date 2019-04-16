package com.securex.api.service;

import com.securex.api.model.admin.AdminDto;
import com.securex.api.model.admin.Administrator;
import com.securex.api.model.user.UserCredentials;

public interface AdminService 
{
	Administrator saveAdmin(AdminDto admin,UserCredentials user);
}
