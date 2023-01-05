package com.zeus.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zeus.domain.Member2;
import lombok.extern.java.Log;

@Log
@Controller
public class MemberController4 {
	@RequestMapping(value = "/registerForm4", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm4");
		return "1/registerForm4";
	}

	//폼의 필드 값을 name속성값을 이용하여 가져온다. Date형식은 2022/01/03 
	@RequestMapping(value = "/registerByDate01", method = RequestMethod.GET)
	public String registerByDate01(String userId, Date dateOfBirth) {
		log.info("registerByDate01");
		log.info("userId = " + userId);
		log.info("dateOfBirth = " + dateOfBirth);
		return "success";
	}

	//Member2의 필드 변수명과 폼 필드의 name속성값을 일치시켜 Member2의 필드를 초기화한다.
	@RequestMapping(value = "/registerByDate02", method = RequestMethod.GET)
	public String registerByDate02(Member2 member) {
		log.info("registerByDate02");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		return "success";
	}

	//Member2의 필드 변수명과 폼 필드의 name속성값을 일치시켜 Member2의 필드를 초기화한다.
	@RequestMapping(value = "/registerdate", method = RequestMethod.POST)
	public String registerdate(Member2 member) {
		log.info("registerByDate");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		return "success";
	}
	

	//@DateTimeFormat어노테이션 이용하기
	//폼의 필드 값을 name속성값을 이용하여 가져온다. Date형식은 2022/01/03 
	@RequestMapping(value = "/registerByDate03", method = RequestMethod.GET)
	public String registerByDate03(String userId, @DateTimeFormat(pattern="yyyyMMdd") Date dateOfBirth) {
		log.info("registerByDate01");
		log.info("userId = " + userId);
		log.info("dateOfBirth = " + dateOfBirth);
		return "success";
	}

	//Member2의 필드 변수명과 폼 필드의 name속성값을 일치시켜 Member2의 필드를 초기화한다.
	@RequestMapping(value = "/registerByDate04", method = RequestMethod.GET)
	public String registerByDate04(Member2 member) {
		log.info("registerByDate02");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		return "success";
	}

	//Member2의 필드 변수명과 폼 필드의 name속성값을 일치시켜 Member2의 필드를 초기화한다.
	@RequestMapping(value = "/registerdate2", method = RequestMethod.POST)
	public String registerdate2(Member2 member) {
		log.info("registerByDate");
		log.info("member.getUserId() = " + member.getUserId());
		log.info("member.getPassword() = " + member.getPassword());
		log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
		return "success";
	}
}
