package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member;
import lombok.extern.java.Log;

@Log
@Controller
public class MemberController5 {
	@GetMapping("/registerSpringFormInput01")
	public String registerSpringFormInput01(Model model) {
		log.info("registerSpringFormInput01");
		model.addAttribute("member", new Member());
		return "5/registerSpringFormInput"; // 뷰 파일명
	}

	@GetMapping("/registerSpringFormInput02")
	public String registerSpringFormInput02(Model model) {
		log.info("registerSpringFormInput02");
		Member member = new Member();
		
		//이렇게 보내면, 마치 <input type="text" name="email" value="aaa@ccc.com"
		//처럼 보내진다. (view가 일정 정해진다)
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		model.addAttribute("member", member);
		return "5/registerSpringFormInput";
	}

// 입력 처리
	@PostMapping("/register2")
	public String register(Member member) {
		//form의 데이터가 Member를 초기화하고, 이를 다시 view로 보내면
		//Member는 자바빈즈이므로 view로 값이 전달된다.
		log.info("register");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getUserName() = " + member.getUserName());
		log.info("member.getEmail() = " + member.getEmail());
		return "5/inputResult"; // 뷰 파일명
	}
}