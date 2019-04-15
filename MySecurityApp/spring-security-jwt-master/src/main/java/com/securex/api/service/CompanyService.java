package com.securex.api.service;

import com.securex.api.model.company.Company;

public interface CompanyService 
{
	Company findOne(String username);
}
