package com.lmig.gfc.happydogs.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Dog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany
	private List<Person> owners;
	
	@OneToMany(mappedBy = "dog")
	private List<Meal> meals;

	private int weightInPounds;
	
	@Column(length = 15, nullable = false)
	private String breed;
	
	@Column(nullable = false)
	private String name;
	
	private double heightInInches;
	private String gender;
	private String color;
	private int numberOfLegs;
	private boolean isHappy;
	private Date birthDate;

	public Dog() {}
	
	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}

	public Dog(int weightInPounds, String breed, String name, double heightInInches, String gender, String color, int numberOfLegs, boolean isHappy, Date birthDate) {
		this.weightInPounds = weightInPounds;
		this.breed = breed;
		this.name = name;
		this.heightInInches = heightInInches;
		this.gender = gender;
		this.color = color;
		this.numberOfLegs = numberOfLegs;
		this.isHappy = isHappy;
		this.birthDate = birthDate;
	}
	
	public int getWeightInPounds() {
		return weightInPounds;
	}
	public void setWeightInPounds(int weightInPounds) {
		this.weightInPounds = weightInPounds;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeightInInches() {
		return heightInInches;
	}
	public void setHeightInInches(double heightInInches) {
		this.heightInInches = heightInInches;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
	public boolean isHappy() {
		return isHappy;
	}
	public void setHappy(boolean isHappy) {
		this.isHappy = isHappy;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Person> getOwners() {
		return owners;
	}

	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

}
