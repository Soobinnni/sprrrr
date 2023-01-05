package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.java.Log;

@Log
@Controller
public class HomeController {
	@GetMapping("/registerAjaxForm")
	public String registerAjaxForm() {
		log.info("registerAjaxForm");
		return "4/registerAjaxForm"; // 뷰 파일명
	}
	
	@GetMapping("/registerAjaxFileUpForm")
	public String registerAjaxFileUpForm() {
		log.info("registerAjaxForm");
		return "4/registerAjaxFileUpForm"; // 뷰 파일명
	}
	
	
}
