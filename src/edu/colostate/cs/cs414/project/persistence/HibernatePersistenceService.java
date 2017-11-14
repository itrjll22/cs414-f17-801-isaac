package edu.colostate.cs.cs414.project.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


import edu.colostate.cs.cs414.project.models.Customer;
import edu.colostate.cs.cs414.project.models.EquipmentItem;
import edu.colostate.cs.cs414.project.models.Exercise;
import edu.colostate.cs.cs414.project.models.ExerciseSet;
import edu.colostate.cs.cs414.project.models.HealthInsuranceProvider;
import edu.colostate.cs.cs414.project.models.Manager;
import edu.colostate.cs.cs414.project.models.Trainer;
import edu.colostate.cs.cs414.project.models.UserAccount;
import edu.colostate.cs.cs414.project.models.UserInformation;
import edu.colostate.cs.cs414.project.models.WorkoutRoutine;

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
			session.close();
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
			session.close();
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
			session.close();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean deleteCustomer(Customer customer){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			Customer dbCustomer = (Customer) session.get(Customer.class, customer.getId());
			
			session.delete(dbCustomer);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean deleteEquipmentItem(EquipmentItem t){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			EquipmentItem dbT = (EquipmentItem) session.get(EquipmentItem.class, t.getId());
			
			session.delete(dbT);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean deleteExerciseSet(ExerciseSet t){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			ExerciseSet dbT = (ExerciseSet) session.get(ExerciseSet.class, t.getId());
			
			session.delete(dbT);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean deleteExercise(Exercise t){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			Exercise dbT = (Exercise) session.get(Exercise.class, t.getId());
			
			session.delete(dbT);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean deleteWorkoutRoutine(WorkoutRoutine t){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			WorkoutRoutine dbT = (WorkoutRoutine) session.get(WorkoutRoutine.class, t.getId());
			
			session.delete(dbT);
			session.getTransaction().commit();
			session.close();
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
			session.close();
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
			session.close();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean addExerciseSet(ExerciseSet exerciseSet){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(exerciseSet);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean addWorkoutRoutine(WorkoutRoutine workoutRoutine){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(workoutRoutine);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean addExercise(Exercise exercise){
		
		Session session = sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			session.saveOrUpdate(exercise);
			session.getTransaction().commit();
			session.close();
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
			session.close();
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
			session.close();
		}catch(Exception e){

		}
		
		return trainer;
	}
	
	public Customer getCustomer(String id){
		
		Session session = sessionFactory.openSession();
		Customer customer = null;
		try{
			customer = (Customer) session.get(Customer.class, id);
			session.close();
		}catch(Exception e){

		}
		
		return customer;
	}
	
	public UserAccount getUserAccount(String username){
		Session session = sessionFactory.openSession();
		UserAccount userAccount = null;
		try{
			userAccount = (UserAccount) session.get(UserAccount.class, username);
			session.close();
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
			session.close();
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
			session.close();
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
			session.close();
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
		
		session.close();
		
		return equipmentItems;
	}
	
	public List<ExerciseSet> getExerciseSets(){
		
		Session session = sessionFactory.openSession();
		
		List<ExerciseSet> exerciseSets = new ArrayList<ExerciseSet>();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		

		CriteriaQuery<ExerciseSet> criteria = builder.createQuery(ExerciseSet.class);
		
		criteria.from(ExerciseSet.class);
		
		exerciseSets = session.createQuery(criteria).getResultList();
		
		session.close();
		
		return exerciseSets;
	}
	
	public List<Exercise> getExercises(){
		
		Session session = sessionFactory.openSession();
		
		List<Exercise> exercises = new ArrayList<Exercise>();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		

		CriteriaQuery<Exercise> criteria = builder.createQuery(Exercise.class);
		
		criteria.from(Exercise.class);
		
		exercises = session.createQuery(criteria).getResultList();
		
		session.close();
		
		return exercises;
	}
	
	public List<WorkoutRoutine> getWorkoutRoutines(){
		
		Session session = sessionFactory.openSession();
		
		List<WorkoutRoutine> workoutRoutines = new ArrayList<WorkoutRoutine>();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		

		CriteriaQuery<WorkoutRoutine> criteria = builder.createQuery(WorkoutRoutine.class);
		
		criteria.from(WorkoutRoutine.class);
		
		workoutRoutines = session.createQuery(criteria).getResultList();
		
		session.close();
		
		return workoutRoutines;
	}
	
	public List<Customer> searchCustomers(String searchTerm){
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		Query query = session.createQuery("select c from Customer c join c.userInformation userInfo"
				+ " where userInfo.firstName like :searchTerm OR userInfo.lastName like :searchTerm");
		
		List<Customer> customers = query.setParameter("searchTerm", "%" + searchTerm + "%").list();
		
		session.close();
		
		return customers;
	}
	
	public List<WorkoutRoutine> searchWorkoutRoutines(String searchTerm){
		
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		Query query = session.createQuery("from WorkoutRoutine wr"
				+ " where wr.name like :searchTerm");
		
		List<WorkoutRoutine> workoutRoutines = query.setParameter("searchTerm", "%" + searchTerm + "%").list();
		
		session.close();
		
		return workoutRoutines;
	}
}
