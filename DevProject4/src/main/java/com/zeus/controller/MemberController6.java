package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member;
import lombok.extern.java.Log;


/*
 * <form:password> 
 * - <form:form>의 하위태그로, <input type="password" />와 같은 기능을 한다.
 * - 다른 기능은 <form:input>과 같다.
 */
@Log
@Controller
public class MemberController6 {
	@RequestMapping(value = "/registerSpringFormPassword01", method = RequestMethod.GET)
	public String registerSpringFormPassword01(Model model) {
		log.info("registerForm01");
		model.addAttribute("member", new Member());
		return "6/registerSpringFormPassword"; // 뷰 파일 명
	}

	@RequestMapping(value = "/registerSpringFormPassword02", method = RequestMethod.GET)
	public String registerSpringFormPassword02(Model model) {
		log.info("registerSpringFormPassword02");
		Member member = new Member();
		
		//set하므로써 일정 폼의 내용을 채워서 보내게 된다.
		member.setPassword("1234");
		member.setUserId("xxx");
		model.addAttribute("member", member);
		return "6/registerSpringFormPassword"; // 뷰 파일 명
	}

// 입력 처리
	@RequestMapping(value = "/register3", method = RequestMethod.POST)
	public String register(Member member) {
		log.info("register");
		log.info("member.getPassword() = " + member.getPassword());
		return "6/passwordResult";
	}
}