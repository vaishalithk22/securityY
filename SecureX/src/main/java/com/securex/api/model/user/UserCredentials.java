package com.securex.api.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.securex.api.model.admindispatcher.Admin;
//import com.securex.api.model.customer.Customer;
//import com.securex.api.model.guard.Guard;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usercredentials")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
  
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private Set<Role> roles;
    
//    @OneToOne(fetch = FetchType.EAGER,
//            cascade =  CascadeType.ALL,
//            mappedBy = "user")
//    private Customer customer;

//    @OneToOne(fetch = FetchType.EAGER,
//            cascade =  CascadeType.ALL,
//            mappedBy = "user")
//    private Guard guard;
//    
//    @OneToOne(fetch = FetchType.EAGER,
//            cascade =  CascadeType.ALL,
//            mappedBy = "user")
//    private Admin admin;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
