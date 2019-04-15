package com.securex.api.model.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="errors")
public class ErrorSettings {

private String custreg;
private String custlogin;
private String guardreg;
private String guardlogin;
private String adminreg;
private String adminlogin;
 
}