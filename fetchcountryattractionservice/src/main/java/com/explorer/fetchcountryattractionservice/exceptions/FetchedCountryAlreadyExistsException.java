package com.explorer.fetchcountryattractionservice.exceptions;


@SuppressWarnings("serial")
public class FetchedCountryAlreadyExistsException extends Exception {
	
	public FetchedCountryAlreadyExistsException(String message) {
		super(message);
	}
}
