package edu.colostate.cs.cs414.project.models;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	private String id;
	private boolean isActive;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private UserAccount userAccount;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private UserInformation userInformation;

	public Customer(){
			
	}
	
	public Customer(UserAccount userAccount, UserInformation userInformation){
		
		this.id = java.util.UUID.randomUUID().toString();
		this.isActive = true;
		
		this.userAccount = userAccount;
		this.userInformation = userInformation;
		
	}
	
	public Customer(String id, UserAccount userAccount, UserInformation userInformation){
		
		this.id = id;
		this.isActive = true;
		
		this.userAccount = userAccount;
		this.userInformation = userInformation;
		
	}
	
	public Customer(String id, boolean isActive,UserAccount userAccount, UserInformation userInformation){
		
		this.id = id;
		this.isActive = isActive;
		
		this.userAccount = userAccount;
		this.userInformation = userInformation;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
