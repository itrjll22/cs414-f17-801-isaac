package edu.colostate.cs.cs414.project.models;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer implements ISearchable {
	
	@Id
	private String id;
	private boolean isActive;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private UserAccount userAccount;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private UserInformation userInformation;

	

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<WorkoutRoutine> workoutRoutines;
	
	//@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Set<FitnessClass> fitnessClasses;

	public Customer(){
			
	}
	
	public Customer(String id){
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
	
	public void setIsActive(boolean isActive){
		this.isActive = isActive;
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

	public Set<WorkoutRoutine> getWorkoutRoutines() {
		return workoutRoutines;
	}

	public void setWorkoutRoutines(Set<WorkoutRoutine> workoutRoutines) {
		this.workoutRoutines = workoutRoutines;
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

	@Override
	public String toString() {
		return this.userInformation.getFirstName() + " " + this.userInformation.getLastName();
	}

	@Override
	public String getSearchCriteria() {
		// TODO Auto-generated method stub
		return "name";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Customer";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((userAccount == null) ? 0 : userAccount.hashCode());
		result = prime * result + ((userInformation == null) ? 0 : userInformation.hashCode());
		result = prime * result + ((workoutRoutines == null) ? 0 : workoutRoutines.hashCode());
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
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
		if (workoutRoutines == null) {
			if (other.workoutRoutines != null)
				return false;
		} else if (!workoutRoutines.equals(other.workoutRoutines))
			return false;
		return true;
	}
	
}
