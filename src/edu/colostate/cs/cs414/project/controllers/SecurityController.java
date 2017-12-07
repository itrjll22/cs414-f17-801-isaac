package edu.colostate.cs.cs414.project.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.project.models.Address;
import edu.colostate.cs.cs414.project.models.Email;
import edu.colostate.cs.cs414.project.models.Enum_Role;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Phone;
import edu.colostate.cs.cs414.project.models.Response;

import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;
import edu.colostate.cs.cs414.project.models.UserInformation;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;
import edu.colostate.cs.cs414.project.persistence.IPersistenceService;
import edu.colostate.cs.cs414.project.utilities.SecurityUtility;

public class SecurityController {

	private static final SecurityController instance = new SecurityController();
	
	IPersistenceService dao = HibernatePersistenceService.getInstance();
	
	private SecurityController(){
		
		/*
		dao = HibernatePersistenceService.getInstance();
		
		UserAccount ua = new UserAccount("itrjllTrainer", "123123123");
		
	
		UserInformation userInfo = new UserInformation();
		userInfo.addNames("Isaac", "Trujillo");
		userInfo.addPhone(new Phone("555-555-5555", "mobile"));
		userInfo.addEmail(new Email("itrjll22@outlook.com", "personal"));
		userInfo.addAddress(new Address("123 Some Place", "", "Albuquerque", "NM", "87125"));
		userInfo.addHealthInsuranceProvider(new HealthInsuranceProvider("Green Cross Green Shield"));	
		
		Trainer trainer = new Trainer(ua, userInfo);
		
		dao.addTrainer(trainer);
		
		
		UserAccount ua2 = new UserAccount("itrjllManager", "123123123");
		
		
		UserInformation userInfo2 = new UserInformation();
		userInfo2.addNames("Isaac", "Trujillo");
		userInfo2.addPhone(new Phone("555-555-5555", "mobile"));
		userInfo2.addEmail(new Email("itrjll22@colostate.edu", "student"));
		userInfo2.addAddress(new Address("6437 5th St.", "Apt. 432", "Santa Fe", "NM", "87125"));
		userInfo2.addHealthInsuranceProvider(new HealthInsuranceProvider("United HealthCare"));	
		
		dao.addManager(new Manager(ua2, userInfo2));
		*/
	}
	
	public static SecurityController getInstance(){ return instance;}
	
	public Response authenticate(String username, String password){
		
		Response response = new Response();
		response.StatusText = "Invalid login.";
		
		UserAccount userAccount = dao.getUserAccount(username);
		if(userAccount != null){
			byte[] salt = userAccount.getSalt();
			
			byte[] hashedPassword = SecurityUtility.hashPassword(password.toCharArray(), salt, 256, 256);
			
			if(Arrays.equals(userAccount.getPasswordHash(),hashedPassword)){
				response.isSuccess = true;
				response.StatusText = "Authentication Successful.";
				response.data = userAccount.toSecurityContext();
			}
		}
		
		return response;
	}
	
	
}
