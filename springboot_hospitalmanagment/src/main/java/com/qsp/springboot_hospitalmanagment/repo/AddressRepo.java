package com.qsp.springboot_hospitalmanagment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalmanagment.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
