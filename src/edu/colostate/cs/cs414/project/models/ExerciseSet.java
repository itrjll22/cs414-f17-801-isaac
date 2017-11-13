package edu.colostate.cs.cs414.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExerciseSet {
	
	@Id
	private String id;
	
	String name;
	
	int repititions;
	
	public ExerciseSet(){
		
	}
	
	public ExerciseSet(String name, int repititions){
		
		this.id = java.util.UUID.randomUUID().toString();
		
		this.name = name;
		this.repititions = repititions;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRepititions() {
		return repititions;
	}

	public void setRepititions(int repititions) {
		this.repititions = repititions;
	}

	@Override
	public String toString() {
		return name + ", repititions:" + repititions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + repititions;
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
		ExerciseSet other = (ExerciseSet) obj;
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
		if (repititions != other.repititions)
			return false;
		return true;
	}

}
