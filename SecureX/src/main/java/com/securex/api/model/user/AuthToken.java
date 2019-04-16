package com.securex.api.model.user;

import org.springframework.http.HttpStatus;

public class AuthToken {

	HttpStatus status= HttpStatus.OK;
    private String token;

    public AuthToken(){

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
