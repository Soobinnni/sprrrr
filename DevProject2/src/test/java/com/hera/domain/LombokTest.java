package com.hera.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LombokTest {

	@Test
	public void testNoArgsConstructor() {
		Board board = new Board();
		
		System.out.println(board);
	}
	
	@Test
	public void testRequiredArgsConstructor() {
		Board board = new Board();
		board.setTitle("테스트 제목");
		
		System.out.println(board);
	}
}
