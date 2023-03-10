package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
public class BoardController {
	
	@RequestMapping("/board/register")
	public void registerForm() {
		//log.info("등록 폼");
	}

	@RequestMapping("/board/modify")
	public void modifyForm() {
		//log.info("수정 폼");
	}
	
	@RequestMapping("/board/list")
	public void list() {
		//log.info("목록");
	}

}