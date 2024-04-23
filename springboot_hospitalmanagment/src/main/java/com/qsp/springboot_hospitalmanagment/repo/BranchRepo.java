package com.qsp.springboot_hospitalmanagment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalmanagment.dto.Address;
import com.qsp.springboot_hospitalmanagment.dto.Branch;
import com.qsp.springboot_hospitalmanagment.dto.Hospital;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
	
	List<Branch> findBranchByHospital(Hospital hospital);

	List<Branch> findBranchByAddress(Address address);

	List<Branch> findBranchByBranchname(String branchname);


}
