package com.securex.api.model.user;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String description;
    
//    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
//    private List<UserCredentials> users;
    
    
    
    public Role(long id, String name, String description) {
		
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Role() {
	super();
}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
