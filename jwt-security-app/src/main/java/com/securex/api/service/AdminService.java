package com.securex.api.service;

import com.securex.api.model.admindispatcher.Administrator;
import com.securex.api.model.admindispatcher.AdminDto;

public interface AdminService 
{
	Administrator save(AdminDto admin);
}
