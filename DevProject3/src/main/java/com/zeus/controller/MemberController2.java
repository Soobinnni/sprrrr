package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberController2 {

	@GetMapping("registerForm2")
	public String registerForm() {
		log.info("registerForm2");
		return "1/registerForm2";
	}

	@GetMapping("/register2/{userId}") //경로변수를 파라미터로 사용
	public String registerByPath(@PathVariable("userId") String userId) {
		log.info("registerByPath : /register2/{userId} ");
		log.info("userId = " + userId);
		return "success";
	}

	@GetMapping("/register2/{userId}/{coin}") //경로변수를 파라미터로 사용
	public String registerByPath(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
		log.info("registerByPath : /register2/{userId}/{coin}");
		log.info("userId = " + userId);
		log.info("coin = " + coin);
		return "success";
	}

	@PostMapping("/register21") //필드명과 매개변수의 이름이 같으면 파리미터로 사용 가능.
	public String register01(String userId) {
		log.info("register21 : userId");
		log.info("userId = " + userId);
		return "success";
	}

	@PostMapping("/register22") //특정 필드값을 파라미터로 사용. 이때 어노테이션으로 String의 파라미터를 필드 값으로 지정.
	public String register02(@RequestParam("userId") String username) {
		log.info("register22 : @RequestParam");
		log.info("userId = " + username);
		return "success";
	}

}
