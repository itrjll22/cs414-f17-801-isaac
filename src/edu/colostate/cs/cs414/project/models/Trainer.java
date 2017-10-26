package edu.colostate.cs.cs414.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Trainer {

	@Id
	private String id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private UserAccount userAccount;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private UserInformation userInformation;

	public Trainer(){
		
	}
	
	public Trainer(UserAccount userAccount, UserInformation userInformation){
		
		this.id = java.util.UUID.randomUUID().toString();
		
		this.userAccount = userAccount;
		this.userInformation = userInformation;
		
	}
	
	public Trainer(String id, UserAccount userAccount, UserInformation userInformation){
		
		this.id = id;
		
		this.userAccount = userAccount;
		this.userInformation = userInformation;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}
	
}
