package com.qsp.springboot_hospitalmanagment.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MedItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int meditemid;
	private String meditemname;
	private double meditemprice;
	@ManyToOne
	MedOrder medOrder;
	

}
