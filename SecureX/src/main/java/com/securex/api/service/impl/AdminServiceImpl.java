package com.securex.api.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securex.api.dao.AdminDao;
import com.securex.api.dao.CompanyDao;
import com.securex.api.model.Administrator;
import com.securex.api.request.AdminRequest;
import com.securex.api.security.UserCredentials;
import com.securex.api.service.AdminService;
@Service("adminService")
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminDao admindao;
	@Autowired
	private CompanyDao companydao;
	
	@Override
	public Administrator saveAdmin(AdminRequest adminData , UserCredentials user) {
		// TODO Auto-generated method stub
		Date date= new Date(); 
		long time = date.getTime();
		Timestamp ts= new Timestamp(time);
	
		Administrator admin= new Administrator();
		admin.setFirstname(adminData.getFirstname());
		admin.setLastname(adminData.getLastname());
		admin.setPhotoUrl(adminData.getPhotoUrl());
		admin.setPhone(adminData.getPhone());
		admin.setJoiningDate(ts);
		admin.setUser(user);
		admin.setCompany(companydao.findByName(adminData.getCompanyName()));
		return admindao.save(admin);
	}
}
