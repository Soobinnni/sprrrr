package com.zeus.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member;
import lombok.extern.java.Log;

/*
 * [<form:checkbox>]
 * 체크박스 요소 스프링 폼 태그로 체크박스를 출력하려면 <form:checkbox>를 사용한다.
 * 
 * ① 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다
 * ② 객체를 생성하여 값을 설정한 후에 전달한다.
 * 
 * <form:checkboxes>와 다른 점 : checkboxes는 controller에서 view의 checkbox의 구성을 보낸 것.
 * 따라서 <form:checkboxes>은 item속성이 필요하다.
 * 반면, <form:checkboxe>은 item속성은 필요하지 않다.
 */

@Log
@Controller
public class MemberController9 {
	@RequestMapping(value = "/registerSpringFormCheckbox01", method = RequestMethod.GET)
	public String registerSpringFormCheckbox01(Model model) {
		log.info("registerSpringFormCheckbox01");
		model.addAttribute("member", new Member());
		return "9/registerSpringFormCheckbox"; // 뷰 파일명
	}

	@RequestMapping(value = "/registerSpringFormCheckbox02", method = RequestMethod.GET)
	public String registerSpringFormCheckbox02(Model model) {
		log.info("registerSpringFormCheckbox02");
		Member member = new Member();
		member.setDeveloper("Y");
		member.setForeigner(true);
		member.setHobby("Movie");
		String[] hobbyArray = { "Music", "Movie" };
		member.setHobbyArray(hobbyArray);
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		member.setHobbyList(hobbyList);
		model.addAttribute("member", member);
		return "9/registerSpringFormCheckbox"; // 뷰 파일명
	}

// 입력 처리
	@RequestMapping(value = "/register6", method = RequestMethod.POST)
	public String register(Member member, Model model) {
		log.info("register");
		log.info("member.isForeigner() = " + member.isForeigner());
		log.info("member.getDeveloper() = " + member.getDeveloper());
		log.info("member.getHobby() = " + member.getHobby());
		String[] hobbyArray = member.getHobbyArray();
		if (hobbyArray != null) {
			log.info("hobbyArray != null = " + hobbyArray.length);
			for (int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] = " + hobbyArray[i]);
			}
		} else {
			log.info("hobbyArray == null");
		}
		List<String> hobbyList = member.getHobbyList();
		if (hobbyList != null) {
			log.info("hobbyList != null = " + hobbyList.size());
			for (int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList(" + i + ") = " + hobbyList.get(i));
			}
		} else {
			log.info("hobbyList == null");
		}
		model.addAttribute("member", member);
		return "9/checkboxResult"; // 뷰 파일명
	}
}