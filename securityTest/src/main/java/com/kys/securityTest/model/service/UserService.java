package com.kys.securityTest.model.service;

import com.kys.securityTest.model.dto.UserDTO;

public interface UserService {
	
	UserDTO login(UserDTO userDTO);
	
	UserDTO createUser(UserDTO userDTO);
	
	UserDTO findUserByUserEamil(String userEmail);
}
