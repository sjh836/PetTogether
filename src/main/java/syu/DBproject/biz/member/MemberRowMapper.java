package syu.DBproject.biz.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<MemberVO>
{
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		MemberVO member=new MemberVO();
		member.setMno(rs.getInt("MNO"));
		member.setId(rs.getString("ID"));
		member.setPassword(rs.getString("PASSWORD"));
		member.setName(rs.getString("NAME"));
		member.setTel(rs.getString("TEL"));
		member.setAge(rs.getInt("SEX"));
		member.setAge(rs.getInt("AGE"));
		member.setRole(rs.getInt("ROLE"));
		member.setGrade(rs.getInt("GRADE"));
		member.setRegDate(rs.getDate("REGDATE"));
		
		return member;
	}
}
