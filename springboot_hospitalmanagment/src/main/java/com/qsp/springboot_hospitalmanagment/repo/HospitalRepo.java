package com.qsp.springboot_hospitalmanagment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalmanagment.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

	Hospital findHospitalByHospitalemail(String hospitalemail);
}
