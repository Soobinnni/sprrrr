package com.zeus.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Member {
	private String userId ="hong";
	private String userName="홍길동";
	private String password="1234";
	private int coin = 200;
}
