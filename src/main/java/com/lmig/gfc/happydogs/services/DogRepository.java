package com.lmig.gfc.happydogs.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.happydogs.models.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

	List<Dog> findByGenderIgnoringCase(String gender);
}








