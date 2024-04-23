package com.qsp.springboot_hospitalmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalmanagment.dao.HospitalDao;
import com.qsp.springboot_hospitalmanagment.dto.Hospital;
import com.qsp.springboot_hospitalmanagment.exception.DataNotFoundException;
import com.qsp.springboot_hospitalmanagment.exception.EmailNotFoundException;
import com.qsp.springboot_hospitalmanagment.exception.IdNotFoundException;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		structure.setMessage("Hospital saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		Hospital hospital = hospitalDao.getHospitalById(id);
		if (hospital != null) {
			structure.setMessage("Hospital Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);

		} else {
			throw new IdNotFoundException("Hospital with given id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		Hospital hospital = hospitalDao.deleteHospital(id);
		if (hospital != null) {
			structure.setMessage("Hospital Delete Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);

		} else {
			throw new IdNotFoundException("Hospital with given id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		Hospital hospital2 = hospitalDao.updateHospital(id, hospital);
		if (hospital2!= null) {
			structure.setMessage("Hospital Update Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital2);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Hospital with given id Not Found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByHospitalEmail(String hospitalemail) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		Hospital hospital = hospitalDao.getHospitalByHospitalEmail(hospitalemail);
		if (hospital != null) {
			structure.setMessage("Hospital Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);
		} else {
			throw new EmailNotFoundException("hospital with given email mot found");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getAllHospital() {
		ResponseStructure<List<Hospital>> structure = new ResponseStructure<>();

		List<Hospital> list = hospitalDao.getAllHospital();
		if (list.isEmpty()) {
			structure.setMessage("No data available");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<Hospital>>(HttpStatus.NOT_FOUND);
		} else {
			 throw new DataNotFoundException("no hospitals found"); 
		}

	}

}
