package edu.colostate.cs.cs414.project.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	
	//@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Set<FitnessClass> fitnessClasses;
	
	private String workHours;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qualifications == null) ? 0 : qualifications.hashCode());
		result = prime * result + ((userAccount == null) ? 0 : userAccount.hashCode());
		result = prime * result + ((userInformation == null) ? 0 : userInformation.hashCode());
		result = prime * result + ((workHours == null) ? 0 : workHours.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qualifications == null) {
			if (other.qualifications != null)
				return false;
		} else if (!qualifications.equals(other.qualifications))
			return false;
		if (userAccount == null) {
			if (other.userAccount != null)
				return false;
		} else if (!userAccount.equals(other.userAccount))
			return false;
		if (userInformation == null) {
			if (other.userInformation != null)
				return false;
		} else if (!userInformation.equals(other.userInformation))
			return false;
		if (workHours == null) {
			if (other.workHours != null)
				return false;
		} else if (!workHours.equals(other.workHours))
			return false;
		return true;
	}

	private String qualifications;

	public Trainer(){
	
		this.userInformation = new UserInformation();
		
	}
	
	public Trainer(String id){
		this.id = id;
		
		this.userInformation = new UserInformation();
	}
	
	public void addNames(String firstName, String lastName){
		
		this.userInformation.addNames(firstName, lastName);
		
	}
	
	public void addAddress(String address1, String address2, String city, String state,String zip){
		this.userInformation.addAddress(new Address(address1, address2, city, state, zip));
	}
	
	public void addPhone(String phone){
		this.userInformation.addPhone(new Phone(phone, ""));
	}
	
	public void addEmail(String email){
		this.userInformation.addEmail(new Email(email, ""));
	}
	
	public void addHealthInsuranceProvider(String healthInsuranceProvider){
		this.userInformation.addHealthInsuranceProvider(new HealthInsuranceProvider(healthInsuranceProvider));	
	}
	
	public void addHealthInsuranceProvider(HealthInsuranceProvider healthInsuranceProvider){
		this.userInformation.addHealthInsuranceProvider(healthInsuranceProvider);	
	}
	
	public void addUsernamePassword(String username, String password){
		this.userAccount = new UserAccount(username, password);
	}
	
	public void addWorkHours(String workHours){
		this.workHours = workHours;
	}
	
	public void addQualifications(String qualifications){
		this.qualifications = qualifications;
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
