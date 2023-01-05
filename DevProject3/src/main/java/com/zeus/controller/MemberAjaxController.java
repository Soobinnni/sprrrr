package com.zeus.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zeus.domain.Address;
import com.zeus.domain.Card;
import com.zeus.domain.MemberAjax;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberAjaxController {

	@GetMapping("/ajaxRegister01/{userId}") // 경로변수 사용
	public ResponseEntity<String> ajaxRegister01(@PathVariable("userId") String userId) {
		System.out.println("--------------------------------------------------------");
		log.info("ajaxRegister01");
		log.info("경로변수 userId : " + userId);
		System.out.println("--------------------------------------------------------");
		// 응답이 정상적으로 완료했다는 메시지를 ajax에 보낸다.
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping("/ajaxRegister02/{userId}/{password}")
	public ResponseEntity<String> ajaxRegister02(@PathVariable("userId") String userId,
			@PathVariable("password") String password) {
		System.out.println("--------------------------------------------------------");
		log.info("ajaxRegister02");
		log.info("경로변수 userId : " + userId);
		log.info("경로변수 password : " + password);
		System.out.println("--------------------------------------------------------");
		// 응답이 정상적으로 완료했다는 메시지를 ajax에 보낸다.
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping("/ajaxRegister03") /*
									 * ajax가 요청과 함께 보낸 param을 자바빈즈에 초기화한다. @RequestBody로 result를 ajax로 전송하기 때문에
									 * 어노테이션을 꼭 붙인다
									 */
	public ResponseEntity<String> ajaxRegister03(@RequestBody MemberAjax member) {
		System.out.println("--------------------------------------------------------");
		// 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다.
		// log.info("userId = " + userId);
		log.info("ajaxRegister03");
		log.info("param userId(member.getUserId()) : " + member.getUserId());
		log.info("param password(member.getPassword()) : " + member.getPassword());
		System.out.println("--------------------------------------------------------");
		// 응답이 정상적으로 완료했다는 메시지를 ajax에 보낸다.
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping("/ajaxRegister04")
	public ResponseEntity<String> ajaxRegister04(String userId, String password) {
		// post방식이라 보이지 않지만 ajax에서 "/register04?userId=user01"로 url을 요청했기 때문에 String으로
		// param을 받을 수 있다.
		System.out.println("--------------------------------------------------------");
		log.info("ajaxRegister04");
		log.info("param userId : " + userId);
		log.info("param password : " + password); // url에 password?에 대한 값을 보내지 않았기 때문에 null 출력
		System.out.println("--------------------------------------------------------");
		// 응답이 정상적으로 완료했다는 메시지를 ajax에 보낸다.
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping("/ajaxRegister05/{userId}")
	public ResponseEntity<String> ajaxRegister05(@PathVariable("userId") String userId,
			@RequestBody MemberAjax member) {
		/*
		 * 1. {userId}라는 경로변수가 url에 포함되어 있어 메소드의 인수로 사용한다. 2. ajax에서 보낸 data를 자바빈즈에
		 * 저장하고(@RequestBody), 그 초기화값을 사용한다. (getter)
		 */
		System.out.println("--------------------------------------------------------");
		log.info("ajaxRegister05");
		log.info("경로변수 userId : " + userId);
		log.info("param userId(member.getUserId()) = " + member.getUserId());
		log.info("param password(member.getPassword()) = " + member.getPassword());
		System.out.println("--------------------------------------------------------");
		// 응답이 정상적으로 완료했다는 메시지를 ajax에 보낸다.
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping("/ajaxRegister06")
	public ResponseEntity<String> ajaxRegister06(@RequestBody List<MemberAjax> memberList) {
		/*
		 * 1. List라 함은, JSON객체가 배열로 되어 있기 때문에 자바빈즈를 List로 저장한 것이다. 즉 [{MemberAjax필드변수
		 * 값}, {MemberAjax필드변수 값}]
		 */
		System.out.println("--------------------------------------------------------");
		log.info("ajaxRegister06");
		// List이기 때문에 for each문으로 객체를 꺼내 객체의 필드를 사용한다.
		for (MemberAjax memberAjax : memberList) {
			log.info("memberList의 userId : " + memberAjax.getUserId());
			log.info("memberList의 password : " + memberAjax.getPassword());
		}
		System.out.println("--------------------------------------------------------");
		// 응답이 정상적으로 완료했다는 메시지를 ajax에 보낸다.
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping("/ajaxRegister07")
	public ResponseEntity<String> ajaxRegister07(@RequestBody MemberAjax member) {
		/*
		 * MemberAjax의 필드, Address의 필드를 사용한다.
		 */
		System.out.println("--------------------------------------------------------");
		log.info("ajaxRegister07");
		// member에서 Address객체를 생성한다.
		Address address = member.getAddress();
		if (address != null) {
			log.info("address.getPostCode() = " + address.getPostCode());
			log.info("address.getLocation() = " + address.getLocation());
		} else {
			log.info("address == null");
		}
		System.out.println("--------------------------------------------------------");
		// 응답이 정상적으로 완료했다는 메시지를 ajax에 보낸다.
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

	@PostMapping("/ajaxRegister08")
	public ResponseEntity<String> ajaxRegister08(@RequestBody MemberAjax member) {
		/*
		 * MemberAjax의 필드, List<Card>의 Card객체를 사용한다. list : [{}, {}] 형태의 JSON객체
		 */
		System.out.println("--------------------------------------------------------");
		log.info("ajaxRegister08");
		// member의 필드를 Address객체 제외 출력한다.
		log.info("userId = " + member.getUserId());
		log.info("password = " + member.getPassword());
		// List객체를 member의 getList()로 생성한다. HTML form : cardList[index].Card필드변수명 name으로
		// value저장
		List<Card> cardList = member.getCardList();
		if (cardList != null&&cardList.size()!=0) {
			log.info("cardList.size() = " + cardList.size());
			for (int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo() = " + card.getNo());
				log.info("card.getValidMonth() = " + card.getValidMonth());
			}
			/*
			 * for (Card card : cardList) { log.info("card.getNo() = " + card.getNo());
			 * log.info("card.getValidMonth() = " + card.getValidMonth()); }
			 */
		} else {
			log.info("cardList == null");
		}
		System.out.println("--------------------------------------------------------");
		// 응답이 정상적으로 완료했다는 메시지를 ajax에 보낸다.
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}

}
