package com.explorer.fetchcountryattractionservice.exceptions;


@SuppressWarnings("serial")
public class FetchedCountryNotFoundException extends Exception {
	
	public FetchedCountryNotFoundException(String message) {
		super(message);
	}

}
