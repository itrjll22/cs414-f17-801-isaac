package edu.colostate.cs.cs414.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class UserInformation {
	
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "trainer_id")
	Trainer trainer;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "manager_id")
	Manager manager;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")
	private Phone phone;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "email_id")
	private Email email;
	
	@OneToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinColumn(name = "healthInsuranceProvider_id")
	private HealthInsuranceProvider healthInsuranceProvider;
	
	public UserInformation(){
		this.id = java.util.UUID.randomUUID().toString();
	}
	
	public UserInformation(String id){
		this.id = id;
	}
	/*
	public UserInformation(String firstName, String lastName, Phone phone, Email email, Address address, HealthInsuranceProvider healthInsuranceProvider){
		
		this.id = java.util.UUID.randomUUID().toString();
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.healthInsuranceProvider = healthInsuranceProvider;
		
	}
	
	
	public UserInformation(String id, String firstName, String lastName, Phone phone, Email email, Address address, HealthInsuranceProvider healthInsuranceProvider){
		
		this.id = id;
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.healthInsuranceProvider = healthInsuranceProvider;
		
	}
*/
	
	public void addNames(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void addPhone(Phone phone){
		this.phone = phone;
	}

	public void addEmail(Email email){
		this.email = email;
	}
	
	public void addAddress(Address address){
		this.address = address;
	}
	
	public void addHealthInsuranceProvider(HealthInsuranceProvider healthInsuranceProvider){
		this.healthInsuranceProvider = healthInsuranceProvider;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((healthInsuranceProvider == null) ? 0 : healthInsuranceProvider.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		UserInformation other = (UserInformation) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (healthInsuranceProvider == null) {
			if (other.healthInsuranceProvider != null)
				return false;
		} else if (!healthInsuranceProvider.equals(other.healthInsuranceProvider))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Phone getPhone() {
		return phone;
	}


	public void setPhone(Phone phone) {
		this.phone = phone;
	}


	public Email getEmail() {
		return email;
	}


	public void setEmail(Email email) {
		this.email = email;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public HealthInsuranceProvider getHealthInsuranceProvider() {
		return healthInsuranceProvider;
	}


	public void setHealthInsuranceProvider(HealthInsuranceProvider healthInsuranceProvider) {
		this.healthInsuranceProvider = healthInsuranceProvider;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
