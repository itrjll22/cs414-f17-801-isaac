package edu.colostate.cs.cs414.project.persistence;

import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Trainer;

public interface IPersistenceService {

	public boolean saveTrainer(Trainer trainer);
	
	public boolean editTrainer(Trainer trainer);
	
	public boolean deleteTrainer(Trainer trainer);
	
	public boolean addManager(Manager manager);
	
	public boolean addCustomer(Customer customer);
	
	public Trainer getTrainer(String id);
	
}
