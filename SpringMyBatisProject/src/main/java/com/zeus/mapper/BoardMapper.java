package com.zeus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zeus.domain.Board;

public interface BoardMapper {
	public void create(Board board) throws Exception;

	public Board read(Integer boardNo) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(Integer boardNo) throws Exception;

	public List<Board> list() throws Exception;

	//@Param 어노테이션을 붙이면 본인이 원하는 명으로 mapper에서 사용할 수 있다. 아래와 같은 경우는 #{title}로 사용할 수 있다.
	public List<Board> search(@Param("title") String title) throws Exception;
}
