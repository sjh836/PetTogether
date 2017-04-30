package syu.DBproject.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO>
{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		BoardVO board=new BoardVO();
		board.setBno(rs.getInt("BNO"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCount(rs.getInt("COUNT"));
		
		return board;
	}
}