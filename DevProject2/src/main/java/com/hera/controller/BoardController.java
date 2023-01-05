package com.hera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
//@RequestMapping("/board")
public class BoardController {
	
	/*
	 * @RequestMapping("/board/register") 
	 * public void registerForm() {
	 * 		log.info("등록 폼"); 
	 * }
	 * 
	 * @RequestMapping("/board/modify") 
	 * public void modifyForm() { 
	 * 		log.info("수정 폼");
	 * }
	 * 
	 * @RequestMapping("/board/list") 
	 * public void list() { 
	 * 		log.info("목록"); 
	 * }
	 */
	
	//경로 패턴 지정
	@GetMapping("/read/{boardNo}")
	public String read(@PathVariable("boardNo") int a) {
		log.info("게시글 번호 : "+a);
		return "board/read";
	}
	
	//경로 패턴 지정
	@GetMapping("/read2/{no}")
	public String read2(@PathVariable("no") int boardNo) {
		log.info("두번째 게시글 번호 : "+boardNo);
		return "board/read";
	}
	
	//get, post형식 확인
	@GetMapping("/register") //== register?register
	public String registerForm() {
		log.info("GET방식 register");
		return "success";
	}
	

	@PostMapping("/register")
	public String register() {
		log.info("POST방식 register");
		return "success";
	}

	@GetMapping("/modify")
	public String modifyForm() {
		log.info("GET방식 modify");
		return "success";
	}

	@PostMapping("/modify")
	public String modify() {
		log.info("POST방식 modify");
		return "success";
	}

	@GetMapping("/remove")
	public String removeForm() {
		log.info("GET방식 remove");
		return "success";
	}

	@PostMapping("/remove")
	public String remove() {
		log.info("POST방식 remove");
		return "success";
	}

	@GetMapping("/list")
	public String list() {
		log.info("GET방식 list");
		return "success";
	}

}
