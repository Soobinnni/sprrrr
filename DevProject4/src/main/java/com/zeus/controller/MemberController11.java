package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member;
import lombok.extern.java.Log;

/*
 * [<form:radiobutton>]
 * 라디오 버튼 요소
 * 스프링 폼 태그로 라디오 버튼 요소를 출력하려면 <form:radiobutton>를 사용한다
 * 
 * ① 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다
 * ② 객체를 생성하여 값을 설정한 후에 전달한다.
 * 
 * <form:radiobuttons>와 다른 점 : radiobuttons는 controller에서 view의 radio의 구성을 보낸 것.
 * 따라서 <form:radiobuttons>은 item속성이 필요하다.
 * 반면, <form:radiobutton>은 item속성은 필요하지 않다.
 */
@Log
@Controller
public class MemberController11 {
	@RequestMapping(value = "/registerSpringFormRadiobutton01", method = RequestMethod.GET)
	public String registerSpringFormRadiobutton01(Model model) {
		log.info("registerSpringFormRadiobutton01");
		model.addAttribute("member", new Member());
		return "11/registerSpringFormRadiobutton"; // 뷰 파일명
	}

	@RequestMapping(value = "/registerSpringFormRadiobutton02", method = RequestMethod.GET)
	public String registerSpringFormRadiobutton02(Model model) {
		log.info("registerSpringFormRadiobutton02");
		Member member = new Member();
		member.setGender("female");
		model.addAttribute("member", member);
		return "11/registerSpringFormRadiobutton";
	}

	// 입력 처리
	@RequestMapping(value = "/register11", method = RequestMethod.POST)
	public String register(Member member, Model model) {
		log.info("register");
		log.info("member.getGender() = " + member.getGender());
		model.addAttribute("member", member);
		return "11/radiobuttonResult";
	}
}