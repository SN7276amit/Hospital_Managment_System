package com.qsp.springboot_hospitalmanagment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalmanagment.dto.Encounter;

public interface EncounterRepo  extends JpaRepository<Encounter, Integer>{

}
