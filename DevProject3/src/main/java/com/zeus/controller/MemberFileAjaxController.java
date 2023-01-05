package com.zeus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberFileAjaxController {
	
	@PostMapping(value="/uploadAjax", produces ="text/plain; charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file){
		String originalFileName = file.getOriginalFilename();
		log.info(originalFileName);
		
		//응답 성공시 보낼 ResponseEntity
		ResponseEntity<String> entity = new ResponseEntity<String>("응답 성공/파일명 : "+originalFileName,HttpStatus.OK);
		return entity;
	}
}