package edu.colostate.cs.cs414.project.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	private String Id;
	
	private String name;
	
	@ManyToMany
	private Set<UserAccount> userAccounts;
	
}
