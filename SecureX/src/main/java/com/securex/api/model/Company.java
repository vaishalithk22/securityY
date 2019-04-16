package com.securex.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Company 
{
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
	 @Column
	    private String name;
	 @OneToMany(fetch = FetchType.EAGER,
	            cascade =  CascadeType.ALL,
	            mappedBy = "company")
	    private Set<Guard> guards;
	 
	 @OneToOne(fetch = FetchType.EAGER,
	            cascade =  CascadeType.ALL,
	            mappedBy = "company")
	    private Administrator admin;
//	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	    @JoinTable(name = "GUARDS_COMPANY", joinColumns = {
//	            @JoinColumn(name = "GUARD_ID") }, inverseJoinColumns = {
//	            @JoinColumn(name = "COMPANY_ID") })
//	    private Set<Guard> guards;
}
