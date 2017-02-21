package com.example.service.exception;

public class ServiceException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 9030189487046753178L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
