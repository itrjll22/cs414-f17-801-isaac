package edu.colostate.cs.cs414.project.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class WorkoutRoutine {
	
	@Id
	private String id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Exercise> exercises;
	
	public WorkoutRoutine(){
		
	}
	
	
}
