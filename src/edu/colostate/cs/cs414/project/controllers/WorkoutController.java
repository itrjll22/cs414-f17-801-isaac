package edu.colostate.cs.cs414.project.controllers;

import java.util.List;

import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.EquipmentItem;
import edu.colostate.cs.cs414.project.models.Response;
import edu.colostate.cs.cs414.project.persistence.HibernatePersistenceService;

public class WorkoutController {

	HibernatePersistenceService dao = HibernatePersistenceService.getInstance();
	
	public Response addEquipmentItem(EquipmentItem equipmentItem){
		
		Response response = new Response();
		response.StatusText = "Add Equipment Item unsuccessful.";
		
		if(dao.addEquipmentItem(equipmentItem)){
			response.isSuccess = true;
			response.StatusText = "Add Equipment Item success!";
		}
		
		return response;
		
	}
	
	public List<EquipmentItem> getEquipmentItems(){
		
		return dao.getEquipmentItems();
		
	}
	
}
