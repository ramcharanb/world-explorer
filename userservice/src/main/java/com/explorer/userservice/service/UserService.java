package com.explorer.userservice.service;



import com.explorer.userservice.exceptions.UserAlreadyExistsException;
import com.explorer.userservice.exceptions.UserNotFoundException;
import com.explorer.userservice.model.User;

public interface UserService {

	public boolean saveUser(User user) throws UserAlreadyExistsException;
	
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;
}
