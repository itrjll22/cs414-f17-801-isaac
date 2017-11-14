package edu.colostate.cs.cs414.project.controllers;

import java.util.ArrayList;
import java.util.List;

import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;
import edu.colostate.cs.cs414.project.persistence.IPersistenceService;

public class SystemGeneralController {

	private static final SystemGeneralController instance = new SystemGeneralController();
	
	IPersistenceService dao = HibernatePersistenceService.getInstance();
	
	private SystemGeneralController(){
		
	}
	
	public static SystemGeneralController getInstance(){
		return instance;
	}
	
	public List<HealthInsuranceProvider> getHealthInsuranceProviders(){
		
		return dao.getHealthInsuranceProviders();
		
	}
	
}
