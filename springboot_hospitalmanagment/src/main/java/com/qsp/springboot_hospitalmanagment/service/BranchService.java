package com.qsp.springboot_hospitalmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalmanagment.dao.AddressDao;
import com.qsp.springboot_hospitalmanagment.dao.BranchDao;
import com.qsp.springboot_hospitalmanagment.dto.Address;
import com.qsp.springboot_hospitalmanagment.dto.Branch;
import com.qsp.springboot_hospitalmanagment.exception.DataNotFoundException;
import com.qsp.springboot_hospitalmanagment.exception.IdNotFoundException;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hospitalid, int addressid, Branch branch) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(branchDao.saveBranch(branch, hospitalid, addressid));
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchByBranchID(int branchid) {
		Branch branch = branchDao.getBranchById(branchid);
		if (branch != null) {
			ResponseStructure<Branch> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Branch");
		}	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospital(int hospitalid) {
		List<Branch>branchs=branchDao.findBranchByHospital(hospitalid);
		if (branchs !=null) {
			ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branchs);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int branchid, Branch branch) {
		Branch dbBranch = branchDao.updateBranch(branchid, branch);
		if (dbBranch != null) {
			ResponseStructure<Branch> structure = new ResponseStructure<>();
			structure.setMessage("Successfylly Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Branch");
		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByAddress(int addressid) {
		  Address address=addressDao.getAddressById(addressid);
		if (address != null) {
			List<Branch>branchs =branchDao.findBranchByAddress(address);
			ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branchs);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
		}
		throw new DataNotFoundException("address not found for Branch");	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByName(String Branchname) {
		List<Branch>branchs=branchDao.findBranchByName(Branchname);
		if (branchs !=null) {
			ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branchs);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
		} else {
			throw new DataNotFoundException("address not found for branchs");
		}
	}
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		Branch branch = branchDao.deleteBranch(id);
		if (branch != null) {
			ResponseStructure<Branch> structure = new ResponseStructure<>();
			structure.setMessage("Successfylly Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Branch");
		}
	}

}
