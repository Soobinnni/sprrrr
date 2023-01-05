package com.zeus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.CodeLabelValue;
import com.zeus.domain.Member;
import lombok.extern.java.Log;

/*
 * [<form:radiobuttons>]
 * 여러 개의 라디오 버튼 요소
 * 스프링 폼 태그로 여러 개의 라디오 버튼를 출력하려면 <form:radiobuttons>를 사용한다.
 * 
 * - 보내는 방법은 <form:checkboxes>와 동일하다.
 * ① 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
 *   : Map의 key와 value쌍으로 넘겨줄 경우 key는 태그의 value값이 되고 value는 label명이 된다.
 *
 * ② 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
 *   : List의 제네릭 타입으로 담기는 객체의 필드멤버가 form에서 각각 label과 value로 구분되는 기준은
 *   form에서 정한다. 즉 <form:checkboxes>의 속성에서 itemValue="필드멤버명과일치" itemLabel="필드멤버명과일치"
 *   로 구분하도록 할 수 있다.
 *     
 * view에선, <form:radiobuttons>가 model.addAttribute로 받은 key값을 items=""를 통해 꺼내온다.
 * 그리고 model.addAttribute()로 받은 객체의 필드를 초기화하고자 한다면, 해당 객체의 필드명과
 * path 속성값을 동일시 하여 초기화하도록 데이터를 (Controller에) 넘겨준다.
 */
@Log
@Controller
public class MemberController10 {
	@RequestMapping(value = "/registerSpringFormRadiobuttons01", method = RequestMethod.GET)
	public String registerSpringFormRadiobuttons01(Model model) {
		log.info("registerSpringFormRadiobuttons01");
		Map<String, String> genderColdeMap = new HashMap<String, String>();
		genderColdeMap.put("01", "Male");
		genderColdeMap.put("02", "Female");
		genderColdeMap.put("03", "Other");
		model.addAttribute("genderCodeMap", genderColdeMap);
		model.addAttribute("member", new Member());
		return "10/registerSpringFormRadiobuttons01"; // 뷰 파일명
	}

	@RequestMapping(value = "/registerSpringFormRadiobuttons02", method = RequestMethod.GET)
	public String registerSpringFormRadiobuttons02(Model model) {
		log.info("registerSpringFormRadiobuttons02");
		List<CodeLabelValue> genderCodeList = new ArrayList<CodeLabelValue>();
		genderCodeList.add(new CodeLabelValue("01", "Male"));
		genderCodeList.add(new CodeLabelValue("02", "Female"));
		genderCodeList.add(new CodeLabelValue("03", "Other"));
		model.addAttribute("genderCodeList", genderCodeList);
		model.addAttribute("member", new Member());
		return "10/registerSpringFormRadiobuttons02"; // 뷰 파일명
	}

	// 입력 처리
	@RequestMapping(value = "/register10", method = RequestMethod.POST)
	public String register(Member member, Model model) {
		log.info("register");
		log.info("member.getGender() = " + member.getGender());
		model.addAttribute("gender", member.getGender());
		return "10/radiobuttonsResult"; // 뷰 파일명
	}
}