package com.qsp.springboot_hospitalmanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalmanagment.dao.MedItemsDao;
import com.qsp.springboot_hospitalmanagment.dto.MedItems;
import com.qsp.springboot_hospitalmanagment.exception.IdNotFoundException;
import com.qsp.springboot_hospitalmanagment.util.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	private MedItemsDao dao;

	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems medItems, int mid) {
		ResponseStructure<MedItems> structure = new ResponseStructure<>();
		structure.setMessage("Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMedItems(medItems, mid));
		return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(int id, MedItems medItems) {
		MedItems dbMedItems = dao.getMedItemsById(id);
		medItems.setMedOrder(dbMedItems.getMedOrder());
		MedItems daoMedItems = dao.updateMedItems(id, medItems);
		if (daoMedItems != null) {
			ResponseStructure<MedItems> structure = new ResponseStructure<>();
			structure.setMessage("Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoMedItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for MedItems");
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> getMedItemsById(int id) {
		MedItems medItems = dao.getMedItemsById(id);
		if (medItems != null) {
			ResponseStructure<MedItems> structure = new ResponseStructure<>();
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Id not found for MedItems");
		}
	}

	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int id) {
		MedItems medItems = dao.deleteMedItems(id);
		if (medItems != null) {
			ResponseStructure<MedItems> structure = new ResponseStructure<>();
			structure.setMessage("Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medItems);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for MedItems");
		}
	}
}
