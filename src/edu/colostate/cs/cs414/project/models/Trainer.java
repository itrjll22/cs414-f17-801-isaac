package edu.colostate.cs.cs414.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Trainer {

	@Id
	@Column(nullable = false, unique=true)
	@NotBlank
	private String id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private UserAccount userAccount;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private UserInformation userInformation;
	
	private String workHours;
	
	private String qualifications;

	public Trainer(){
		
	}
	
	public Trainer(String firstName, String lastName, String address1, String address2, String city, String state,
			String zip, String phone, String email, String id, String healthInsuranceProvider, String workHours,
			String qualifications, String username, String password){
		
		UserAccount ua = new UserAccount(username, password);
		
		UserInformation userInfo = new UserInformation();
		userInfo.addNames(firstName, lastName);
		userInfo.addPhone(new Phone(phone, ""));
		userInfo.addEmail(new Email(email, ""));
		userInfo.addAddress(new Address(address1, address2, city, state, zip));
		userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider(healthInsuranceProvider));	
		
		this.userAccount = ua;
		this.userInformation = userInfo;
		
		this.workHours = workHours;
		this.qualifications = qualifications;
		
		this.id = id;
	}
	
	public Trainer(String firstName, String lastName, String address1, String address2, String city, String state,
			String zip, String phone, String email, String id, HealthInsuranceProvider healthInsuranceProvider, String workHours,
			String qualifications, String username, String password){
		
		UserAccount ua = new UserAccount(username, password);
		
		UserInformation userInfo = new UserInformation();
		userInfo.addNames(firstName, lastName);
		userInfo.addPhone(new Phone(phone, ""));
		userInfo.addEmail(new Email(email, ""));
		userInfo.addAddress(new Address(address1, address2, city, state, zip));
		userInfo.addHealthInsuranceProvider(healthInsuranceProvider);	
		
		this.userAccount = ua;
		this.userInformation = userInfo;
		
		this.workHours = workHours;
		this.qualifications = qualifications;
		
		this.id = id;
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

	@Override
	public String toString() {
		return this.userInformation.getFirstName() + " " + this.userInformation.getLastName();
	}

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	
	
}
