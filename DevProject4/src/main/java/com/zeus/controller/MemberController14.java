package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member;
import lombok.extern.java.Log;

/*
 * [입력값 검증 에러]
 * 1) 전달 (바인딩) 객체 즉 유효성 검증을 하고자하는 객체의 필드 멤버에 입력값을 검증할
 * 수 있도록 애너테이션을 붙인다.
 * 
 * 2) Controller 메서드에 속한 1) 파리미터에 @Validated 애너테이션을 붙여 필드의
 * 애너테이션을 불러온다.
 * 
 * 3) Controller 메서드 파라미터에 요청 데이터의 바인딩 오류와 입력값 검증 에러정보를 저장하는
 * BindingResult 객체를 둔다. 이 객체로 에러를 처리한다.
 * 
 * 4) <form:errors> 태그  : 에러 정보를 추가하는 용도. path속성을 통해 커맨드 객체의
 * 특정 프로퍼티와 관련된 에러메시지를 출력한다. 지정한 프로퍼티와 관련된 한 개 이상의
 * 에러메시지를 출력한다.
 * --------------------------------------------------------------------
 * [Spring form 유효성 검사(Spring Validator)
 * *Binding
 */

@Log
@Controller
public class MemberController14 {
	@RequestMapping(value = "/registerSpringFormErrors", method = RequestMethod.GET)
	public String registerSpringFormErrors(Model model) {
		log.info("registerSpringFormErrors");
		Member member = new Member();
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		model.addAttribute("member", member);
		return "14/registerSpringFormErrors"; // 뷰 파일명
	}

// 입력 처리
	@RequestMapping(value = "/register14", method = RequestMethod.POST)
	public String register(@Validated Member member, BindingResult result) {
		log.info("register");
		// 에러 처리
		if (result.hasErrors()) {
			return "14/registerSpringFormErrors";
		}
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getUserName() = " + member.getUserName());
		log.info("member.getEmail() = " + member.getEmail());
		return "14/errorsResult";
	}
}