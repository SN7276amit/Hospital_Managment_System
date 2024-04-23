package com.qsp.springboot_hospitalmanagment.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalid;
	private String hospitalname;
	@Column(unique = true)
	private String hospitalemail;
	private String hospitalceo;

}
