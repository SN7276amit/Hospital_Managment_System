package com.qsp.springboot_hospitalmanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalmanagment.dao.AddressDao;
import com.qsp.springboot_hospitalmanagment.dto.Address;
import com.qsp.springboot_hospitalmanagment.exception.IdNotFoundException;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		Address dbAddress = dao.updateAddress(id, address);
		if (dbAddress != null) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Address");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address address = dao.deleteAddress(id);
		if (address != null) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Address");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {
		Address address = dao.getAddressById(id);
		if (address != null) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Address");
		}
	}

}
