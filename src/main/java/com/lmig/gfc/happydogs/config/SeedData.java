package com.lmig.gfc.happydogs.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.happydogs.models.Dog;
import com.lmig.gfc.happydogs.models.Meal;
import com.lmig.gfc.happydogs.models.Person;
import com.lmig.gfc.happydogs.services.DogRepository;
import com.lmig.gfc.happydogs.services.MealRepository;
import com.lmig.gfc.happydogs.services.PersonRepository;

@Configuration
public class SeedData {

	public SeedData(PersonRepository personRepository, DogRepository dogRepository, MealRepository mealRepository) {
		Person owner = new Person();
		owner.setFirstName("Barry");
		personRepository.save(owner);
		
		dogRepository.save(new Dog(3, "Schnauzer", "Marco Polo", 3.4, "Male", "Green", 4, true, null));
		dogRepository.save(new Dog(14, "Terrier", "Weeble", 3.4, "Male", "Red", 4, true, null));
		dogRepository.save(new Dog(8, "Mutt", "Dinkus", 3.4, "Non-binary", "Orange", 4, true, null));
		dogRepository.save(new Dog(8, "Mutt", "Old Yeller", 3.4, "Female", "Yello", 4, true, null));
		
		Dog dog = dogRepository.save(new Dog(8, "Mutt", "Maximillian Golden Bullet", 3.4, "Male", "Unknown", 4, true, null));
		
		Meal meal = new Meal();
		meal.setFood("Steak");
		meal.setDog(dog);
		mealRepository.save(meal);
		
		ArrayList<Person> owners = new ArrayList<Person>();
		owners.add(owner);
		dog.setOwners(owners);
		dogRepository.save(dog);
	}
	
}










