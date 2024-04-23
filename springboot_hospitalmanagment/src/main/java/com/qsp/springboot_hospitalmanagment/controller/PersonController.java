package com.qsp.springboot_hospitalmanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospitalmanagment.dto.Person;
import com.qsp.springboot_hospitalmanagment.service.PersonService;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@ApiOperation(value = "Save Person", notes = "Api is used to save person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return service.savePerson(person);
	}

	@ApiOperation(value = "Get Person By Id", notes = "Api is used to fetch person using person_id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
			@ApiResponse(code = 404, message = "Id not found for person") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Person>> getByID(@RequestParam int id) {
		return service.getById(id);
	}

	@ApiOperation(value = "Update Person", notes = "Api is used to update person using person_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Id not found for person") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id, @RequestBody Person person) {
		return service.updatePerson(id, person);
	}

	@ApiOperation(value = "Get Person By email", notes = "Api is used to fetch person using person_email")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
			@ApiResponse(code = 404, message = "email not found for person") })
	@GetMapping("/email")
	public ResponseEntity<ResponseStructure<Person>> findPersonByEmail(@RequestParam String email) {
		return service.findPersonByEmail(email);
	}

	@ApiOperation(value = "Get Person By phone", notes = "Api is used to fetch person using person_phone")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
			@ApiResponse(code = 404, message = "phone not found for person") })
	@GetMapping("/phone")
	public ResponseEntity<ResponseStructure<Person>> findPersonByPhone(@RequestParam long phone) {
		return service.findPersonByPhone(phone);
	}

	@ApiOperation(value = "Update Person email", notes = "Api is used to update person_email using person_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Id not found for person") })
	@PatchMapping
	public ResponseEntity<ResponseStructure<Person>> updatePersonEmail(@RequestParam int id,
			@RequestParam String email) {
		return service.updatePersonEmail(id, email);
	}

	@ApiOperation(value = "Get Person By name", notes = "Api is used to fetch person using person_name")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
			@ApiResponse(code = 404, message = "name not found for person") })
	@GetMapping("/name")
	public ResponseEntity<ResponseStructure<List<Person>>> findPersonByName(@RequestParam String name) {
		return service.findPersonByName(name);
	}

	@ApiOperation(value = "Delete Person", notes = "Api is used to delete person using person_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Id not found for person") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}

}
