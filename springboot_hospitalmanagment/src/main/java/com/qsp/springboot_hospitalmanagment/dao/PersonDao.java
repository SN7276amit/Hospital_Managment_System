package com.qsp.springboot_hospitalmanagment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalmanagment.dto.Person;
import com.qsp.springboot_hospitalmanagment.repo.PersonRepo;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepo repo;

	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		return repo.save(person);
	}
	public Person updatePerson(int id, Person person) {
		if (repo.findById(id).isPresent()) {
			person.setPersonid(id);
			return repo.save(person);
		} else {
			return null;
		}
	}
	public Person deletePerson(int id) {
		if (repo.findById(id).isPresent()) {
			Person person = repo.findById(id).get();
			repo.deleteById(id);
			return person;
		} else {
			return null;
		}
	}


	public Person getById(int id) {
		Optional<Person> optional= repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Person findPersonByEmail(String email) {
		return repo.findPersonByPersonemail(email);
	}

	public List<Person> findPersonByName(String name) {
		return repo.findPersonByPersonname(name);
	}

	public Person findPersonByPhone(long phone) {
		return repo.findPersonByPersonphone(phone);
	}

}
