package com.lmig.gfc.happydogs.api;

import java.util.List;

import com.lmig.gfc.happydogs.models.Dog;
import com.lmig.gfc.happydogs.models.Meal;

public class DogView {
	
	private Dog dog;

	public DogView(Dog dog) {
		this.dog = dog;
	}
	
	public Long getId() {
		return dog.getId();
	}
	
	public String getName() {
		return dog.getName();
	}
	
	public String getBreed() {
		return dog.getBreed();
	}
	
	public List<Meal> getMeals() {
		return dog.getMeals();
	}

}








