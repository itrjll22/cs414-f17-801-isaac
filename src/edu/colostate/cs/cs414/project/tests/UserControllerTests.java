package edu.colostate.cs.cs414.project.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import edu.colostate.cs.cs414.project.controllers.UserController;
import edu.colostate.cs.cs414.project.models.*;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;

public class UserControllerTests {

	UserController userController;
	HibernatePersistenceService dao;
	
	@Before
	public void setUp(){
		
		userController = UserController.getInstance();
		
		dao = HibernatePersistenceService.getInstance();
		
	}
	

	
	@Test
	public void testAddTrainer() {
		Trainer trainer = null;
		
		try {
		
		UserAccount ua = new UserAccount("RandomUsername", "password123");
		
		UserInformation userInfo = new UserInformation(
				"Isaac", "Trujillo",
				new Phone("555-555-5555", "mobile"),
				new Email("randomuser@randomdomain.com", "personal"),
				new Address("123 Some Place", "", "Albuquerque", "NM", "87125"),
				new HealthInsuranceProvider("Blue Cross Blue Shield"));
				
		
		trainer = new Trainer(ua, userInfo);
		
		assertEquals(true, userController.hireTrainer(trainer).isSuccess);
		
		Trainer t = dao.getTrainer(trainer.getId());
		
		assertEquals(t.getId(), trainer.getId());
		}
		finally{
		
			dao.deleteTrainer(trainer);
		}
	}
	
		
	@Test
	public void testModifyTrainer() {
		
		List<Trainer> trainers = UserController.getInstance().getTrainers();
 	
		Trainer t1 = trainers.get(0);
		t1.getUserInformation().setFirstName("asdfasdfasdfasdf");
		
		String t1Id = t1.getId();
		
		assertEquals(userController.modifyTrainer(t1).isSuccess, true);
		
		trainers = UserController.getInstance().getTrainers();
		
		Trainer modifiedTrainer = null;
		
		for(Trainer t : trainers){
			if(t.getId().equalsIgnoreCase(t1Id)){
				modifiedTrainer = t;
			}
		}
		
		assertEquals(modifiedTrainer != null, true);
		
		assertEquals(modifiedTrainer.getUserInformation().getFirstName().equalsIgnoreCase("asdfasdfasdfasdf"), true);
		
	}
	
		
	@Test
	public void testAddCustomer() {
		UserAccount ua = new UserAccount("customerUsername", "asdsdasd");
		
		UserInformation userInfo = new UserInformation(
				"Isaac", "Trujillo",
				new Phone("555-555-4444", "mobile"),
				new Email("customerUsername@randomdomain.com", "personal"),
				new Address("123 Another Place", "", "Albuquerque", "NM", "87125"),
				new HealthInsuranceProvider("Blue Cross Red Shield"));
				
		
		Customer customer = new Customer(ua, userInfo);
		
		assertEquals(true,userController.registerCustomer(customer).isSuccess);
		
		Customer c = dao.getCustomer(customer.getId());
		
		assertEquals(c.getId(), customer.getId());
	}

}
