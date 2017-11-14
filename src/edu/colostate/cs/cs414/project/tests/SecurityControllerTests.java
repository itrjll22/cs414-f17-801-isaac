package edu.colostate.cs.cs414.project.tests;


import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.project.controllers.SecurityController;
import edu.colostate.cs.cs414.project.controllers.UserController;
import edu.colostate.cs.cs414.project.models.Address;
import edu.colostate.cs.cs414.project.models.Email;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Phone;
import edu.colostate.cs.cs414.project.models.Response;
import edu.colostate.cs.cs414.project.models.UserAccount;
import edu.colostate.cs.cs414.project.models.UserInformation;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;
import edu.colostate.cs.cs414.project.persistence.IPersistenceService;

public class SecurityControllerTests {

	SecurityController securityController;
	IPersistenceService dao;
	
	@Before
	public void setUp(){
		
		securityController = SecurityController.getInstance();
		
		dao = HibernatePersistenceService.getInstance();
		
		UserAccount ua = new UserAccount("testAcct", "password123");
		
	
		UserInformation userInfo = new UserInformation();
		userInfo.addNames("Isaac", "Trujillo");
		userInfo.addPhone(new Phone("555-555-5555", "mobile"));
		userInfo.addEmail(new Email("testacct@test.com", "student"));
		userInfo.addAddress(new Address("123 Some Place", "", "Albuquerque", "NM", "87125"));
		userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider("Green Cross Green Shield"));	
		
		Manager manager = new Manager(ua, userInfo);
		
		dao.addManager(manager);
		
		
	}
	
	@Test
	public void testValidAuthentication() {
		Response response = securityController.authenticate("testAcct", "password123");
		
		assertEquals(response.isSuccess, true);
		
	}
	
	@Test
	public void testInvalidAuthentication() {
		Response response = securityController.authenticate("testAcct", "asdasd");
		
		assertEquals(response.isSuccess, false);
		
	}
	
	@Test
	public void testInvalidAuthenticationCaseSensitivityPassword() {
		Response response = securityController.authenticate("testAcct", "Password123");
		
		assertEquals(response.isSuccess, false);
		
	}
	
	@Test
	public void testInvalidAuthenticationCaseSensitivityPUsername() {
		Response response = securityController.authenticate("testacct", "password123");
		
		assertEquals(response.isSuccess, true);
		
	}
	
	@Test
	public void testInvalidAuthentication_Blanks() {
		Response response = securityController.authenticate("", "");
		
		assertEquals(response.isSuccess, false);
	}
	
}
