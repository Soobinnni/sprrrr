package com.hera.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hera.domain.Board;
import com.hera.domain.ExampClass;
import com.hera.domain.Member;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/board3")
public class AjaxController {

	@PutMapping("/{boardNo}")
	public ResponseEntity<String> modify(/*@PathVariable("boardNo") int boardNo, */@RequestBody ExampClass ex) {
		log.info("modify" + " ExampClass : " + ex);
		ResponseEntity<String> entity = new ResponseEntity<>("a", HttpStatus.OK);

		return entity;
	}

	@PutMapping(value = "/{boardNo}", headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyHeader");
		ResponseEntity<String> entity = new ResponseEntity<String>("a", HttpStatus.OK);
		return entity;
	}

}
