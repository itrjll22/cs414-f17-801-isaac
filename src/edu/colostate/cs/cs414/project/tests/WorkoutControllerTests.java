package edu.colostate.cs.cs414.project.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import edu.colostate.cs.cs414.project.controllers.UserController;
import edu.colostate.cs.cs414.project.controllers.WorkoutController;
import edu.colostate.cs.cs414.project.models.Address;
import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.Email;
import edu.colostate.cs.cs414.project.models.EquipmentItem;
import edu.colostate.cs.cs414.project.models.Exercise;
import edu.colostate.cs.cs414.project.models.ExerciseSet;
import edu.colostate.cs.cs414.project.models.FitnessClass;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Phone;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;
import edu.colostate.cs.cs414.project.models.UserInformation;
import edu.colostate.cs.cs414.project.models.WorkoutRoutine;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;
import edu.colostate.cs.cs414.project.utilities.TestUtility;

public class WorkoutControllerTests {

	WorkoutController wc;
	HibernatePersistenceService dao;
	TestUtility testUtility;
	Customer customer;
	Trainer trainer;
	
	
	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	@Before
	public void setUp(){
		
		wc = new WorkoutController();
		dao = HibernatePersistenceService.getInstance();
		testUtility = new TestUtility();
		
		UserAccount ua1 = new UserAccount(testUtility.getPseudoRandomString(), "asdsdasd");
		
		UserInformation userInfo1 = new UserInformation();
		userInfo1.addNames("Heather", "Beyers");
		userInfo1.addPhone(new Phone("555-555-3333", "mobile"));
		userInfo1.addEmail(new Email("hb@test.com", "personal"));
		userInfo1.addAddress(new Address("112 1st Street NE", "", "Denver", "CO", "80921"));
		userInfo1.addHealthInsuranceProvider(new HealthInsuranceProvider(testUtility.getPseudoRandomString()));
		
		trainer = new Trainer(ua1, userInfo1);
		
		HashSet<Trainer> trainers = new HashSet<Trainer>();
		trainers.add(trainer);
		
		dao.addTrainer(trainer);
		
		UserAccount ua = new UserAccount(testUtility.getPseudoRandomString(), "asdsdasd");
		
		UserInformation userInfo = new UserInformation();
		userInfo.addNames("Janet", "Smith");
		userInfo.addPhone(new Phone("555-555-4444", "mobile"));
		userInfo.addEmail(new Email("jsmith@test.com", "personal"));
		userInfo.addAddress(new Address("234 54th Street NE", "", "Albuquerque", "NM", "87125"));
		userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider(testUtility.getPseudoRandomString()));
		
		Customer customer = new Customer(ua, userInfo);
		

