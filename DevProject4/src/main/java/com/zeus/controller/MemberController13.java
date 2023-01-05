package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member;
import lombok.extern.java.Log;

/* [ <form:hidden> ]
 * 숨겨진 필드 요소
 * 스프링 폼 태그로 숨겨진 필드를 출력하려면 <form:hidden>를 사용한다.
 */


@Log
@Controller
public class MemberController13 {
	@RequestMapping(value = "/registerSpringFormHidden", method = RequestMethod.GET)
	public String registerSpringFormHidden(Model model) {
		log.info("registerSpringFormHidden");
		Member member = new Member();
		member.setUserId("hong"); //<form:hidden>에 보낼 userId를 set한다.
		member.setUserName("홍길동");
		model.addAttribute("member", member);
		return "13/registerSpringFormHidden"; // 뷰 파일명
	}

// 입력 처리
	@RequestMapping(value = "/register13", method = RequestMethod.POST)
	public String register(Member member) {
		//<form:hidden path="userId" />으로 숨겨진 필드 요소로 Member 초기화
		log.info("register");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getUserName() = " + member.getUserName());
		return "13/hiddenResult";
	}
}