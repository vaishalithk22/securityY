package com.securex.api.security;

import org.springframework.http.HttpStatus;

public class AuthToken {

	HttpStatus status= HttpStatus.OK;
    private String token;

    public AuthToken(){

    }

    public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
