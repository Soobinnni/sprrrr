package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeus.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController2 {
	
	/*
	 * Controller는 view의 요청 데이터를 여러 방식으로 전달받을 수 있지만
	 * Controller -> view의 기본형 데이터 전달은 Model 객체를 통해서만 가능
	 * Model전달 객체 대신, @ModelAttribute를 통해 Controller 파리미터명 == 표현언어변수
	 * 이면, Controller의 조작 데이터를 view에서 사용할 수 있다(기본 자료형).
	 * @ModelAttribute는 전달받은 매개변수를 강제로 Model에 담아서 전달하도록 할 때 사용
	 */
	
	@GetMapping(value = "/registerModelForm")
	public String registerModelForm() {
		log.info("registerModelForm");
		return "2/registerModelForm"; // 뷰 파일명
	}

	@PostMapping(value = "/registerModelForm01")
	public String registerModelForm01(String userId) {
		log.info("registerModelForm01");
		log.info("userId = " + userId); // view에서 null 출력
		return "2/registerModelForm01"; // 뷰 파일명
	}

	@PostMapping(value = "/registerModelForm02")
	public String registerModelForm02(@ModelAttribute("userId") String userId) {
		log.info("registerModelForm02");
		log.info("userId = " + userId); /* Model객체의 addAttribute없이도 
											@ModelAttribute어노테이션으로의 속성명으로 데이터 전달 가능 */
		return "2/registerModelForm02"; // 뷰 파일명
	}

	@PostMapping(value = "/registerModelForm03")
	public String registerModelForm03(@ModelAttribute("userId") String userId,
			@ModelAttribute("password") String password) {
		log.info("registerModelForm03");
		log.info("userId = " + userId);
		log.info("password = " + password);
		return "2/registerModelForm03"; // 뷰 파일명
	}

	/* 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 어노테이션 없이도 기본적으로 전달된다. 
	 * 표현언어에서 해당 객체를 찾는 법은 = class명에 첫 글자를 소문자로 바꾼 값이다
	 * 즉, 컨트롤러 메서드의 파리미터 명이 아니라 해당 인스턴스의 클래스명의 소문자!
	 * 두번째 대문자부터는 그대로 쓰면 된다.
	 * 
	 * 만일, 클래스명이 아니라 다른 key값으로 연결하고 싶으면
	 * @ModelAttribute("user") Model a처럼 이름을 다르게 지으면 된다.
	 */
	@PostMapping(value = "/registerModelForm04") 
	public String registerModelForm04(Member a/*, Model model*/) {
		log.info("registerModelForm04");
		log.info("userId = " + a.getUserId());
		log.info("password = " + a.getPassword());
		
		//model.addAttribute("member",member);
		return "2/registerModelForm04"; // 뷰 파일명
	}

}
