package com.board.dao;

import org.springframework.stereotype.Repository;

import com.board.domain.Board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * - JdbcTemplate의 update()메서드 
 *   (query, query의 ?변수의 값 나열1, 2, ..., n)
 *   
 * - JdbcTemplate의 query()메서드 
 *   select문의 결과를 List로 가져올 수 있다. (ResultSet)
 */

@Repository
public class BoardDAO {

	// 자동주입
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// ----------------------create------------------------------
	public void create(Board board) throws Exception {
		String query = "insert into jdbcBoard(board_no, title, content, writer) values ";
		query += "(jdbcBoard_seq.NEXTVAL, ?, ?, ?)";
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());

	}

	// ----------------------read------------------------------
	public Board read(Integer boardNo) throws Exception {
		String query = "select * from jdbcBoard where board_no =?";

		List<Board> results = jdbcTemplate.query(query, new RowMapper<Board>() {
			// 익명 클래스
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				return board;
			}
		}, boardNo);

		/*
		 * 조건식?true:false List가 null이면 null을 반환, 아니면 인덱스0의 객체를 반환
		 */
		return results.isEmpty() ? null : results.get(0);
	}

	// ----------------------update------------------------------
	public void update(Board board) throws Exception {
		String query = "UPDATE jdbcBoard SET title =?, " + "content =? WHERE board_no= ?";

		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());

	}

	// ----------------------delete------------------------------
	public void delete(Integer boardNo) throws Exception {
		String query = "delete from jdbcBoard where board_no = ?";
		jdbcTemplate.update(query, boardNo);
	}

	// ----------------------list------------------------------
	public List<Board> list() throws Exception {
		String query = "SELECT board_no, title, content, writer, reg_date FROM jdbcBoard ";
		query += "WHERE board_no > 0 ORDER BY board_no desc, reg_date DESC";

		List<Board> results = jdbcTemplate.query(query, new RowMapper<Board>() {
			// 익명 클래스
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				return board;
			}
		});
		return results;
	}
}
