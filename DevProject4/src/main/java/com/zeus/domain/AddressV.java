package com.zeus.domain;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressV {
// 문자열이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
	@NotBlank
	private String postCode;
// 문자열이 아니고 trim한 길이가 0보다 크다는 것을 검사한다.
	@NotBlank
	private String location;
}