package com.explorer.userservice.service;

import com.explorer.userservice.model.User;
import java.util.Map;

public interface SecurityTokenGenerator {

	Map<String,String> generateToken(User user);
}
