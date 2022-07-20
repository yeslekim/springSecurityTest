package com.kys.securityTest.security.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.kys.securityTest.model.dto.UserDetailsDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private final UserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// :: 실제 인증에 대한 로직 (DB에서 조회 후 로그인 로직 실행) ::
		// 인증 전의 Authentication객체를 받아서 인증이 완료된 객체를 반환하는 역할
		
		// AuthenticationFilter에서 생성된 토큰으로부터 아이디와 비밀번호를 조회함
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String userEmail = token.getName();	
		String userPw = (String) token.getCredentials();
		
		UserDetailsDTO uDTO = (UserDetailsDTO) userDetailsService.loadUserByUsername(userEmail);
		
		if(!uDTO.getPassword().equals(userPw)) {
			throw new BadCredentialsException(uDTO.getUserEmail() + "Invalid password");
		}
		
		return new UsernamePasswordAuthenticationToken(uDTO, userPw, uDTO.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
