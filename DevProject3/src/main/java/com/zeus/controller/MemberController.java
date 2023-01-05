package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberController {

	//<a href = "register?userId=hong&password=1234">...</a>
	// @GetMapping("/registerForm")
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm");
		return "1/registerForm";
	}

	// @GetMapping("/register") : 폼 필드의 name의 값과 컨트롤러 매개변수명이 일치할 때, param가능
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerByParameter(String userId, String password) {
		log.info("registerByParameter");
		log.info("userId : " + userId);
		log.info("password : " + password);
		return "success";
	}

	// @GetMapping("/register/{userId}") : 경로변수를 사용할 때. 반드시 어노테이션 @PathVariable을 사용하여 연결. 어노테이션이 없으면 null
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId) {
		log.info("registerByPath");
		log.info("userId = " + userId);
		return "success";
	}

	// @PostMapping("/register01") : 폼 필드의 name의 값과 컨트롤러 매개변수명이 일치할 때.
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		log.info("HTML 폼 필드명과 컨트롤러 매개변수명이 일치 register01");
		log.info("userId = " + userId);
		return "success";
	}
	
	// @PostMapping("/register02") : 폼 필드의 name의 값과 컨트롤러 매개변수명이 일치할 때.
	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(String userId, String password) {
		log.info("HTML 폼 필드가 여러 개일 경우 register02");
		log.info("userId = " + userId);
		log.info("password = " + password);
		return "success";
	}
	
	// @PostMapping("/register03") : 폼 필드의 name의 값과 컨트롤러 매개변수명이 일치할 때.
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public String register03(String password, String userId) {
		log.info("컨트롤러 매개변수의 위치 register03");
		log.info("userId = " + userId);
		log.info("password = " + password);
		return "success";
	}

	// @PostMapping("/register04") : 폼 필드의 name의 값과 컨트롤러 매개변수명이 일치할 때.
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public String register04(String userId, String password, String coin) {
		log.info("HTML 폼 필드값이 숫자일 경우 register04");
		log.info("userId = " + userId);
		log.info("password = " + password);
		log.info("coin = " + coin);
		return "success";
	}

	// @PostMapping("/register04") : 폼 필드의 name의 값과 컨트롤러 매개변수명이 일치할 때.
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public String register05(String userId, String password, int coin) {
		log.info("숫자형이면 숫자로 타입변환 register05");
		log.info("userId = " + userId);
		log.info("password = " + password);
		log.info("coin = " + coin);
		//또는 String으로 받아서 int coinInt = Integer.parse(coin);
		return "success";
	}

}
