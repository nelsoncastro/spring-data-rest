package com.github.nelsoncastro.springbootrest.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
	<T> T findByName(String name, Class<T> type);
	
	@Query(value = "SELECT p.id, p.name FROM PERSONS p where p.name = :name", nativeQuery = true)
	<T> T findByName_native(String name, Class<T> type);
	
	@Query(nativeQuery = true)
	PersonDTO findPersonNameDtoByName_Named(String name);
	
	
	@Query(value = "SELECT p.id, p.name FROM PERSONS p where p.name = :name", nativeQuery = true)
	PersonSummaryDTO findPersonNameDtoByName_Interface(String name);
}
