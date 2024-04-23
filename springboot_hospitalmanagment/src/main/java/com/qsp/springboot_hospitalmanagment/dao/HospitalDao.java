package com.qsp.springboot_hospitalmanagment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalmanagment.dto.Hospital;
import com.qsp.springboot_hospitalmanagment.repo.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo hospitalRepo;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}

	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional = hospitalRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Hospital deleteHospital(int id) {
		Optional<Hospital> optional = hospitalRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Hospital hospital = optional.get();
		hospitalRepo.delete(hospital);
		return hospital;
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		Optional<Hospital> optional = hospitalRepo.findById(id);
		if (optional.isPresent()) {
			hospital.setHospitalid(id);
			hospitalRepo.save(hospital);
		}
		return null;

	}

	public Hospital getHospitalByHospitalEmail(String hospitalemail) {
		return hospitalRepo.findHospitalByHospitalemail(hospitalemail);
	}

	public List<Hospital> getAllHospital() {
		return hospitalRepo.findAll();
	}

}
