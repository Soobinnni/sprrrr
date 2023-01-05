package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.zeus.domain.Member;
import lombok.extern.java.Log;

@Log
@Controller
public class MemberController3 {

	/*
	 * RedirectAttributes 는 일회성으로 데이터를 전달하는데 사용된다. 
	 * Model객체.addAttribute로 전달한 값은 url뒤에 붙으며,
	 * 리프레시해도 데이터가 유지된다.
	 * 
	 * RedirectAttributes객체.addFlashAttribute로 전달한 값은 url뒤에 붙지 않는다.
	 * 일회성이라 리프레시할 경우 데이터가 소멸한다.
	 * 또한 2개이상 쓸 경우, 데이터는 소멸한다.
	 * ★ 따라서 맵을 이용하여 한번에 값전달해야한다.
	 */

	@GetMapping(value = "/registerRedirectAttributesForm")
	public String registerRedirectAttributesForm() {
		log.info("registerRedirectAttributesForm");
		return "3/registerRedirectAttributesForm"; // 뷰 파일명
	}

	@PostMapping(value = "/registerRedirectAttributes")
	public String registerRedirectAttributes(Member member, RedirectAttributes rttr) throws Exception {
		/*
		 * form데이터로 member객체 초기화. RedirectAttribute로 redirect대상 매핑 controller메서드에 일회성으로
		 * 데이터 전달
		 */
		log.info("registerRedirectAttributes");
		rttr.addFlashAttribute("msg", "success"); //일회성으로 데이터를 보냄
		return "redirect:/result"; // redirect할 매핑명
	}

	@GetMapping(value = "/result")
	public String result() {
		log.info("result");
		return "3/result"; // 뷰 파일명
	}
}