package com.zeus.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {
	private String no;
	//@DateTimeFormat(pattern="yyyyMM")
	@DateTimeFormat(pattern="yyyyMMdd")
	private Date validMonth;

}
