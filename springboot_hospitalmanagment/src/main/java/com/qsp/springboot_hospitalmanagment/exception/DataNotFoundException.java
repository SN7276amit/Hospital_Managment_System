package com.qsp.springboot_hospitalmanagment.exception;

public class DataNotFoundException  extends RuntimeException{
	private String message;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public DataNotFoundException(String message) {
		this.message = message;
	}

}
