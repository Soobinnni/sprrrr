package com.zeus.common.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import lombok.extern.java.Log;


/*
 * ② 로그인 성공 처리자 2
 * AuthenticationSuccessHandler 인터페이스를 직접 구현하여 인증 전에 접근을 시도한 URL 로
 * 리다이렉트하는 기능을 구현한다
 */
@Log
public class CustomLoginSuccessHandler2 implements AuthenticationSuccessHandler {
	//RequestCache : 인증 메커니즘으로 리디렉션한 후 단일 요청을 검색하고 다시 시작할 수 있도록 "저장된 요청" 논리를 구현합니다.
	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		log.info("onAuthenticationSuccess2");
		
		User customUser = (User) auth.getPrincipal();
		log.info("username = " + customUser.getUsername());
		//사용자 정의 메소드 : session attribute(request : 인증성공의 원인이 된 요청)를 제거. 로그인에 성공하면, 과거 session이 제거된다.
		clearAuthenticationAttribute(request);
		
		/* SavedRequest
		 * 원본 URL로 리디렉션하는 인증 메커니즘(일반적으로 양식 기반 로그인)과 
		 * 래핑된 요청을 작성하는 RequestCache에 대한 캐시된 요청에 필요한 기능을 캡슐화하여 원본 요청 데이터를 재생산합니다.
		 * 
		 * RequestCache객체.getRequest(request, response)
		 * 저장된 요청을 반환하고 캐시된 상태로 둡니다.
		 * 매개변수: request-현재요청, return 정보: SavedRequest / 이전에 캐시된 저장된 요청 또는 없는 경우 null입니다.
		 */
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		//getRedirectUrl : return String. 리디렉션을 수행할 수 있도록 저장된 요청의 URL입니다(로그인 이전의 URL).
		String targetUrl = savedRequest.getRedirectUrl();
		
		log.info("Login Success targetUrl = " + targetUrl);
		
		response.sendRedirect(targetUrl);
	}
 
	private void clearAuthenticationAttribute(HttpServletRequest request) {
		//getSession()메서드에 인수를 boolean값을 받아냄으로써 id가 일치 않을 경우 아예 session을 생성하지 않는 방법
		HttpSession session = request.getSession(false);
		if (session == null) {
			return; 
		}
		//WebAttributes의 static final String AUTHENTICATION_EXCEPTION : 세션에서 인증 실패 예외를 캐시하는 데 사용됩니다.
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION); //인증 실패 예외캐시를 지움.
	}
}