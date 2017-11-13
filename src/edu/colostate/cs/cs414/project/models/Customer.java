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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<WorkoutRoutine> workoutRoutines;
	
	

	public Customer(){
			
	}
	
	public Customer(String firstName, String lastName, String address1, String address2, String city, String state,
			String zip, String phone, String email, String id, String healthInsuranceProvider, boolean isActive, 
			String username, String password){
		
		UserAccount ua = new UserAccount(username, password);
		
		UserInformation userInfo = new UserInformation(
				firstName, lastName,
				new Phone(phone, ""),
				new Email(email, ""),
				new Address(address1, address2, city, state, zip),
				new HealthInsuranceProvider(healthInsuranceProvider));
		
		this.userAccount = ua;
		this.userInformation = userInfo;
		
		this.isActive = isActive;
		
		this.id = id;
	}
	
	public Customer(String firstName, String lastName, String address1, String address2, String city, String state,
			String zip, String phone, String email, String id, HealthInsuranceProvider healthInsuranceProvider, boolean isActive, 
			String username, String password){
		
		UserAccount ua = new UserAccount(username, password);
		
		UserInformation userInfo = new UserInformation(
				firstName, lastName,
				new Phone(phone, ""),
				new Email(email, ""),
				new Address(address1, address2, city, state, zip),
				healthInsuranceProvider);
		
		this.userAccount = ua;
		this.userInformation = userInfo;
		
		this.isActive = isActive;
		
		this.id = id;
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
	
	
}
