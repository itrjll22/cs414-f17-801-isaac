package edu.colostate.cs.cs414.project.persistence;

import java.util.ArrayList;
import java.util.List;

import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.EquipmentItem;
import edu.colostate.cs.cs414.project.models.Exercise;
import edu.colostate.cs.cs414.project.models.ExerciseSet;
import edu.colostate.cs.cs414.project.models.FitnessClass;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;
import edu.colostate.cs.cs414.project.models.WorkoutRoutine;

public interface IPersistenceService {

	public boolean addTrainer(Trainer trainer);
	
	public boolean editTrainer(Trainer trainer);
	
	public boolean deleteTrainer(Trainer trainer);
	
	public boolean addManager(Manager manager);
	
	public boolean addCustomer(Customer customer);
	
	public Trainer getTrainer(String id);
	
	public List<HealthInsuranceProvider> getHealthInsuranceProviders();
	
	public boolean addEquipmentItem(EquipmentItem equipmentItem);
	
	public List<Trainer> getTrainers();
	
	public List<Customer> getCustomers();
	
	public List<EquipmentItem> getEquipmentItems();
	
	public List<ExerciseSet> getExerciseSets();
	
	public boolean addExerciseSet(ExerciseSet exerciseSet);
	
	public boolean addExercise(Exercise exercise);
	
	public List<Exercise> getExercises();
	
	public boolean addWorkoutRoutine(WorkoutRoutine workoutRoutine);
	
	public List<WorkoutRoutine> getWorkoutRoutines();
	
	public List<Customer> searchCustomers(String searchTerm);
	
	public List<WorkoutRoutine> searchWorkoutRoutines(String searchTerm);
	
	public UserAccount getUserAccount(String username);
	
	public List<Trainer> searchTrainers(String searchTerm);
	
	public List<EquipmentItem> searchEquipmentItems(String searchTerm);
	
	public boolean addFitnessClass(FitnessClass fitnessClasss);
	
	public List<FitnessClass> getFitnessClasses();
}
