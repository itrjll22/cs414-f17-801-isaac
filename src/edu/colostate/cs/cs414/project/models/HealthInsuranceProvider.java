package edu.colostate.cs.cs414.project.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class HealthInsuranceProvider {

	@Id
	private String id;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "healthInsuranceProvider", cascade = CascadeType.ALL)
	@JoinColumn(name = "userInformation_id")
	private UserInformation userInformation;
	
	private String name;
	
	public HealthInsuranceProvider(){
		
	}
	
	public HealthInsuranceProvider(String name){
		this.id = java.util.UUID.randomUUID().toString();
		this.name = name;
	}
	
	public HealthInsuranceProvider(String id, String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		HealthInsuranceProvider other = (HealthInsuranceProvider) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}