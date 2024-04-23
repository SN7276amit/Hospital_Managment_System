package com.qsp.springboot_hospitalmanagment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalmanagment.dto.Encounter;
import com.qsp.springboot_hospitalmanagment.dto.MedOrder;
import com.qsp.springboot_hospitalmanagment.repo.MedOrderRepo;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepo repo;
	@Autowired
	private EncounterDao dao;

	public MedOrder saveMedOrder(MedOrder medOrder, int eid) {
		Encounter encounter = dao.getEncounterById(eid);
		medOrder.setEncounter(encounter);
		return repo.save(medOrder);
	}

	public MedOrder updateMedOrder(int id, MedOrder medOrder) {
		if (repo.findById(id).isPresent()) {
			medOrder.setMedorderid(id);
			return repo.save(medOrder);
		} else {
			return null;
		}
	}

	public MedOrder getMedOrderById(int id) {
		return repo.findById(id).get();
	}

	public MedOrder deleteMedOrder(int id) {
		if (repo.findById(id).isPresent()) {
			MedOrder medOrder = repo.findById(id).get();
			repo.deleteById(id);
			return medOrder;
		} else {
			return null;
		}
	}
}
