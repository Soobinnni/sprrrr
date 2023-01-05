package com.zeus.domain;

import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardV {
// 문자열이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
	@NotBlank
	private String no;
// 미래 날짜인지를 검사한다.
	@Future
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date validMonth;
}