package com.qsp.springboot_hospitalmanagment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalmanagment.dao.BranchDao;
import com.qsp.springboot_hospitalmanagment.dao.EncounterDao;
import com.qsp.springboot_hospitalmanagment.dao.PersonDao;
import com.qsp.springboot_hospitalmanagment.dto.Branch;
import com.qsp.springboot_hospitalmanagment.dto.Encounter;
import com.qsp.springboot_hospitalmanagment.dto.Person;
import com.qsp.springboot_hospitalmanagment.exception.IdNotFoundException;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao dao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int personid, int branchid) {
		// TODO Auto-generated method stub
		Person person = personDao.getById(personid);
		Branch branch = branchDao.getBranchById(branchid);
		if (person != null && branch != null) {
			encounter.setPerson(person);
			List<Branch> list = new ArrayList<Branch>();
			list.add(branch);
			encounter.setBranch(list);
			ResponseStructure<Encounter> structure = new ResponseStructure<>();
			structure.setMessage("Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveEncounter(encounter));

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED);

		}
		throw new IdNotFoundException("person id or branch id not found for the encounter");
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int encounterid) {
		Encounter encounter = dao.getEncounterById(encounterid);
		if (encounter != null) {
			ResponseStructure<Encounter> structure = new ResponseStructure<>();
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Id not found for Encounter");
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int encounterid, Encounter encounter,
			int branchid) {
		Encounter dbEncounter = dao.getEncounterById(encounterid);
		Branch branch = branchDao.getBranchById(branchid);
		if (dbEncounter != null && branch != null) {
			List<Branch> branchs = dbEncounter.getBranch();
			branchs.add(branch);
			encounter.setBranch(branchs);
			encounter.setPerson(dbEncounter.getPerson());
			ResponseStructure<Encounter> structure = new ResponseStructure<>();
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEncounter(encounterid, encounter));

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException("encounter id or branch id not found for the encounter");

	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		Encounter encounter = dao.deleteEncounterById(id);
		if (encounter != null) {
			ResponseStructure<Encounter> structure = new ResponseStructure<>();
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounter);

			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Encounter");
		}
	}

}
