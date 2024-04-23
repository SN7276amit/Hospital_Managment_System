package com.qsp.springboot_hospitalmanagment.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalmanagment.dto.MedItems;
import com.qsp.springboot_hospitalmanagment.dto.MedOrder;
import com.qsp.springboot_hospitalmanagment.repo.MedItemsRepo;
@Repository
public class MedItemsDao {
	@Autowired
	private MedItemsRepo repo;
	@Autowired
	private MedOrderDao dao;

	public MedItems saveMedItems(MedItems medItems, int mid) {
		MedOrder medOrder = dao.getMedOrderById(mid);
		medItems.setMedOrder(medOrder);
		return repo.save(medItems);
	}

	public MedItems updateMedItems(int id, MedItems medItems) {
		if (repo.findById(id).isPresent()) {
			medItems.setMeditemid(id);
			return repo.save(medItems);
		} else {
			return null;
		}
	}

	public MedItems getMedItemsById(int id) {
		return repo.findById(id).get();
	}

	public MedItems deleteMedItems(int id) {
		if (repo.findById(id).isPresent()) {
			MedItems medItems = repo.findById(id).get();
			repo.deleteById(id);
			return medItems;
		} else {
			return null;
		}
	}
}
