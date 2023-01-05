package com.zeus.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class MemberAjax {
	private String userId = "hong";
	private String password = "1234";
	private Address address;
	private List<Card> cardList;
}

