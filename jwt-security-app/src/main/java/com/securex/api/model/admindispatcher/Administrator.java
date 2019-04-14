package com.securex.api.model.admindispatcher;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.securex.api.model.company.Company;
import com.securex.api.model.user.UserCredentials;

@Entity
public class Administrator 
{
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
	
	@Column
    private String firstname;
	@Column
    private String lastname;
	@Column
    private String photoUrl;
	@Column
    private String phone;
	@Basic
    private java.sql.Timestamp joiningDate;
	
	@OneToOne(fetch = FetchType.EAGER)
 	@JoinColumn(name = "company_id", nullable = false) 
    private Company company;
	
	@OneToOne(fetch = FetchType.EAGER)
 	@JoinColumn(name = "user_id", nullable = false) 
    private UserCredentials user;
}
