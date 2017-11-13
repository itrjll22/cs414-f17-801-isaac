package edu.colostate.cs.cs414.project.controllers;

import java.util.List;

import edu.colostate.cs.cs414.project.models.Address;
import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.Email;
import edu.colostate.cs.cs414.project.models.EquipmentItem;
import edu.colostate.cs.cs414.project.models.Exercise;
import edu.colostate.cs.cs414.project.models.ExerciseSet;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Phone;
import edu.colostate.cs.cs414.project.models.Response;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;
import edu.colostate.cs.cs414.project.models.UserInformation;
import edu.colostate.cs.cs414.project.models.WorkoutRoutine;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;

public class WorkoutController {

	HibernatePersistenceService dao = HibernatePersistenceService.getInstance();
	
	public WorkoutController(){
		
		try{
		
			
		
		
			}catch(Exception ex){
				
			}
		
	}
	
	public Response addEquipmentItem(EquipmentItem equipmentItem){
		
		Response response = new Response();
		response.StatusText = "Add Equipment Item unsuccessful.";
		
		if(dao.addEquipmentItem(equipmentItem)){
			response.isSuccess = true;
			response.StatusText = "Add Equipment Item success!";
		}
		
		return response;
		
	}
	
	public Response addExerciseSet(ExerciseSet exerciseSet){
		
		Response response = new Response();
		response.StatusText = "Add ExerciseSet unsuccessful.";
		
		if(dao.addExerciseSet(exerciseSet)){
			response.isSuccess = true;
			response.StatusText = "Add ExerciseSet success!";
		}
		
		return response;
		
	}
	
	public Response addExercise(Exercise exercise){
		
		Response response = new Response();
		response.StatusText = "Add Exercise unsuccessful.";
		
		if(dao.addExercise(exercise)){
			response.isSuccess = true;
			response.StatusText = "Add Exercise success!";
		}
		
		return response;
		
	}
	
	public Response addWorkoutRoutine(WorkoutRoutine workoutRoutine){
		
		Response response = new Response();
		response.StatusText = "Add WorkoutRoutine unsuccessful.";
		
		if(dao.addWorkoutRoutine(workoutRoutine)){
			response.isSuccess = true;
			response.StatusText = "Add WorkoutRoutine success!";
		}
		
		return response;
		
	}
	
	public List<EquipmentItem> getEquipmentItems(){
		
		return dao.getEquipmentItems();
		
	}
	
	public List<ExerciseSet> getExerciseSets(){
		
		return dao.getExerciseSets();
		
	}
	
	public List<Exercise> getExercises(){
		
		return dao.getExercises();
		
	}
	
	public List<WorkoutRoutine> getWorkoutRoutines(){
		
		return dao.getWorkoutRoutines();
		
	}
	
}
