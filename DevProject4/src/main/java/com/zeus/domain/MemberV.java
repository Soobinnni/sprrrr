package com.zeus.domain;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class MemberV {
	// 입력값 검증 규칙을 지정한다.
	@NotBlank
	private String userId;
	private String password;
	// 여러 개의 입력값 검증 규칙을 지정할 수 있다.
	@NotBlank
	@Size(max = 3)
	private String userName;
	private String email;
	private String gender;
}