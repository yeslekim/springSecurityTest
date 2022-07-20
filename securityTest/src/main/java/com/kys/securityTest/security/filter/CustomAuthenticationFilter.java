package com.kys.securityTest.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}
	
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    	// token의 principal(주로 id)와 credentials(주로 pw)를 지정
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(request.getParameter("userEmail"), request.getParameter("userPw"));
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
