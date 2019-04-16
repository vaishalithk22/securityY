package com.securex.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.securex.api.dao.UserDao;
import com.securex.api.request.AdminRequest;
import com.securex.api.request.CustomerRequest;
import com.securex.api.request.DispatcherRequest;
import com.securex.api.request.GuardRequest;
import com.securex.api.security.Role;
import com.securex.api.security.UserCredentials;
import com.securex.api.service.UserService;

import java.util.*;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService,UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("======================="+username);
		UserCredentials user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(UserCredentials user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	

	@Override
	public UserCredentials saveCredentials(CustomerRequest customerdata) {
		// TODO Auto-generated method stub
		UserCredentials user= new UserCredentials();
		user.setUsername(customerdata.getUsername());
		user.setPassword(bcryptEncoder.encode(customerdata.getPassword()));
		Set<Role> roles= new HashSet<>();
		roles.add(new Role(1,"CUSTOMER","Customer role"));
		user.setRoles(roles);
		return userDao.save(user);
	}

	@Override
	public UserCredentials saveCredentials(GuardRequest guarddata) {
		// TODO Auto-generated method stub
		UserCredentials user= new UserCredentials();
		user.setUsername(guarddata.getUsername());
		user.setPassword(bcryptEncoder.encode(guarddata.getPassword()));
		Set<Role> roles= new HashSet<>();
		roles.add(new Role(2,"GUARD","Guard role"));
		user.setRoles(roles);
		return userDao.save(user);
	}

	@Override
	public UserCredentials saveCredentials(AdminRequest admindata) {
		// TODO Auto-generated method stub
		UserCredentials user= new UserCredentials();
		user.setUsername(admindata.getUsername());
		user.setPassword(bcryptEncoder.encode(admindata.getPassword()));
		Set<Role> roles= new HashSet<>();
		roles.add(new Role(3,"ADMIN","Admin role"));
		user.setRoles(roles);
		return userDao.save(user);
	}

	@Override
	public UserCredentials saveCredentials(DispatcherRequest dispatcherdata) {
		// TODO Auto-generated method stub
		UserCredentials user= new UserCredentials();
		user.setUsername(dispatcherdata.getUsername());
		user.setPassword(bcryptEncoder.encode(dispatcherdata.getPassword()));
		Set<Role> roles= new HashSet<>();
		roles.add(new Role(4,"DISPATCHER","Dispatcher role"));
		user.setRoles(roles);
		return userDao.save(user);	}

}
