package com.explorer.favservice.exceptions;

@SuppressWarnings("serial")
public class CountryAlreadyExistsException extends Exception {
	
	public CountryAlreadyExistsException(String message) {
		super(message);
	}
}
