package edu.colostate.cs.cs414.project.controllers;

import java.util.Arrays;
import java.util.Set;

import edu.colostate.cs.cs414.project.models.Address;
import edu.colostate.cs.cs414.project.models.Email;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Phone;
import edu.colostate.cs.cs414.project.models.Response;
import edu.colostate.cs.cs414.project.models.Role;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;
import edu.colostate.cs.cs414.project.models.UserInformation;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;
import edu.colostate.cs.cs414.project.utilities.SecurityUtility;

public class SecurityController {

	private static final SecurityController instance = new SecurityController();
	
	HibernatePersistenceService dao = new HibernatePersistenceService();
	
	private SecurityController(){
		
		UserAccount ua = new UserAccount("itrjll22", "password123");
		
		UserInformation userInfo = new UserInformation(
				new Phone("555-555-5555", "mobile"),
				new Email("isaac.trujillo@colostate.edu", "student"),
				new Address("123 Some Place", "", "Albuquerque", "NM", "87125"),
				new HealthInsuranceProvider("Blue Cross Blue Shield"));
		
		Manager manager = new Manager(ua, userInfo);
		
		dao.addManager(manager);
		
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
	
	public Response createUserAccount(String username, String password, Set<Role> roles){
		
		Response response = new Response();
		
		UserAccount userAccount = new UserAccount(username, password, roles);
		
		return response;
	}
	
}