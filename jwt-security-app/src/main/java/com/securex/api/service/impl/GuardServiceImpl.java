package com.securex.api.service.impl;

import com.securex.api.dao.CustomerDao;
import com.securex.api.dao.UserDao;
import com.securex.api.model.customer.CustomerDto;
import com.securex.api.model.guard.Guard;
import com.securex.api.model.guard.GuardDto;
import com.securex.api.model.user.Role;
import com.securex.api.model.user.UserCredentials;
import com.securex.api.service.GuardService;
import com.securex.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GuardServiceImpl implements GuardService, UserService
{
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private UserDao userdao;
    @Autowired
    private CustomerDao customerdao;

    @Override
    public Guard save(GuardDto guard,UserCredentials user)
    {

    }


    @Override
    public UserCredentials saveCredentials(GuardDto customerdata) {
        // TODO Auto-generated method stub
        UserCredentials user= new UserCredentials();
        user.setUsername(customerdata.getUsername());
        user.setPassword(bcryptEncoder.encode(customerdata.getPassword()));
        Set<Role> roles= new HashSet<>();
        roles.add(new Role(1,"CUSTOMER","Customer role"));
        user.setRoles(roles);
        return userdao.save(user);
    }

    @Override
    public List<UserCredentials> findAll() {
        List<UserCredentials> list = new ArrayList<>();
        userdao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        userdao.deleteById(id);

    }

    @Override
    public UserCredentials findOne(String username) {
        // TODO Auto-generated method stub
        return userdao.findByUsername(username);	}

    @Override
    public UserCredentials findById(Long id) {
        // TODO Auto-generated method stub
        return userdao.findById(id).get();
    }


}
