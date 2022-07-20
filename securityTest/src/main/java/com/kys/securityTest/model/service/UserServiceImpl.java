package com.kys.securityTest.model.service;

import org.springframework.stereotype.Service;

import com.kys.securityTest.model.dto.UserDTO;
import com.kys.securityTest.model.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDTO login(UserDTO userDTO) {
		return userRepository.findByUserEmailAndUserPw(userDTO.getUserEmail(), userDTO.getUserPw());
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		return userRepository.save(userDTO);
	}

	@Override
	public UserDTO findUserByUserEamil(String userEmail) {
		return userRepository.findByUserEmail(userEmail).get();
	}

}
