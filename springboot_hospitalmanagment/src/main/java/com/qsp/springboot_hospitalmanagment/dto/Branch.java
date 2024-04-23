package com.qsp.springboot_hospitalmanagment.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchid;
	private String branchname;
	private String branchmanager;
	
	@ManyToOne
	Hospital hospital;
	@OneToOne
	Address  address;

}
