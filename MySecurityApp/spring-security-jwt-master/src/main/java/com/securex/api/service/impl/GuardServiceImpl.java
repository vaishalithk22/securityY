package com.securex.api.service.impl;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securex.api.dao.CompanyDao;
import com.securex.api.dao.GuardDao;
import com.securex.api.model.guard.Guard;
import com.securex.api.model.guard.GuardDto;
import com.securex.api.model.user.UserCredentials;
import com.securex.api.service.GuardService;
import java.sql.Timestamp;
import java.util.Date;
@Service
public class GuardServiceImpl implements GuardService
{

	@Autowired
	private GuardDao guarddao;
	@Autowired
	private CompanyDao companydao;
	@Override
	public Guard saveGuard(GuardDto guardData , UserCredentials user) {
		// TODO Auto-generated method stub
		Date date= new Date(); 
		long time = date.getTime();
		Timestamp ts= new Timestamp(time);
	
		Guard guard= new Guard();
		guard.setFirstname(guardData.getFirstname());
		guard.setLastname(guardData.getLastname());
		guard.setPhotoUrl(guardData.getPhotoUrl());
		guard.setPhone(guardData.getPhone());
		guard.setJoiningDate(ts);
		guard.setUser(user);
		guard.setGuardNo("G2209");
		guard.setGuardstatus("Inactive");
		Random r = new Random();
		Float temp=100000 + r.nextFloat() * 900000;
		Integer temp2= temp.intValue();
		String ac= temp2.toString();
		guard.setActivationCode(ac);
		guard.setCompany(companydao.findByName(guardData.getCompanyName()));
		return guarddao.save(guard);
	}

//	@Override
//	public UserCredentials saveCredentials(GuardDto guarddata) {
//		// TODO Auto-generated method stub
//		UserCredentials user= new UserCredentials();
//		user.setUsername(guarddata.getUsername());
//		user.setPassword(bcryptEncoder.encode(guarddata.getPassword()));
//		Set<Role> roles= new HashSet<>();
//		roles.add(new Role(1,"CUSTOMER","Customer role"));
//		user.setRoles(roles);
//		return userdao.save(user);
//	}

//	@Override
//	public List<UserCredentials> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void delete(long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public UserCredentials findOne(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public UserCredentials findById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public UserCredentials saveCredentials(CustomerDto customerdata) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
