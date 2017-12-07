package com.lmig.gfc.happydogs.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.happydogs.models.Dog;
import com.lmig.gfc.happydogs.models.Person;
import com.lmig.gfc.happydogs.services.DogRepository;
import com.lmig.gfc.happydogs.services.PersonRepository;

@RestController
@RequestMapping("/api/dogs/{dogId}/owners")
public class OwnersApiController {
	
	private PersonRepository pr;
	private DogRepository dr;

	public OwnersApiController(PersonRepository pr, DogRepository dr) {
		this.pr = pr;
		this.dr = dr;
	}
	
	@PostMapping("")
	public Dog create(@PathVariable Long dogId, @RequestBody Long personId) {
		Dog dog = dr.findOne(dogId);
		Person person = pr.findOne(personId);
		
		if (!dog.getOwners().contains(person)) {
			dog.getOwners().add(person);
			dr.save(dog);
		}
		
		return dog;
	}

}







