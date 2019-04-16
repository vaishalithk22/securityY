package com.securex.api.service;

import com.securex.api.model.Dispatcher;
import com.securex.api.request.DispatcherRequest;
import com.securex.api.security.UserCredentials;

public interface DispatcherService {
	Dispatcher saveDipatcher(DispatcherRequest dispatcher,UserCredentials user);
}
