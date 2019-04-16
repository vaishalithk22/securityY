package com.securex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.securex.api.model.Administrator;
import com.securex.api.request.AdminRequest;
import com.securex.api.security.UserCredentials;
import com.securex.api.service.AdminService;
import com.securex.api.service.UserService;

public class SuperAdminController {
	@Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;
    
    @PreAuthorize("hasRole('SUPERADMIN')")
    @RequestMapping(value="/superadmin/addadmin", method = RequestMethod.POST)
    public Administrator saveUser(@RequestBody AdminRequest admindata){
    	UserCredentials user= userService.saveCredentials(admindata);
    	
        return adminService.saveAdmin(admindata,user);
    }
}
