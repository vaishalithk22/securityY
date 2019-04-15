package com.securex.api.service;

import com.securex.api.model.dispatcher.Dispatcher;
import com.securex.api.model.dispatcher.DispatcherDto;
import com.securex.api.model.user.UserCredentials;

public interface DispatcherService {
	Dispatcher saveDipatcher(DispatcherDto dispatcher,UserCredentials user);
}
