package com.project1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Trainer {
	
	//Specifies the primary key of an entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainerId;
	private String firstName;
	private String lastName;
	private double salary;
	private String email;
	private String gender;
	
	
	public int getId() {
		return trainerId;
	}
	public void setId(int id) {
		this.trainerId = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {//method to provide a string representation of the trainer object state.
		return "Trainer [id=" + trainerId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", email=" + email + ", gender=" + gender + "]";
	}
	public Trainer(int trainerId, String firstName, String lastName, double salary, String email, String gender) {
		this.trainerId = trainerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.email = email;
		this.gender = gender;
	}
	public Trainer() {
	}
}

