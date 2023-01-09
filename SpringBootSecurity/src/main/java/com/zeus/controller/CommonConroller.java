package com.zeus.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonConroller {
	@RequestMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {

		/*
		 * Authentication클래스 : - 인증 관련 클래스. 인증과정에서 핵심으로 사용되는 객체다. - 이 클래스는 인증된 사용자
		 * 정보(사용자 이름과 부여된 권한 목록)이 포함되어 있다.
		 * 
		 * -hasrole과 roles의 역할이 부합하지 않으면, 접근을 제한토록 한다.
		 */
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "접근 불가");
	}
}