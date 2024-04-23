package com.qsp.springboot_hospitalmanagment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalmanagment.dto.Encounter;
import com.qsp.springboot_hospitalmanagment.repo.EncounterRepo;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepo encounterRepo;

	public Encounter saveEncounter(Encounter encounter) {
		// TODO Auto-generated method stub
		return encounterRepo.save(encounter);
	}

	public Encounter getEncounterById(int encounterid) {
		Optional<Encounter> optional = encounterRepo.findById(encounterid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Encounter updateEncounter(int encounterid,Encounter encounter) {
		if (encounterRepo.findById(encounterid).isPresent()) {
			encounter.setEncounterid(encounterid);
			return encounterRepo.save(encounter);
		} else {
			return null;
		}
	}
	public Encounter deleteEncounterById(int id) {
		if (encounterRepo.findById(id).isPresent()) {
			Encounter encounter = encounterRepo.findById(id).get();
			encounterRepo.deleteById(id);
			return encounter;
		} else {
			return null;
		}
	}

}
