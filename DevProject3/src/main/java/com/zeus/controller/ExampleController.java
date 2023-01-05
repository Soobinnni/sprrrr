package com.zeus.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.java.Log;

@Log
@Controller
public class ExampleController {
	

	@GetMapping("/examForm")
	public String examForm() {
		return "examm";
	}
	@GetMapping("/exam")
	public String exam(@RequestParam("array") ArrayList<String> array) {
		
		log.info(array.get(0));
		log.info(array.get(1));
		log.info(array.get(2));
		return "success";
	}
}
