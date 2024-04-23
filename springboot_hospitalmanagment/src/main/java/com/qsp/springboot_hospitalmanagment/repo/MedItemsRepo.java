package com.qsp.springboot_hospitalmanagment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalmanagment.dto.MedItems;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer> {

}
