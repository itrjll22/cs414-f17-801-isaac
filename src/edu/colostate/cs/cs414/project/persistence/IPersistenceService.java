package edu.colostate.cs.cs414.project.persistence;

import java.util.ArrayList;
import java.util.List;

import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.EquipmentItem;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Trainer;

public interface IPersistenceService {

	public boolean addTrainer(Trainer trainer);
	
	public boolean editTrainer(Trainer trainer);
	
	public boolean deleteTrainer(Trainer trainer);
	
	public boolean addManager(Manager manager);
	
	public boolean addCustomer(Customer customer);
	
	public Trainer getTrainer(String id);
	
	public List<HealthInsuranceProvider> getHealthInsuranceProviders();
	
	public boolean addEquipmentItem(EquipmentItem equipmentItem);
	
	public List<Trainer> getTrainers();
	
	public List<Customer> getCustomers();
	
	public List<EquipmentItem> getEquipmentItems();
	
}
