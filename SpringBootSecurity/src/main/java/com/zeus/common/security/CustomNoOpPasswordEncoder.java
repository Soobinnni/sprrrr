package com.zeus.common.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.extern.java.Log;

/*
 *  비밀번호 암호화 처리기

 * 스프링 시큐리티 5 부터는 기본적으로 PasswordEncoder 를 지정해야 한다. 제대로 할려면 생성된 사용자 
 * 테이블(users)에 비밀번호를 암호화하여 저장해야 한다.
 * 테스트를 위해서 생성한 데이터는 암호화를 처리하지 않았으므로 아무 처리를 하지 않고 로그인하면 당연히 로그인에러가 발생한다.
 * 그래서 암호화를 하지 않는 PasswordEncoder 를 직접 구현하여 지정하면 로그인시 암호화를 고려하지 않으므로 로그인이 된다.
 */
@Log
public class CustomNoOpPasswordEncoder implements PasswordEncoder {
	public String encode(CharSequence rawPassword) {
		log.info("before encode :" + rawPassword);
		return rawPassword.toString();
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		log.info("matches: " + rawPassword + ":" + encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}
}