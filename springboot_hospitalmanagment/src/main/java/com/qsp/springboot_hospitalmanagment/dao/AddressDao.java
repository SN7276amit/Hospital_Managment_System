package com.qsp.springboot_hospitalmanagment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalmanagment.dto.Address;
import com.qsp.springboot_hospitalmanagment.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo repo;

	public Address saveAddress(Address address) {
		return repo.save(address);
	}

	public Address updateAddress(int id, Address address) {
		if (repo.findById(id).isPresent()) {
			address.setAddressid(id);
			return repo.save(address);
		} else {
			return null;
		}
	}

	public Address deleteAddress(int id) {
		if (repo.findById(id).isPresent()) {
			Address address = repo.findById(id).get();
			repo.deleteById(id);
			return address;
		} else {
			return null;
		}
	}

	public Address getAddressById(int id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

}
