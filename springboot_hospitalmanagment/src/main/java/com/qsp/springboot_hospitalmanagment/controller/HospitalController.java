package com.qsp.springboot_hospitalmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospitalmanagment.dto.Hospital;
import com.qsp.springboot_hospitalmanagment.service.HospitalService;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	@ApiOperation(notes = "this api is use to save the hospital details into the db", value = "Save hospital Api")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "data saved successfully") })
	@PostMapping("/savehospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);

	}

	@ApiOperation(value = "Get Hospital By Id", notes = "Api is used to fetch hospital using hospital_id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
			@ApiResponse(code = 404, message = "Id not found for hospital") })
	@GetMapping("/find/id")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return hospitalService.getHospitalById(id);
	}

	@ApiOperation(value = "Delete Hospital", notes = "Api is used to delete hospital using hospital_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "Id not found for hospital") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@PathVariable int id) {
		return hospitalService.deleteHospital(id);
	}

	@ApiOperation(value = "Update Hospital", notes = "Api is used to update hospital using hospital_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "Id not found for hospital") })
	@PutMapping("/update/id")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,
			@RequestBody Hospital hospital) {
		return hospitalService.updateHospital(id, hospital);
	}

	@ApiOperation(value = "Get Hospital By email", notes = "Api is used to fetch hospital using hospital_email")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
			@ApiResponse(code = 404, message = "email not found for hospital") })
	@GetMapping("/find/email")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByHospitalEmail(@RequestParam String hospitalemail) {
		return hospitalService.getHospitalByHospitalEmail(hospitalemail);
	}

	@ApiOperation(value = "Get Hospitals", notes = "Api is used to fetch all hospital ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully found"),
			@ApiResponse(code = 404, message = " hospitals not found") })
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<Hospital>> getAllHospital() {
		return hospitalService.getAllHospital();
	}

}
