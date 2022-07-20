package com.kys.securityTest.security.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

// AuthenticationProvider를 통해 인증이 성공될 경우 처리
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		
		// token을 사용하지 않고 세션을 활용하기 때문에 성공하여 반환된 Authentication객체를 SecurityContextHolder의 Contetx에 저장해주어야 한다.
		// 나중에 사용자의 정보를 꺼낼 경우에도 SecurityContextHolder의 Context에서 조회하면 된다.
		SecurityContextHolder.getContext().setAuthentication(authentication);
		response.sendRedirect("/about");
	}
}
