package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.Board;
import com.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board") // 클래스 레벨 매핑
public class BoardController {
	// 자동 주입
	@Autowired
	private BoardService service;

	// ----------------------register------------------------------
	@GetMapping("/registerForm")
	public String registerForm(Board board, Model model) throws Exception {
		log.info("registerForm");

		return "board/register"; // view
	}

	// registerForm에서 보내온 command객체를 이용하여 register
	@PostMapping("/register")
	public String register(Board board, Model model) throws Exception {
		log.info("register");

		// register service
		service.register(board);

		// binding
		model.addAttribute("msg", "등록이 완료됐습니다.");
		return "board/success"; // view
	}

	// ----------------------list------------------------------

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		log.info("list");

		model.addAttribute("list", service.list());
	}

	// ----------------------read------------------------------
	@GetMapping("/read")
	public void read(int boardNo, Model model) throws Exception {
		log.info("read");

		model.addAttribute(service.read(boardNo));
	}

	// ----------------------remove------------------------------
	public String remove(int boardNo, Model model) throws Exception {
		log.info("remove");

		service.remove(boardNo);

		model.addAttribute("msg", "삭제가 완료됐습니다.");

		return "board/success";
	}

	// ----------------------modify------------------------------
	@GetMapping("/modify")
	public void modifyForm(int boardNo, Model model) throws Exception {
		log.info("modifyForm");

		model.addAttribute(service.read(boardNo));
	}

	@PostMapping("/modify")
	public String modify(Board board, Model model) throws Exception {
		log.info("modify");

		service.modify(board);

		model.addAttribute("msg", "수정이 완료됐습니다.");

		return "board/success";
	}
}
