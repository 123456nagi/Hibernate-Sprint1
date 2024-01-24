package com.project1;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TrainerAPP {

		public static void main(String []a) {
			
		 
			EntityManagerFactory factory = null;
			
			try { //connecting to database using persistence unit
				factory  = Persistence.createEntityManagerFactory("project1");
				EntityManager em = factory.createEntityManager();
				
				System.out.println("-----WELCOME TO TRAINER DATABAES-----");
				
				Trainer t1 = new Trainer(1,"Ravi","KumarTG",40000,"ravi@gmail.com","Male");
				Trainer t2 = new Trainer(2,"Nida","Fathima",50000,"fathima@gmail.com","Female");
				Trainer t3 = new Trainer(3,"Ramesh","Kumar",35000,"ramesh@gmail.com","Male");
				Trainer t4 = new Trainer(4,"Akkara","Swathi",30000,"swathi@gmail.com","Female");
				
				TrainerDAO tDAO = new TrainerDAO(em);
				tDAO.createTrainer(t1);//stores the trainer entitys
				tDAO.createTrainer(t2);
				tDAO.createTrainer(t3);
				tDAO.createTrainer(t4);
				
				System.out.println("Data added successfully");
				
				System.out.println("---------------------------------------------");

				//update the name based on id
				int  newid = 3;
				String newfirstName ="Anju" ;
				String newlastName = "Kumari" ;
				double newsalary = 50000;
				String newemail = "anju@gmail.com";
				String newgender  ="Female";
				
				tDAO.updateTrainer(newid, newfirstName, newlastName,newsalary, newemail, newgender);
				
				System.out.println("Data updated sucessfully");
				
				System.out.println("Student  details based on the id :");
				Optional<Trainer> tri = tDAO.getById(1);
				System.out.println(tri);
				 
			//	tDAO.getById(1);
				System.out.println("Details of all the students");	
				
				List<Trainer> alltr = tDAO.getAll();
				System.out.println(alltr);
				
				System.out.println("Removeing based on the id :");
				
				tDAO.removeById(1);
				
				System.out.println("2nd record is removed");
				
				System.out.println("--------------------------------------------------");
				
				
	            System.out.println("-----WELCOME TO COURSE DATABASE-----");

	            Course c1 = new Course(1, "Java Programming", 1000.0);
	            Course c2 = new Course(2, "Database Management", 800.0);
	            Course c3 = new Course(3, "Web Development", 1200.0);

	            CourseDAO cDAO = new CourseDAO(em);
	            cDAO.createCourse(c1);
	            cDAO.createCourse(c2);
	            cDAO.createCourse(c3);

	            System.out.println("Data added successfully");

	            System.out.println("---------------------------------------------");

	            // Update the course name based on id
	            int newId = 2;
	            String newCourseName = "Advanced Database Management";
	            double newCourseFee = 900.0;

	            cDAO.updateCourse(newId, newCourseName, newCourseFee);

	            System.out.println("Data updated successfully");

	            System.out.println("Course details based on the id:");
	            cDAO.getCourseById(1).ifPresent(System.out::println);

	            System.out.println("Details of all the courses:");
	            cDAO.getAllCourses().forEach(System.out::println);

	            System.out.println("Removing based on the id:");
	            cDAO.removeCourseById(1);

	            System.out.println("Course with id 1 is removed");

				
			}
			catch (HibernateException e) {
				 e.printStackTrace();
			}
			catch (Exception e) {
			 e.printStackTrace();
			}

		}

	}


