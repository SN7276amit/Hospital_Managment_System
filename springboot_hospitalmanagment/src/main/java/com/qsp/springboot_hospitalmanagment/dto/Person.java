package com.qsp.springboot_hospitalmanagment.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personid;
	private String personname;
	@Column(unique = true)
	private long personphone;
	@Column(unique = true)
	private String personemail;
	private String personaddress;
	

}
