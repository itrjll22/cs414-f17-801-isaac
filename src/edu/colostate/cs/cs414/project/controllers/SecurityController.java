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
