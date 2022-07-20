package com.kys.securityTest.model.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kys.securityTest.model.dto.UserDetailsDTO;
import com.kys.securityTest.model.repository.UserRepository;
import com.kys.securityTest.security.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		return userRepository.findByUserEmail(userEmail)
				.map(
						u -> new UserDetailsDTO(
								u, Collections.singleton(
										new SimpleGrantedAuthority(
												u.getRole().getValue()
												)
										)
								)
						)
				.orElseThrow(() -> new UserNotFoundException(userEmail));
	}
}
