package com.qsp.springboot_hospitalmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospitalmanagment.dto.Encounter;
import com.qsp.springboot_hospitalmanagment.service.EncounterService;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
	@Autowired
	private EncounterService encounterService;

	@ApiOperation(value = "Save Encounter", notes = "Api is used to save encounter using person_id & branch_id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "Id not found for person or branch") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,
			@RequestParam int personid, @RequestParam int branchid) {
		return encounterService.saveEncounter(encounter, personid, branchid);
	}

	@ApiOperation(value = "Get Encounter By Id", notes = "Api is used to fetch encounter using encounter_id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
			@ApiResponse(code = 404, message = "Id not found for encounter") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int encounterid) {
		return encounterService.getEncounterById(encounterid);
	}

	@ApiOperation(value = "Update Encounter", notes = "Api is used to update encounter using encounter_id & branch_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Id not found for encounter or branch") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestParam int encounterid,
			Encounter encounter, int branchid) {
		return encounterService.updateEncounter(encounterid, encounter, branchid);
	}
	@ApiOperation(value = "Delete Encounter", notes = "Api is used to delete encounter using encounter_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Id not found for encounter") })
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter( @RequestParam int id) {
		return encounterService.deleteEncounter(id);
	}

}
