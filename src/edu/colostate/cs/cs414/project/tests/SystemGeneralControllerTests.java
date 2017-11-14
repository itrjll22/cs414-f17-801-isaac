package edu.colostate.cs.cs414.project.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.project.controllers.SecurityController;
import edu.colostate.cs.cs414.project.controllers.SystemGeneralController;
import edu.colostate.cs.cs414.project.models.Address;
import edu.colostate.cs.cs414.project.models.Email;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Phone;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;
import edu.colostate.cs.cs414.project.models.UserInformation;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;
import edu.colostate.cs.cs414.project.persistence.IPersistenceService;

public class SystemGeneralControllerTests {

	SystemGeneralController systemGeneralController;
	IPersistenceService dao;
	
	@Before
	public void setUp(){
		
		systemGeneralController = SystemGeneralController.getInstance();
		
		dao = HibernatePersistenceService.getInstance();
		
		UserAccount ua = new UserAccount("itrjllManager", "password123");
		
		
		
		UserInformation userInfo = new UserInformation();
		userInfo.addNames("Isaac", "Trujillo");
		userInfo.addPhone(new Phone("555-555-5555", "mobile"));
		userInfo.addEmail(new Email("isaac.trujillo@colostate.edu", "student"));
		userInfo.addAddress(new Address("123 Some Place", "", "Albuquerque", "NM", "87125"));
		userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider("Blue Cross Blue Shield"));
		
		Manager manager = new Manager(ua, userInfo);
		
		dao.addManager(manager);
		
	
		UserAccount uaTrainer = new UserAccount("itrjllTrainer", "123123123");
		
	
		UserInformation userInfoTrainer = new UserInformation();
		userInfoTrainer.addNames("Isaactrainer", "Trujillo");
		userInfoTrainer.addPhone(new Phone("555-555-5555", "mobile"));
		userInfoTrainer.addEmail(new Email("itrjll22@outlook.com", "student"));
		userInfoTrainer.addAddress(new Address("123 Another Place", "", "Rio Rancho", "NM", "87144"));
		userInfoTrainer.addHealthInsuranceProvider(new HealthInsuranceProvider("United Healthcare"));	
		
		Trainer trainer = new Trainer(uaTrainer, userInfoTrainer);
	
		dao.addTrainer(trainer);
		
	}
	
	@Test
	public void testGetHealthInsuranceProviders() {
		
		List<HealthInsuranceProvider> providers = systemGeneralController.getHealthInsuranceProviders();
		
		assertEquals(providers.size() >= 2, true);
		
		boolean uhcFound = false;
		boolean bcbsFound = false;
		
		for(HealthInsuranceProvider p : providers){
			if(p.getName().equalsIgnoreCase("United Healthcare")){
				uhcFound = true;
			}
			else if(p.getName().equalsIgnoreCase("Blue Cross Blue Shield")){
				bcbsFound = true;
			}
			
		}
		
		assertEquals(uhcFound, true);
		assertEquals(bcbsFound, true);
		
	}

}
