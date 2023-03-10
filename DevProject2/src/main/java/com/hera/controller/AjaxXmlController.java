package com.hera.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hera.domain.Board;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/board4")
public class AjaxXmlController {
	// consumes 속성을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
	@PostMapping(value = "/{boardNo}")
	public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modify(default : JSON)");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	// consumes 속성값에 "application/json" 미디어 타입을 지정한다.
	@PutMapping(value = "/{boardNo}", consumes = "application/json")
	public ResponseEntity<String> modifyByJson(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyByJson");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	// consumes 속성값에 "application/xml" 미디어 타입을 지정한다.
	@PutMapping(value = "/{boardNo}", consumes = "application/xml")
	public ResponseEntity<String> modifyByXml(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyByXml boardNo : " + boardNo);
		log.info("modifyByXml board : " + board);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

}
