package com.hera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/board2")
public class paramController {
	// params 예제

	// get의 params
	@GetMapping(value = "/get", params = "register") // == get?register
	public String registerForm() {
		log.info("params 파라미터 GET 방식 등록 폼");
		return "board2/register";
	}

	// post의 params
	@PostMapping(value = "/post", params = "register") // == get?register
	public String register() {
		log.info("params 파라미터 POST 방식 등록 폼");
		return "board2/list";
	}

	@GetMapping(value = "/get", params = "modify") //get?modify
	public String modifyForm() {
		log.info("params 파라미터 GET 방식 수정 폼");
		return "board2/modify";
	}

	@PostMapping(value = "/post", params = "modify")
	public String modify() {
		log.info("params 파라미터 POST 방식 수정");
		return "board2/list";
	}

	@GetMapping(value = "/get", params = "remove")
	public String removeForm() {
		log.info("params 파라미터 GET 방식 삭제 폼");
		return "board2/remove";
	}

	@PostMapping(value = "/post", params = "remove")
	public String remove() {
		log.info("params 파라미터 POST 방식 삭제");
		return "board2/list";
	}

	@GetMapping(value = "/get", params = "list")
	public String list() {
		log.info("params 파라미터 GET 방식 목록");
		return "board2/list";
	}

	@GetMapping(value = "/get", params = "read")
	public String read() {
		log.info("params 파라미터 GET 방식 읽기");
		return "board2/read";
	}
}
