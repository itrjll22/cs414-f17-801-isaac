package edu.colostate.cs.cs414.project.tests;

import static org.junit.Assert.*;


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
		
		userController = new UserController();
		
		dao = new HibernatePersistenceService();
		
	}
	
	@Test
	public void testAddTrainer() {
		Trainer trainer = null;
		
		try {
		
		UserAccount ua = new UserAccount("RandomUsername", "password123");
		
		UserInformation userInfo = new UserInformation(
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
	
		/*
	@Test
	public void testModifyTrainer() {
		
		UserAccount ua = new UserAccount("RandomUsername", "password123");
		
		UserInformation userInfo = new UserInformation(
				new Phone("555-555-5555", "mobile"),
				new Email("randomuser@randomdomain.com", "personal"),
				new Address("123 Some Place", "", "Albuquerque", "NM", "87125"),
				new HealthInsuranceProvider("Blue Cross Blue Shield"));
				
		
		Trainer trainer = new Trainer(ua, userInfo);
		
		assertEquals(true, userController.hireTrainer(trainer).isSuccess);
		
		Trainer t = dao.getTrainer(trainer.getId());
		
		UserInformation updatedInfo = new UserInformation(
				new Phone("555-777-7777", "mobile"),
				new Email("randomuser@randomdomain.com", "personal"),
				new Address("123 Some Place", "", "Albuquerque", "NM", "87125"),
				new HealthInsuranceProvider("Blue Cross Blue Shield"));
		
		t.setUserInformation(updatedInfo);
		
		dao.editTrainer(t);
		
		t = dao.getTrainer(trainer.getId());
		
		assertEquals(t.getUserInformation().getPhone().getNumber(), "555-777-7777");
	}
	*/
		
	@Test
	public void testAddCustomer() {
		UserAccount ua = new UserAccount("customerUsername", "asdsdasd");
		
		UserInformation userInfo = new UserInformation(
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
