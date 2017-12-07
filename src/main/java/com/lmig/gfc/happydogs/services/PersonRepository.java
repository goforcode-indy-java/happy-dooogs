package com.lmig.gfc.happydogs.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.happydogs.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
