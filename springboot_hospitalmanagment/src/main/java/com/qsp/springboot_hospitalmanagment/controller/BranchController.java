package com.qsp.springboot_hospitalmanagment.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.qsp.springboot_hospitalmanagment.dto.Branch;
import com.qsp.springboot_hospitalmanagment.service.BranchService;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	private BranchService branchService;

	@ApiOperation(value = "Save Branch", notes = "Api is used to save branch using hospital_id & address_id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved"),
			@ApiResponse(code = 404, message = "Id not found for hospital or address") })
	@PostMapping("/branch/hospitalid/addressid")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestParam int hospitalid, @RequestParam int addressid, @RequestBody Branch branch) {
		return branchService.saveBranch(hospitalid, addressid, branch);
	}

	@ApiOperation(value = "Get Branch By Id", notes = "Api is used to fetch branch using branch_id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "Id not found for branch") })
	@GetMapping("/branch/branchid")
	public ResponseEntity<ResponseStructure<Branch>> getBranchByBranchID(@RequestParam int branchid) {
		return branchService.getBranchByBranchID(branchid);
	}

	@ApiOperation(value = "Get Branch By Hospital Id", notes = "Api is used to fetch branch using hospital_id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "Id not found for hospital") })
	@GetMapping("/{hid}")
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospital(@PathVariable int hospitalid) {
		return branchService.findBranchByHospital(hospitalid);
	}

	@ApiOperation(value = "Update Branch", notes = "Api is used to update branch using branch_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Id not found for branch") })
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int branchid, @RequestBody Branch branch) {
		return branchService.updateBranch(branchid, branch);
	}

	@ApiOperation(value = "Get Branch By address Id", notes = "Api is used to fetch branch using address")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "address not found for branch") })
	@GetMapping("address")
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByAddress(@RequestParam int addressid) {
		return branchService.findBranchByAddress(addressid);
	}

	@ApiOperation(value = "Get Branch By name", notes = "Api is used to fetch branch using name")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "name not found for branch") })
	@GetMapping("/name")
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByName(@RequestParam String branchname) {
		return branchService.findBranchByName(branchname);
	}
	
	@ApiOperation(value = "Delete Branch", notes = "Api is used to delete branch using branch_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Id not found for branch") })
	@DeleteMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@Valid @RequestParam int id) {
		return branchService.deleteBranch(id);
	}

}
