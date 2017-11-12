package edu.colostate.cs.cs414.project.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.EquipmentItem;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;

public class HibernatePersistenceService implements IPersistenceService{
	
	private static final HibernatePersistenceService instance = new HibernatePersistenceService();

	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private HibernatePersistenceService(){
		
	}
	
	public static HibernatePersistenceService getInstance(){
		return instance;
	}
	
	public boolean addTrainer(Trainer trainer){
		
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
			session.saveOrUpdate(manager);
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
			session.saveOrUpdate(customer);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean addEquipmentItem(EquipmentItem equipmentItem){
		
		Session session = sessionFactory.openSession();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(equipmentItem.getImageFile());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		Blob imageBlob = session.getLobHelper().createBlob(fis, equipmentItem.getImageFile().length());
		
		equipmentItem.setImageBlob(imageBlob);
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(equipmentItem);
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
	
	public List<HealthInsuranceProvider> getHealthInsuranceProviders(){
		Session session = sessionFactory.openSession();
		
		List<HealthInsuranceProvider> healthInsuranceProviders = new ArrayList<HealthInsuranceProvider>();
		
		try{
			Query query = session.createQuery("from HealthInsuranceProvider");
			healthInsuranceProviders = query.list();
		}catch(Exception e){

		}
		
		return healthInsuranceProviders;
	}
	
	public List<Trainer> getTrainers(){
		Session session = sessionFactory.openSession();
		
		List<Trainer> trainers = new ArrayList<Trainer>();
		
		try{
			Query query = session.createQuery("from Trainer");
			trainers = query.list();
		}catch(Exception e){

		}
		
		return trainers;
	}
	
	public List<Customer> getCustomers(){
		Session session = sessionFactory.openSession();
		
		List<Customer> customers = new ArrayList<Customer>();
		
		try{
			Query query = session.createQuery("from Customer");
			customers = query.list();
		}catch(Exception e){

		}
		
		return customers;
	}
	
	public List<EquipmentItem> getEquipmentItems(){
		Session session = sessionFactory.openSession();
		
		List<EquipmentItem> equipmentItems = new ArrayList<EquipmentItem>();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		

		CriteriaQuery<EquipmentItem> criteria = builder.createQuery(EquipmentItem.class);
		
		criteria.from(EquipmentItem.class);
		
		equipmentItems = session.createQuery(criteria).getResultList();
		
		
		return equipmentItems;
	}
}
