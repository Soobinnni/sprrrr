package com.zeus.common.security.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.zeus.domain.Member.Member;

public class CustomUser extends User{

	private static final long serialVersionUID = 1L;
	
	private Member member;	
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(Member member) {
		//사용자가 정의한 Member타입을 스프링 시큐리티 UsersDetails 타입으로 변환한다.
		//super(getUsername(), getPassword(), getAuthorities()); 
	}
	
}
