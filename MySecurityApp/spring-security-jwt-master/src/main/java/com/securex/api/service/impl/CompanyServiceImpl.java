package com.securex.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securex.api.dao.CompanyDao;
import com.securex.api.model.company.Company;
import com.securex.api.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companydao;
	
	@Override
	public Company findOne(String name) {
		// TODO Auto-generated method stub
		return companydao.findByName(name);
	}

}
