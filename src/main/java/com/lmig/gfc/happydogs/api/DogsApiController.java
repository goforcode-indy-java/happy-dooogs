package com.lmig.gfc.happydogs.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.happydogs.models.Dog;
import com.lmig.gfc.happydogs.services.DogRepository;

@RestController
@RequestMapping("/api/dogs")
public class DogsApiController {
	
	private DogRepository dogRepository;
	
	public DogsApiController(DogRepository dogRepository) {
		this.dogRepository = dogRepository;
	}

	@GetMapping("")
	public List<Dog> getAll(@RequestParam(required=false) String gender) {
		if (gender != null) {
			return dogRepository.findByGenderIgnoringCase(gender);
		}
		return dogRepository.findAll();
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Dog create(@RequestBody Dog dog) {
		return dogRepository.save(dog);
	}
	
	@GetMapping("{id}")
	public Dog getOne(@PathVariable Long id) {
//		dogRepository.findOne(id);
		return dogRepository.findOne(id);
	}
	
	@PutMapping("{id}")
	public Dog update(@RequestBody Dog dog, @PathVariable Long id) {
		dog.setId(id);
		return dogRepository.save(dog);
	}
	
	@DeleteMapping("{id}")
	public Dog delete(@PathVariable Long id) {
		// Get the dog from the "database" so I can return later
		Dog dog = dogRepository.findOne(id);
		
		// Delete the dog from the database (in this case, just set the
		// value in the array list to null).
		dogRepository.delete(id);
		
		// Return the dog I just deleted.
		return dog;
	}
}










