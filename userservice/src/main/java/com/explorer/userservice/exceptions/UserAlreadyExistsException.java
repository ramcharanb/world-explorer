package com.explorer.userservice.exceptions;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {

	public UserAlreadyExistsException(String message){
		super(message);
	}
}
