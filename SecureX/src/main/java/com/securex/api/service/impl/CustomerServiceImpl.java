package com.securex.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securex.api.dao.CustomerDao;
import com.securex.api.model.customer.Customer;
import com.securex.api.model.customer.CustomerDto;
import com.securex.api.model.user.UserCredentials;
import com.securex.api.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService
{
	
	@Autowired
	private CustomerDao customerdao;
	@Override
	public Customer saveCustomer(CustomerDto customerdata , UserCredentials user) {
		// TODO Auto-generated method stub
		
		Customer customer= new Customer();
		customer.setFirstname(customerdata.getFirstname());
		customer.setLastname(customerdata.getLastname());
		customer.setStreet1(customerdata.getStreet1());
		customer.setStreet2(customerdata.getStreet2());
		customer.setCity(customerdata.getCity());
		customer.setState(customerdata.getState());
		customer.setZipcode(customerdata.getZipcode());
		customer.setPhone(customerdata.getPhone());
		customer.setPhotourl(customerdata.getPhotourl());
		customer.setUser(user);
		
		return customerdao.save(customer);
	}

//	@Override
//	public UserCredentials saveCredentials(CustomerDto customerdata) {
//		// TODO Auto-generated method stub
//		UserCredentials user= new UserCredentials();
//		user.setUsername(customerdata.getUsername());
//		user.setPassword(bcryptEncoder.encode(customerdata.getPassword()));
//		Set<Role> roles= new HashSet<>();
//		roles.add(new Role(1,"CUSTOMER","Customer role"));
//		user.setRoles(roles);
//		return userdao.save(user);
//	}
	
//	@Override
//	public List<UserCredentials> findAll() {
//		List<UserCredentials> list = new ArrayList<>();
//		userdao.findAll().iterator().forEachRemaining(list::add);
//		return list;
//	}
//
//	@Override
//	public void delete(long id) {
//		userdao.deleteById(id);
//	}
//
//	@Override
//	public UserCredentials findOne(String username) {
//		return userdao.findByUsername(username);
//	}
//
//	@Override
//	public UserCredentials findById(Long id) {
//		return userdao.findById(id).get();
//	}

	
	
	
	
}
