package com.securex.api.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securex.api.dao.CompanyDao;
import com.securex.api.dao.DispatcherDao;
import com.securex.api.model.Dispatcher;
import com.securex.api.request.DispatcherRequest;
import com.securex.api.security.UserCredentials;
import com.securex.api.service.DispatcherService;
@Service
public class DispatcherServiceImpl implements DispatcherService {

	@Autowired
	private DispatcherDao dispatcherdao;
	@Autowired
	private CompanyDao companydao;
	
	
	@Override
	public Dispatcher saveDipatcher(DispatcherRequest dispatcherdata, UserCredentials user) {
		// TODO Auto-generated method stub
		Date date= new Date(); 
		long time = date.getTime();
		Timestamp ts= new Timestamp(time);
	
		Dispatcher dispatcher= new Dispatcher();
		dispatcher.setFirstname(dispatcherdata.getFirstname());
		dispatcher.setLastname(dispatcherdata.getLastname());
		dispatcher.setPhotoUrl(dispatcherdata.getPhotoUrl());
		dispatcher.setPhone(dispatcherdata.getPhone());
		dispatcher.setJoiningDate(ts);
		dispatcher.setUser(user);
		dispatcher.setCompany(companydao.findByName(dispatcherdata.getCompanyName()));
		return dispatcherdao.save(dispatcher);
	}

}
