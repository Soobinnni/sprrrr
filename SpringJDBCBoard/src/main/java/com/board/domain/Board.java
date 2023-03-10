package com.board.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
	/*
	 *  board_no NUMBER,
	 *	title VARCHAR2(100) NOT NULL,
	 *	content VARCHAR2(1000) NULL,
	 *	writer VARCHAR2(50) NOT NULL,
	 *	reg_date DATE DEFAULT SYSDATE,
	 *	PRIMARY KEY (board_no)
	 */
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
}
