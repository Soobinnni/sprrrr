package com.zeus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member;
import com.zeus.service.MemberService;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/user")
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/register")
	public void registerForm(Member member, Model model) throws Exception {
		log.info("UserRegisterForm");
	}

	@PostMapping("/register")
	public String register(Member member, Model model) throws Exception {
		service.register(member);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "user/success";
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
	}

	@GetMapping("/read")
	public void read(int userNo, Model model) throws Exception {
		model.addAttribute(service.read(userNo));
	}

	@PostMapping("/remove")
	public String remove(int userNo, Model model) throws Exception {
		service.remove(userNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "user/success";
	}

	@GetMapping("/modify")
	public void modifyForm(int userNo, Model model) throws Exception {
		model.addAttribute(service.read(userNo));
	}

	@PostMapping("/modify")
	public String modify(Member member, Model model) throws Exception {
		service.modify(member);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "user/success";
	}
}