package edu.colostate.cs.cs414.project.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Exercise {
	
	@Id
	private String id;
	
	private String name;
	
	private String duration;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<EquipmentItem> equipmentItems;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ExerciseSet> exerciseSets;
	
	public Exercise(){
		this.id = java.util.UUID.randomUUID().toString();
	}
	
	public Exercise(String name){
		
		this.id = java.util.UUID.randomUUID().toString();
		this.name = name;
		
		
	}
	
	/*
	public Exercise(String name, String duration, Set<EquipmentItem> equipmentItems, Set<ExerciseSet> exerciseSets){
		
		this.id = java.util.UUID.randomUUID().toString();
		this.name = name;
		this.duration = duration;
		this.equipmentItems = equipmentItems;
		this.exerciseSets = exerciseSets;
		
	}
*/
	public void addName(String name){
		this.name = name;
	}
	
	public void addDuration(String duration){
		this.duration = duration;
	}
	
	public void addEquipmentItems(Set<EquipmentItem> equipmentItems){
		this.equipmentItems = equipmentItems;
	}
	
	public void addExerciseSets(Set<ExerciseSet> exerciseSets){
		this.exerciseSets = exerciseSets;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<EquipmentItem> getEquipmentItems() {
		return equipmentItems;
	}

	public void setEquipmentItems(Set<EquipmentItem> equipmentItems) {
		this.equipmentItems = equipmentItems;
	}

	public Set<ExerciseSet> getExerciseSets() {
		return exerciseSets;
	}

	public void setExerciseSets(Set<ExerciseSet> exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((equipmentItems == null) ? 0 : equipmentItems.hashCode());
		result = prime * result + ((exerciseSets == null) ? 0 : exerciseSets.hashCode());
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
		Exercise other = (Exercise) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (equipmentItems == null) {
			if (other.equipmentItems != null)
				return false;
		} else if (!equipmentItems.equals(other.equipmentItems))
			return false;
		if (exerciseSets == null) {
			if (other.exerciseSets != null)
				return false;
		} else if (!exerciseSets.equals(other.exerciseSets))
			return false;
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
