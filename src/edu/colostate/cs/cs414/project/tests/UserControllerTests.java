package edu.colostate.cs.cs414.project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import edu.colostate.cs.cs414.project.controllers.UserController;
import edu.colostate.cs.cs414.project.models.*;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;
import edu.colostate.cs.cs414.project.utilities.TestUtility;

public class UserControllerTests {

	UserController userController;
	HibernatePersistenceService dao;
	TestUtility testUtility;
	
	List<Trainer> trainers;
	
	List<Customer> customers;
	
	@Before
	public void setUp(){
		
		userController = UserController.getInstance();
		
		dao = HibernatePersistenceService.getInstance();
		
		testUtility = new TestUtility();
		
		trainers = new ArrayList<Trainer>();
		customers = new ArrayList<Customer>();
		
		try {
			
			
			
			UserAccount ua = new UserAccount("RandomUsername", "password123");
			
			UserInformation userInfo = new UserInformation();
			userInfo.addNames("Isaac", "Trujillo");
			userInfo.addPhone(new Phone("555-555-5555", "mobile"));
			userInfo.addEmail(new Email("randomuser@randomdomain.com", "personal"));
			userInfo.addAddress(new Address("123 Some Place", "", "Albuquerque", "NM", "87125"));
			userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider(testUtility.getPseudoRandomString()));
					
			
			Trainer trainer = new Trainer(ua, userInfo);
			
			trainers.add(trainer);
			
			userController.hireTrainer(trainer);
			
			
			UserAccount ua2 = new UserAccount("anotherUserName", "123123123");
			
			UserInformation userInfo2 = new UserInformation();
			userInfo2.addNames("Jannette", "Duke");
			userInfo2.addPhone(new Phone("555-555-5555", "mobile"));
			userInfo2.addEmail(new Email("jannette@randomdomain.com", "personal"));
			userInfo2.addAddress(new Address("123 Another Place", "", "Denver", "CO", "87125"));
			userInfo2.addHealthInsuranceProvider(new HealthInsuranceProvider(testUtility.getPseudoRandomString()));
					
			
			Customer customer = new Customer(ua2, userInfo2);
			
			customers.add(customer);
			
			userController.registerCustomer(customer);
			
			
			}
		catch(Exception e){
			
		}
		
	}
	
	@After
	public void tearDown(  ) {
       for(Trainer t : trainers){
    	   dao.deleteTrainer(t);
       }
       
       for(Customer c : customers){
    	   dao.deleteCustomer(c);
       }
    }
	
	@Test
	public void testHireTrainer() {
		Trainer trainer = null;
		
		try {
		
		UserAccount ua = new UserAccount(testUtility.getPseudoRandomString(), testUtility.getPseudoRandomString());
		
		
		
		UserInformation userInfo = new UserInformation();
		userInfo.addNames("Isaac", "Trujillo");
		userInfo.addPhone(new Phone("555-555-5555", "mobile"));
		userInfo.addEmail(new Email("test@randomdomain.com", "personal"));
		userInfo.addAddress(new Address("123 Some Place", "", "Albuquerque", "NM", "87125"));
		userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider(testUtility.getPseudoRandomString()));
				
		
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
	public void testRegisterCustomer() {
		
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
		
		assertEquals(true,userController.registerCustomer(customer).isSuccess);
		
		Customer c = dao.getCustomer(customer.getId());
		
		assertEquals(c.getId(), customer.getId());
		
		}
		finally{
		
			dao.deleteCustomer(customer);
		}
	}

	@Test
	public void testGetTrainers() {
	
		List<Trainer> allTrainers = userController.getTrainers();
		
		assertEquals(allTrainers.size() >= 1, true);
		
		boolean testTrainerFound = false;
		
		for(Trainer t: allTrainers){
			if(t.getUserAccount().getUsername().equalsIgnoreCase("RandomUsername")){
				testTrainerFound = true;
			}
		}
		
		assertEquals(testTrainerFound, true);
	
	}
	
	@Test
	public void testGetCustomers() {
	
		List<Customer> allCustomers = userController.getCustomers();
		
		assertEquals(allCustomers.size() >= 1, true);
		
		boolean testCustomerFound = false;
		
		for(Customer c: allCustomers){
			if(c.getUserAccount().getUsername().equalsIgnoreCase("anotherUserName")){
				testCustomerFound = true;
			}
		}
		
		assertEquals(testCustomerFound, true);
	
	}
	
	@Test
	public void testSearchCustomers() {
		
		
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
			
			boolean found = false;
			
			for(Customer c : UserController.getInstance().seachCustomers("Isa")){
				if(c.getId().equalsIgnoreCase(customer.getId())){
					found = true;
				}
			}
			
			assertEquals(found, true);
			
		} 
		finally{
			dao.deleteCustomer(customer);
		
		}
		
	}
	
	@Test
	public void testSearchTrainers() {
		
		
		Trainer trainer = null;
		 
		try {
			
			UserAccount ua = new UserAccount(testUtility.getPseudoRandomString(), "jdoes");
			
			UserInformation userInfo = new UserInformation();
			userInfo.addNames("John", "Does");
			userInfo.addPhone(new Phone("555-555-4444", "mobile"));
			userInfo.addEmail(new Email("jdoe@rasdf.com", "personal"));
			userInfo.addAddress(new Address("112 8th Street NE", "", "Albuquerque", "NM", "87125"));
			userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider(testUtility.getPseudoRandomString()));
			
			
			trainer = new Trainer(ua, userInfo);
			
			UserController.getInstance().hireTrainer(trainer);
			
			boolean found = false;
			
			for(Trainer t : UserController.getInstance().searchTrainers("does")){
				if(t.getId().equalsIgnoreCase(trainer.getId())){
					found = true;
				}
			}
			
			assertEquals(found, true);
			
		} 
		finally{
			dao.deleteTrainer(trainer);
		
		}
		
	}
	
	
}
