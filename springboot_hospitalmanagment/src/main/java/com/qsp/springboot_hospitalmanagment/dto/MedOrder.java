package com.qsp.springboot_hospitalmanagment.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MedOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medorderid;
	private String medorderdate;
	private String medorderdoctor;
	
	@ManyToOne
	Encounter encounter;

}
