package com.qsp.springboot_hospitalmanagment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalmanagment.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
	Person findPersonByPersonemail(String email);

	List<Person> findPersonByPersonname(String name);

	Person findPersonByPersonphone(long phone);

}
