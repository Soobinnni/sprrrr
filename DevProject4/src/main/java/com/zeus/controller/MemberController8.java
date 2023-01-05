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
 * [<form:checkboxes>]
 * 여러 개의 체크박스 요소
 * 스프링 폼 태그로 여러 개의 체크박스를 출력하려면 <form:checkboxes>를 사용한다.
 * 
 * Controller에서 <form:checkboxes>에 데이터를 보내는 법
 * ① 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
 *   : Map의 key와 value쌍으로 넘겨줄 경우 key는 태그의 value값이 되고 value는 label명이 된다.
 *
 * ② 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
 *   : List의 제네릭 타입으로 담기는 객체의 필드멤버가 form에서 각각 label과 value로 구분되는 기준은
 *   form에서 정한다. 즉 <form:checkboxes>의 속성에서 itemValue="필드멤버명과일치" itemLabel="필드멤버명과일치"
 *   로 구분하도록 할 수 있다.
 *     
 * view에선, <form:checkboxes>가 model.addAttribute로 받은 key값을 items=""를 통해 꺼내온다.
 * 그리고 model.addAttribute()로 받은 객체의 필드를 초기화하고자 한다면, 해당 객체의 필드명과
 * path 속성값을 동일시 하여 초기화하도록 데이터를 (Controller에) 넘겨준다.
 * 
 * items속성 말고도, itemValue, itemLabel속성이 존재한다.

 */
@Log
@Controller
public class MemberController8 {
	@RequestMapping(value = "/registerSpringFormCheckboxes01", method = RequestMethod.GET)
	public String registerSpringFormCheckboxes01(Model model) {
		log.info("registerSpringFormCheckboxes01");
		
		//Map과 Member은 각각 보내지는 이유가 다르다!
		
		//① 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
		// Map은 단지 form의 checkbox를 구성하기 위해서 보내지는 값
		Map<String, String> hobbyMap = new HashMap<String, String>();
		
		//value가 label이 되고, key가 value가 된다.
		hobbyMap.put("01", "Sports");
		hobbyMap.put("02", "Music");
		hobbyMap.put("03", "Movie");
		model.addAttribute("hobbyMap", hobbyMap);
		
		//member는 자신의 List<String> hobbyList 필드를 채우기 위해 보내지는 객체
		model.addAttribute("member", new Member());
		return "8/registerSpringFormCheckboxes01"; // 뷰 파일명
	}

	@RequestMapping(value = "/registerSpringFormCheckboxes02", method = RequestMethod.GET)
	public String registerSpringFormCheckboxes02(Model model) {
		log.info("registerSpringFormCheckboxes02");
			
		//② 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
		List<CodeLabelValue> hobbyCodeList = new ArrayList<CodeLabelValue>();
		hobbyCodeList.add(new CodeLabelValue("01", "Sports"));
		hobbyCodeList.add(new CodeLabelValue("02", "Music"));
		hobbyCodeList.add(new CodeLabelValue("03", "Movie"));
		model.addAttribute("hobbyCodeList", hobbyCodeList);
		model.addAttribute("member", new Member());
		return "8/registerSpringFormCheckboxes02"; // 뷰 파일명
	}

	// 	입력 처리 : path="hobbyList"와 일치하는 Member의 필드멤버가 초기화되어서 넘어온다.
	@RequestMapping(value = "/register5", method = RequestMethod.POST)
	public String register(Member member, Model model) {
		log.info("register");
		List<String> hobbyList = member.getHobbyList();
		if (hobbyList != null) {
			log.info("hobbyList != null = " + hobbyList.size());
			for (int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList(" + i + ") = " + hobbyList.get(i));
			}
		} else {
			log.info("hobbyList == null");
		}
		model.addAttribute("hobbyList", hobbyList);
		return "8/checkboxesResult"; // 뷰 파일명
	}
}
