package com.lmig.gfc.happydogs.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.happydogs.models.Dog;
import com.lmig.gfc.happydogs.services.DogRepository;

public class DogsApiControllerTests {
	
	private DogsApiController controller;
	private DogRepository repo;
	
	@Before
	public void setUp() {
		repo = mock(DogRepository.class);
		controller = new DogsApiController(repo);
	}
	
	@Test
	public void weWillNeverTypeThisInRealLife() {
		assertThat(repo).isNotNull();
	}
	
	@Test
	public void getAll_with_null_gender_returns_list_of_dogs() {
		// Arrange
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		when(repo.findAll()).thenReturn(dogs);
		// when(the method call used in the code being tested)
		//   .thenReturn(a value that you created)
		
		// Act
		List<Dog> actual = controller.getAll(null);
		
		// Assert
		assertThat(actual).isSameAs(dogs);
		verify(repo).findAll();
	}
	
	@Test
	public void getAll_with_male_gender_returns_list_of_dogs() {
		// Arrange
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		when(repo.findByGenderIgnoringCase("robot")).thenReturn(dogs);
		// when(the method call used in the code being tested)
		//   .thenReturn(a value that you created)
		
		// Act
		List<Dog> actual = controller.getAll("robot");
		
		// Assert
		assertThat(actual).isSameAs(dogs);
		verify(repo).findByGenderIgnoringCase("robot");
	}
	
	@Test
	public void create_saves_the_dog_and_returns_it() {
		// Arrange
		Dog dog = new Dog();
		when(repo.save(dog)).thenReturn(dog);
		
		// Act
		Dog actual = controller.create(dog);
		
		// Assert
		assertThat(actual).isSameAs(dog);
		verify(repo).save(dog);
	}
	
	@Test
	public void getOne_returns_a_dog_for_a_valid_id() {
		// Arrange
		Dog dog = new Dog();
		when(repo.findOne(0L)).thenReturn(dog);
		
		// Act
		Dog actual = controller.getOne(0L);
		
		// Assert
		assertThat(actual).isSameAs(dog);
		verify(repo).findOne(0L);
//		verify(repo, times(2)).findOne(0L);
	}
	
	@Test
	public void getOne_returns_a_dog_for_an_invalid_id() {
		// Arrange
		// By default, a mock object returns null for
		//   any method that returns a capital-letter thing
		// - or -
		// you can be explicit with something like
		//   when(repo.findOne(0L)).thenReturn(null);
		
		// Act
		Dog actual = controller.getOne(382361282820L);
		
		// Assert
		assertThat(actual).isNull();
		verify(repo).findOne(382361282820L);
	}
	
	@Test
	public void update_sets_id_of_dog_and_calls_save_and_returns_dog() {
		// Arrange
		Dog dog = new Dog();
		when(repo.save(dog)).thenReturn(dog);
		
		// Act
		Dog actual = controller.update(dog, 37L);
		
		// Assert
		assertThat(actual).isSameAs(dog);
		verify(repo).save(dog);
		assertThat(dog.getId()).isEqualTo(37L);
	}
	
	@Test
	public void delete_gets_the_dog_and_deletes_it_from_the_repo_and_returns_it() {
		// Arrange
		Dog dog = new Dog();
		when(repo.findOne(8L)).thenReturn(dog);
		
		// Act
		Dog actual = controller.delete(8L);
		
		// Assert
		assertThat(actual).isSameAs(dog);
		verify(repo).findOne(8L);
		verify(repo).delete(8L);
	}

}












