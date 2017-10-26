package edu.colostate.cs.cs414.project.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;

public class HibernatePersistenceService implements IPersistenceService{

	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public boolean saveTrainer(Trainer trainer){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			session.save(trainer);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean editTrainer(Trainer trainer){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(trainer);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean deleteTrainer(Trainer trainer){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			Trainer dbTrainer = (Trainer) session.get(Trainer.class, trainer.getId());
			
			session.delete(dbTrainer);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean addManager(Manager manager){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			session.save(manager);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean addCustomer(Customer customer){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public Trainer getTrainer(String id){
		
		Session session = sessionFactory.openSession();
		Trainer trainer = null;
		try{
			trainer = (Trainer) session.get(Trainer.class, id);
		}catch(Exception e){

		}
		
		return trainer;
	}
	
	public Customer getCustomer(String id){
		
		Session session = sessionFactory.openSession();
		Customer customer = null;
		try{
			customer = (Customer) session.get(Customer.class, id);
		}catch(Exception e){

		}
		
		return customer;
	}
	
	public UserAccount getUserAccount(String username){
		Session session = sessionFactory.openSession();
		UserAccount userAccount = null;
		try{
			userAccount = (UserAccount) session.get(UserAccount.class, username);
		}catch(Exception e){

		}
		
		return userAccount;
	}
}
