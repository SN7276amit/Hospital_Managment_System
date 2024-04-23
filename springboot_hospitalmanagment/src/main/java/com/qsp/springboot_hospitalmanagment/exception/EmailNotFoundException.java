package com.qsp.springboot_hospitalmanagment.exception;

public class EmailNotFoundException extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public EmailNotFoundException(String message) {
		this.message = message;
	}

}
