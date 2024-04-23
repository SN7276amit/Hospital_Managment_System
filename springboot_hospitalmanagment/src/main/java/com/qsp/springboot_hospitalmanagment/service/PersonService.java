package com.qsp.springboot_hospitalmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalmanagment.dao.PersonDao;
import com.qsp.springboot_hospitalmanagment.dto.Person;
import com.qsp.springboot_hospitalmanagment.exception.DataNotFoundException;
import com.qsp.springboot_hospitalmanagment.exception.IdNotFoundException;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Person>> getById(int id) {
		Person person = dao.getById(id);
		if (person != null) {
			ResponseStructure<Person> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Id not found for Person");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id, Person person) {
		Person dbPerson = dao.updatePerson(id, person);
		if (dbPerson != null) {
			ResponseStructure<Person> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbPerson);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Person");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> findPersonByEmail(String email) {
		Person person = dao.findPersonByEmail(email);
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		if (person != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("name not found for person");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> updatePersonEmail(int id, String email) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person person = dao.getById(id);
		if (person != null) {
			person.setPersonemail(email);
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.savePerson(person));
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException("Id not found for Person");
	}

	public ResponseEntity<ResponseStructure<List<Person>>> findPersonByName(String name) {
		List<Person> list = dao.findPersonByName(name);
		ResponseStructure<List<Person>> structure = new ResponseStructure<List<Person>>();
		if (list != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("name not found for person");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> findPersonByPhone(long phone) {
		Person person = dao.findPersonByPhone(phone);
		ResponseStructure<Person> structure = new ResponseStructure<Person>();
		if (person != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("phone not found for person");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) {
		Person person = dao.deletePerson(id);
		if (person != null) {
			ResponseStructure<Person> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Person");
		}
	}

}
