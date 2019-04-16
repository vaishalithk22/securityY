package com.securex.api.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.securex.api.model.user.UserCredentials;

@Entity
public class Customer 
{
	 @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private long id;
	 @OneToOne(fetch = FetchType.EAGER)
	 	@JoinColumn(name = "user_id", nullable = false) 
	    private UserCredentials user;
	 @Column
	    private String firstname;
	 @Column
	    private String lastname;
	 @Column
	    private String street1;
	 @Column
	    private String street2;
	 @Column
	    private String city;
	 @Column
	    private String state;
	 @Column
	    private String country;
	 @Column
	    private String zipcode;
	 @Column
	    private String phone;
	 @Column
	    private String photourl;
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserCredentials getUser() {
		return user;
	}
	public void setUser(UserCredentials user) {
		this.user = user;
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
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	 
	 
}
