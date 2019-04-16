package com.securex.api.service;

import com.securex.api.model.Guard;
import com.securex.api.request.GuardRequest;
import com.securex.api.security.UserCredentials;

public interface GuardService 
{
	Guard saveGuard(GuardRequest guard, UserCredentials user);
	Guard register(String activationcode);
}
