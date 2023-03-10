package com.hera.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hera.domain.Board;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("board5")
public class AjaxAcceptController {
	// produces 속성 값에 "application/xml"미디어 타입을 지정한다.
	@GetMapping(value = "/{boardNo}", produces = "application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable("boardNo") int boardNo) {
		log.info("readToXml");
		
		Board board = new Board();

		board.setBoardNo(boardNo);
		board.setContent("readToXml : 내용");
		board.setRegDate(new Date());
		board.setTitle("readToXml : 제목");
		board.setWriter("readToXml : 작가");
		
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}

	// produces 속성 값에 "application/json"미디어 타입을 지정한다.
	@GetMapping(value = "/{boardNo}", produces = "application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo) {
		log.info("readToJson");
		
		Board board = new Board();

		board.setBoardNo(boardNo);
		board.setContent("readToJson : 내용");
		board.setRegDate(new Date());
		board.setTitle("readToJson : 제목");
		board.setWriter("readToJson : 작가");
		
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}
	
	// 응답 본문의 미디어 타입을 지정하지 않으면 기본값으로 "application/json"으로 지정
	@GetMapping(value = "/{boardNo}")
	public ResponseEntity<Board> defaultRead(@PathVariable("boardNo") int boardNo) {
		log.info("defaultRead");
		
		Board board = new Board();

		board.setBoardNo(boardNo);
		board.setContent("defaultRead : 내용");
		board.setRegDate(new Date());
		board.setTitle("defaultRead : 제목");
		board.setWriter("defaultRead : 작가");
		
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}
}
