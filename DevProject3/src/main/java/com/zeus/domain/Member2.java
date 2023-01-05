package com.zeus.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member2 {
	private String userId ="hong";
	private String password="1234";
	
	//Date 타입 필드 변환처리
	@DateTimeFormat(pattern ="yyyyMMdd")
	private Date dateOfBirth;
}
