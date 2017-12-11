package com.lmig.gfc.happydogs.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.happydogs.models.Dog;
import com.lmig.gfc.happydogs.models.Person;
import com.lmig.gfc.happydogs.services.DogRepository;
import com.lmig.gfc.happydogs.services.PersonRepository;

public class OwnersApiControllerTests {

	private OwnersApiController controller;
	@Mock private DogRepository dogRepo;
	@Mock private PersonRepository personRepo;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new OwnersApiController(personRepo, dogRepo);
	}
	
	@Test
	public void create_saves_dog_when_person_is_not_an_owner() {
		// Arrange
		Dog dog = new Dog();
		dog.setOwners(new ArrayList<Person>());
		Person person = new Person();
		when(dogRepo.findOne(147L)).thenReturn(dog);
		when(personRepo.findOne(153L)).thenReturn(person);
		
		// Act
		Dog actual = controller.create(147L, 153L);
		
		// Assert
		assertThat(actual).isSameAs(dog);
		verify(dogRepo).save(dog);
		assertThat(dog.getOwners()).contains(person);
		verify(dogRepo).findOne(147L);
		verify(personRepo).findOne(153L);
	}
	
	@Test
	public void create_does_not_save_a_dog_if_the_person_already_owns_it() {
		// Arrange
		Person person = new Person();
		ArrayList<Person> owners = new ArrayList<Person>();
		owners.add(person);
		Dog dog = new Dog();
		dog.setOwners(owners);
		when(dogRepo.findOne(2L)).thenReturn(dog);
		when(personRepo.findOne(3L)).thenReturn(person);
		
		// Act
		Dog actual = controller.create(2L, 3L);
		
		// Assert
		verify(personRepo).findOne(3L);
		verify(dogRepo).findOne(2L);
		assertThat(actual).isSameAs(dog);
		verify(dogRepo, never()).save(dog);
		assertThat(dog.getOwners()).hasSize(1);
	}

}










