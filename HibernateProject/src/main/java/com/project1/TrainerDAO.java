package com.project1;

import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TrainerDAO {
		
		//EntityManager to manage entitys and perform database operations
		private EntityManager em;

		public TrainerDAO(final EntityManager em) {

			this.em = em;
	}
		//method to create a new Trainer entity in the database
		public void createTrainer(final Trainer trainer) {
			EntityTransaction tx = null;
			try {
				tx = em.getTransaction(); // Return the resource-level EntityTransaction object and retrieves the current transaction

				if (!tx.isActive())
				{
					tx.begin();//start the transaction
				}
				Trainer mergedTrainer = em.merge(trainer);
				tx.commit(); //save
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
			public void updateTrainer( int id, String newfirstName, String newlastName, double salary,String newemail, String newgender) {
				EntityTransaction tx = null; 
				try {
				tx = em.getTransaction(); // Return the resource-level EntityTransaction object

				if (!tx.isActive()) // Indicate whether a resource transaction is in progress.
				{
					tx.begin();
				}
				Trainer tr = em.find(Trainer.class, id) ;//Finds the Trainer by id using em.find()
				if(tr !=null) {//checks the Trainer entity object
					tr.setFirstName(newfirstName);
					tr.setLastName(newlastName);
					tr.setSalary(salary);
					tr.setEmail(newemail);
					tr.setGender(newgender);
					
					em.merge(tr); 
					tx.commit();
				}
				  
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}
			public Optional<Trainer> getById(int id) {

			Trainer t = em.find(Trainer.class, id);

				if (t != null) {
				return Optional.of(t);
			} else {
				return Optional.empty();
			}
		}	
			public List<Trainer> getAll() {
												//retrives the result set as a list of trainer entity
				List<Trainer> t1 = em.createQuery("from Trainer", Trainer.class).getResultList();

				return t1;
			}
				
			public void removeById(int id) {  //removing  based on id 
				EntityTransaction tx = null; 
				
				Trainer tr = em.find(Trainer.class, id);  
				
				try {
					tx = em.getTransaction(); // Return the resource-level EntityTransaction object

					if (!tx.isActive()) // Indicate whether a resource transaction is in progress.
					{
						tx.begin();
					}
					em.remove(tr);//remove the trainer entity based on id
					tx.commit();//commit is permanently  delete in database
				}
				catch (Exception e) {
					 e.printStackTrace();
				}	
			}	
}		
	
