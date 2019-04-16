package com.securex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.securex.api.model.Guard;
import com.securex.api.service.GuardService;
import com.securex.api.service.UserService;

public class GuardController {
	

    @Autowired
    private GuardService guardService;
    
    
    @RequestMapping(value="/guard/signup/{activationcode}", method = RequestMethod.GET)
    public Guard guardregister(@PathVariable(value="activationcode") String activationcode)
    {
    	return guardService.register(activationcode);
    	
    }
    
}
