package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.domain.Member;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberController3 {
	@RequestMapping(value = "/registerForm3", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm3");
		return "1/registerForm3";
	}
	
	/*
	 * Member는 폼의 필드이름과 Member의 필드변수명이 일치할 때 필드의 값으로 초기화될 수 있다.
	*/
	@RequestMapping(value = "/registerbeans01", method = RequestMethod.POST)
	public String registerbeans01(Member member) {
		log.info("registerBeans");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getCoin() = " + member.getCoin());
		return "success";
	}
	/*
	 * Member는 폼의 필드이름과 Member의 필드변수명이 일치할 때 필드의 값으로 초기화될 수 있다.
	 * int coin은 필드명과 매개변수명이 일치할 때 파라미터로 쓰일 수 있음을 이용한 것이다.	
	 */
	@RequestMapping(value = "/registerbeans02", method = RequestMethod.POST)
	public String registerbeans02(Member member, int coin, String exam) {
		log.info("registerBeans");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getCoin() = " + member.getCoin());
		log.info("coin = " + coin);
		log.info("exam = "+exam);
		return "success";
	}
}
