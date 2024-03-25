package com.habitvault.exception;

public class BankAccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BankAccountNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
