package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.java.Log;

@Log
@Controller
public class LoginController {
// 에러 메시지와 로그아웃 메시지를 파라미터로 사용한다.
	@RequestMapping("/login")
	public String loginForm(String error, String logout, Model model) {
		log.info("error: " + error); // .loginPage("/login")은 제공된 URL + "?error"에서 인증 오류를 받아낸다.
		log.info("logout: " + logout);
		if (error != null) {
			model.addAttribute("error", "로그인 에러!!!");
		}
		if (logout != null) {
			//HttpSecurity객체의 logout()메서드는 로그아웃에 성공하면 login?success로 리디렉션한다.
			model.addAttribute("logout", "로그아웃!!!");
		}
		return "loginForm";
	}

	@RequestMapping("/logout")
	public String logoutForm() {
		log.info("logoutForm");
		return "logoutForm";
	}
}