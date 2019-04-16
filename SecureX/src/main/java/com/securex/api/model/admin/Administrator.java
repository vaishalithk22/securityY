package com.securex.api.model.admin;

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
    private String photourl;
	@Column
    private String phone;
	@Basic
    private java.sql.Timestamp joiningdate;
	
	@OneToOne(fetch = FetchType.EAGER)
 	@JoinColumn(name = "company_id", nullable = false) 
    private Company company;
	
	@OneToOne(fetch = FetchType.EAGER)
 	@JoinColumn(name = "user_id", nullable = false) 
    private UserCredentials user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhotoUrl() {
		return photourl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photourl = photoUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.sql.Timestamp getJoiningDate() {
		return joiningdate;
	}

	public void setJoiningDate(java.sql.Timestamp joiningDate) {
		this.joiningdate = joiningDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public UserCredentials getUser() {
		return user;
	}

	public void setUser(UserCredentials user) {
		this.user = user;
	}
	
	
}
