
package edu.colostate.cs.cs414.project.controllers;

import java.util.List;

import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.Response;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;
import edu.colostate.cs.cs414.project.persistence.IPersistenceService;

public class UserController {
	
	private static final UserController instance = new UserController();
	
	IPersistenceService dao = HibernatePersistenceService.getInstance();
	
	private UserController(){}
	
	public static UserController getInstance(){return instance;}
	
	public Response hireTrainer(Trainer trainer){
		
		Response response = new Response();
		response.StatusText = "Hire trainer unsuccessful.";
		
		if(dao.addTrainer(trainer)){
			response.isSuccess = true;
			response.StatusText = "Hire trainer success!";
		}
		
		return response;
	}

	
	public Response registerCustomer(Customer customer){
		
		Response response = new Response();
		response.StatusText = "Register customer unsuccessful.";
		
		if(dao.addCustomer(customer)){
			response.isSuccess = true;
			response.StatusText = "Register customer success!";
		}
		
		return response;
	}
	
	public Response modifyTrainer(Trainer trainer){
		
		Response response = new Response();
		response.StatusText = "Modify trainer unsuccessful.";
		
		if(dao.editTrainer(trainer)){
			response.isSuccess = true;
			response.StatusText = "Modify trainer success!";
		}
		
		return response;
	}
	
	public List<Trainer> getTrainers(){
		
		return dao.getTrainers();
		
	}
	
	public List<Customer> getCustomers(){
		
		return dao.getCustomers();
		
	}

	
	public List<Customer> seachCustomers(String searchTerm){
		
		return dao.searchCustomers(searchTerm);
		
		
	}
	

	
}
