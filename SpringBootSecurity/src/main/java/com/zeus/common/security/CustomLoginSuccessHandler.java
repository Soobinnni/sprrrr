package com.zeus.common.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import lombok.extern.java.Log;

@Log
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	/*
	 * AuthenticationSuccessHandler구현하기
	 * SavedRequestAwareAuthenticationSuccessHandler는
	 * AuthenticationSuccessHandler인터페이스를 구현한 class
	 * 
	 * 
	 * onAuthenticationSuccess메서드
	 * 
	 * Authentication은 이곳이 인증과 관련된 클래스이므로 또 등장.
	 * 
	 * onAuthenticationSuccess
	 * - 사용자가 성공적으로 인증되었을 때 호출되어 성공했을 때의 기능을 처리하는 것을 정의한다.
	 * - onAuthenticationSuccess의 메서드 파라미터 (HttpServletRequest request, HttpServletResponse response, Authentication auth)
	 * - request : 인증성공의 원인이 된 요청
	 * - response : 인증성공에 대한 응답
	 * - auth : 인증 프로세스 중 생성된 객체
	 * 
	 */

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		log.info("onAuthenticationSuccess");
		User customUser = (User) auth.getPrincipal();
		log.info("username = " + customUser.getUsername());
		
		/* SavedRequestAwareAuthenticationSuccessHandler의 onAuthenticationSuccess
		 * 상위 클래스 handle() 메서드를 호출하여 대상 URL로 전달하거나 리디렉션한 다음 
		 * clearAuthenticationAttributes()를 호출하여 남은 세션 데이터를 제거합니다.
		 */
		super.onAuthenticationSuccess(request, response, auth);
	}
}