		dao.addCustomer(customer);
		
		
	}
	
	@After
	public void tearDown() {
		dao.deleteCustomer(customer);
		dao.deleteTrainer(trainer);
	}
	
	
	@Test
	public void testAddEquipmentItem() {

		EquipmentItem t = null;
		
		try {
			
			t = new EquipmentItem("Treadmill", 32, folder.newFile("test.jpg"));
			
			assertEquals(wc.addEquipmentItem(t).isSuccess, true);
			
			boolean tFound = false;
			
			for(EquipmentItem e : dao.getEquipmentItems()){
				if(e.getId().equalsIgnoreCase(t.getId())){
					tFound = true;
				}
			}
			
			assertEquals(tFound, true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.deleteEquipmentItem(t);
		}
		
	}
	
	
	@Test
	public void testAddExerciseSet() {
		
		ExerciseSet t = null;
		
		try {
			t = new ExerciseSet("Bench Press 135 lbs.", 20);
			
			assertEquals(wc.addExerciseSet(t).isSuccess, true);
			
			boolean tFound = false;
			
			for(ExerciseSet e : wc.getExerciseSets()){
				if(e.getId().equalsIgnoreCase(t.getId())){
					tFound = true;
				}
			}
			
			assertEquals(tFound, true);
		}
		finally{
			dao.deleteExerciseSet(t);
			
		}
		
	}
	
	@Test
	public void testAddExercise() {
		
		Exercise t = null;
		
		try {
			
			Set<EquipmentItem> equipmentItems = new HashSet<EquipmentItem>();
			equipmentItems.add(new EquipmentItem("Treadmill", 32, folder.newFile("test.jpg")));
			equipmentItems.add(new EquipmentItem("StairClimber", 12, folder.newFile("sc.jpg")));
			
			Set<ExerciseSet> exerciseSets = new HashSet<ExerciseSet>();
			exerciseSets.add(new ExerciseSet("Bench Press 135 lbs.", 20));
			exerciseSets.add(new ExerciseSet("Plank 5 minutes.", 4));
			
			
			t = new Exercise("Insanityx2");
			t.addDuration("90 minutes");
			t.addEquipmentItems(equipmentItems);
			t.addExerciseSets(exerciseSets);
			
			assertEquals(wc.addExercise(t).isSuccess, true);
			
			boolean tFound = false;
			
			for(Exercise e : wc.getExercises()){
				if(e.getId().equalsIgnoreCase(t.getId())){
					tFound = true;
				}
			}
			
			assertEquals(tFound, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			dao.deleteExercise(t);
			
		}
		
	}
	
	@Test
	public void testAddWorkoutRoutine() {
		
		 WorkoutRoutine wr = null;
		
		try {
			
			Set<EquipmentItem> equipmentItems = new HashSet<EquipmentItem>();
			equipmentItems.add(new EquipmentItem("Treadmill", 32, folder.newFile("test.jpg")));
			equipmentItems.add(new EquipmentItem("StairClimber", 12, folder.newFile("sc.jpg")));
			
			Set<ExerciseSet> exerciseSets = new HashSet<ExerciseSet>();
			exerciseSets.add(new ExerciseSet("Bench Press 135 lbs.", 20));
			exerciseSets.add(new ExerciseSet("Plank 5 minutes.", 4));
			
			Set<Exercise> exercises = new HashSet<Exercise>();

			Exercise t = new Exercise("Insanityx2");
			t.addDuration("90 minutes");
			t.addEquipmentItems(equipmentItems);
			t.addExerciseSets(exerciseSets);
			exercises.add(t);
			
			
			wr = new WorkoutRoutine("Advanced", exercises);
			
			assertEquals(wc.addWorkoutRoutine(wr).isSuccess, true);
			
			boolean tFound = false;
			
			for(WorkoutRoutine e : wc.getWorkoutRoutines()){
				if(e.getId().equalsIgnoreCase(wr.getId())){
					tFound = true;
				}
			}
			
			assertEquals(tFound, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			dao.deleteWorkoutRoutine(wr);
			
		}
		
	}
	
	@Test
	public void testAssignWorkoutRoutine() {
		
		 WorkoutRoutine wr = null;
		Customer customer = null;
		 
		try {
			
			UserAccount ua = new UserAccount(testUtility.getPseudoRandomString(), "asdsdasd");
			
			UserInformation userInfo = new UserInformation();
			userInfo.addNames("Isaac", "Trujillo");
			userInfo.addPhone(new Phone("555-555-4444", "mobile"));
			userInfo.addEmail(new Email("dfgfdg@rasdf.com", "personal"));
			userInfo.addAddress(new Address("453 5th Street NE", "", "Albuquerque", "NM", "87125"));
			userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider(testUtility.getPseudoRandomString()));
			
			customer = new Customer(ua, userInfo);
			
			UserController.getInstance().registerCustomer(customer);
			
			Set<EquipmentItem> equipmentItems = new HashSet<EquipmentItem>();
			equipmentItems.add(new EquipmentItem("Treadmill", 32, folder.newFile("test.jpg")));
			equipmentItems.add(new EquipmentItem("StairClimber", 12, folder.newFile("sc.jpg")));
			
			Set<ExerciseSet> exerciseSets = new HashSet<ExerciseSet>();
			exerciseSets.add(new ExerciseSet("Bench Press 135 lbs.", 20));
			exerciseSets.add(new ExerciseSet("Plank 5 minutes.", 4));
			
			Set<Exercise> exercises = new HashSet<Exercise>();
			Exercise t = new Exercise("Insanityx2");
			t.addDuration("90 minutes");
			t.addEquipmentItems(equipmentItems);
			t.addExerciseSets(exerciseSets);
			exercises.add(t);
			
			wr = new WorkoutRoutine("Advanced", exercises);
			
			wc.addWorkoutRoutine(wr);
			
			Set<WorkoutRoutine> workoutRoutines = new HashSet<WorkoutRoutine>();
			
			workoutRoutines.add(wr);
			
			assertEquals(wc.assignWorkoutRoutines(customer, workoutRoutines).isSuccess, true);
			
			
			assertEquals(dao.getCustomer(customer.getId()).getWorkoutRoutines().size() > 0, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			dao.deleteWorkoutRoutine(wr);
			dao.deleteCustomer(customer);
		
		}
		
	}
	
	
	@Test
	public void testSearchWorkoutRoutines() {
		
		 WorkoutRoutine wr = null;
		
		 
		try {
			
			
			Set<EquipmentItem> equipmentItems = new HashSet<EquipmentItem>();
			equipmentItems.add(new EquipmentItem("Treadmill", 32, folder.newFile("test.jpg")));
			equipmentItems.add(new EquipmentItem("StairClimber", 12, folder.newFile("sc.jpg")));
			
			Set<ExerciseSet> exerciseSets = new HashSet<ExerciseSet>();
			exerciseSets.add(new ExerciseSet("Bench Press 135 lbs.", 20));
			exerciseSets.add(new ExerciseSet("Plank 5 minutes.", 4));
			
			Set<Exercise> exercises = new HashSet<Exercise>();
			Exercise t = new Exercise("Insanityx2");
			t.addDuration("90 minutes");
			t.addEquipmentItems(equipmentItems);
			t.addExerciseSets(exerciseSets);
			exercises.add(t);
			
			wr = new WorkoutRoutine("Advanced", exercises);
			
			wc.addWorkoutRoutine(wr);
			boolean tFound = false;
			
			for(WorkoutRoutine e : wc.searchWorkoutRoutines("Advanced")){
				if(e.getId().equalsIgnoreCase(wr.getId())){
					tFound = true;
				}
			}
			
			assertEquals(tFound, true);
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			dao.deleteWorkoutRoutine(wr);
		
		}
		
	}
	
	
	@Test
	public void testSearchEquipmentItem() {

		EquipmentItem t = null;
		
		try {
			
			t = new EquipmentItem("Stairmaster", 12, folder.newFile("test.jpg"));
			
			assertEquals(wc.addEquipmentItem(t).isSuccess, true);
			
			boolean tFound = false;
			
			for(EquipmentItem e : dao.searchEquipmentItems("stairmaster")){
				if(e.getId().equalsIgnoreCase(t.getId())){
					tFound = true;
				}
			}
			
			assertEquals(tFound, true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.deleteEquipmentItem(t);
		}
		
	}

	
	@Test
	public void testAddFitnessClass() {
		
		 FitnessClass fc = null;
		
		try {
			
			
			HashSet<Trainer> trainers = new HashSet<Trainer>();
			HashSet<Customer> customers = new HashSet<Customer>();
					
			List c = dao.getCustomers();
			List t = dao.getTrainers();
			
			trainers.add((Trainer) t.get(0));
			
			customers.add((Customer) c.get(0));
			
			
			fc = new FitnessClass("Yoga", "MWF 5-8pm", trainers, customers);
			
			
			assertEquals(wc.addFitnessClass(fc).isSuccess, true);
			
			boolean tFound = false;
			
			for(FitnessClass e : wc.getFitnessClasses()){
				if(e.getId().equalsIgnoreCase(fc.getId())){
					tFound = true;
				}
			}
			
			assertEquals(tFound, true);
		}
		finally{
			dao.deleteFitnessClass(fc);
		}
	}
	
	@Test
	public void testModifyFitnessClass() {
		
		 FitnessClass fc = null;
		
		try {
			
			
			HashSet<Trainer> trainers = new HashSet<Trainer>();
			HashSet<Customer> customers = new HashSet<Customer>();
					
			List c = dao.getCustomers();
			List t = dao.getTrainers();
			
			trainers.add((Trainer) t.get(0));
			
			customers.add((Customer) c.get(0));
			
			
			fc = new FitnessClass("Yogs", "MWF 8-9pm", trainers, customers);
			
			
			assertEquals(wc.addFitnessClass(fc).isSuccess, true);
			
			boolean tFound = false;
			
			FitnessClass fcToModify = null;
			
			for(FitnessClass e : wc.getFitnessClasses()){
				if(e.getId().equalsIgnoreCase(fc.getId())){
					tFound = true;
					fcToModify = e;
				}
			}
			
			assertEquals(tFound, true);
			
			assertNotEquals(fcToModify,null );
			
			
			fcToModify.setName("Zumba");
			fcToModify.setSchedule("T-Th 4-5pm");
			
			assertEquals(wc.addFitnessClass(fcToModify).isSuccess, true);
			
			for(FitnessClass e : wc.getFitnessClasses()){
				if(e.getId().equalsIgnoreCase(fcToModify.getId())){
					assertEquals(e.getName(), fcToModify.getName());
					assertEquals(e.getSchedule(), fcToModify.getSchedule());
				}
			}
		}
		finally{
			dao.deleteFitnessClass(fc);
			
		}
		
	}
	
}
