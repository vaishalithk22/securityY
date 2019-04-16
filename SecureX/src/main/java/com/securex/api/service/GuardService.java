package com.securex.api.service;

import com.securex.api.model.guard.Guard;
import com.securex.api.model.guard.GuardDto;
import com.securex.api.model.user.UserCredentials;

public interface GuardService 
{
	Guard saveGuard(GuardDto guard, UserCredentials user);
	Guard register(String activationcode);
}
