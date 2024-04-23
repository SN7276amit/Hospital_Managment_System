package com.qsp.springboot_hospitalmanagment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalmanagment.dto.Address;
import com.qsp.springboot_hospitalmanagment.dto.Branch;
import com.qsp.springboot_hospitalmanagment.dto.Hospital;
import com.qsp.springboot_hospitalmanagment.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepo branchRepo;
	@Autowired
	private HospitalDao dao;
	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(Branch branch, int hospitalId,int addressId) {
		Hospital hospital = dao.getHospitalById(hospitalId);
		branch.setHospital(hospital);
		Address address = addressDao.getAddressById(addressId);
		branch.setAddress(address);
		return branchRepo.save(branch);
	}

	public Branch getBranchById(int id) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Branch> findBranchByHospital(int hospitalid) {
		Hospital hospital = dao.getHospitalById(hospitalid);
		return branchRepo.findBranchByHospital(hospital);
	}

	public Branch updateBranch(int branchid,Branch branch) {

		Branch dbBranch = branchRepo.findById(branchid).get();
		if (dbBranch != null) {
			branch.setBranchid(branchid);
			branch.setHospital(dbBranch.getHospital());
			branch.setAddress(dbBranch.getAddress());
			return branchRepo.save(branch);
		} else {
			return null;
		}

	}

	public List<Branch> findBranchByAddress(Address address) {
		return branchRepo.findBranchByAddress(address);
	}

	public List<Branch> findBranchByName(String branchname) {
		// TODO Auto-generated method stub
		return branchRepo.findBranchByBranchname(branchname);
	}
	public Branch deleteBranch(int id) {
		if (branchRepo.findById(id).isPresent()) {
			Branch branch = branchRepo.findById(id).get();
			branchRepo.deleteById(id);
			return branch;
		} else {
			return null;
		}
	}


}
