package com.securex.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.securex.api.dao.UserDao;
import com.securex.api.model.user.UserCredentials;
import com.securex.api.service.UserService;

import java.util.*;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {
	
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

//	public List<UserCredentials> findAll() {
//		List<UserCredentials> list = new ArrayList<>();
//		userDao.findAll().iterator().forEachRemaining(list::add);
//		return list;
//	}

//	@Override
//	public void delete(long id) {
//		userDao.deleteById(id);
//	}
//
//	@Override
//	public User findOne(String username) {
//		return userDao.findByUsername(username);
//	}
//
//	@Override
//	public User findById(Long id) {
//		return userDao.findById(id).get();
//	}
//
//	@Override
//    public User saveCredentials(UserDto user) {
//	    User newUser = new User();
//	    newUser.setUsername(user.getUsername());
//	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//        return userDao.save(newUser);
//    }
}
