package syu.DBproject.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import syu.DBproject.biz.common.JDBCUtil;

@Repository
public class MemberDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//JDBC 관련 변수
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	//SQL명령어들
	private final String USER_LOGIN="select * from member where id=? and password=?";
	private final String USER_INSERT="insert into member(mno, id, password, name, tel, sex, age) values((select nvl(max(mno),0)+1 from member),?,?,?,?,?,?)";
	private final String USER_UPDATE="update member set password=?, name=?, tel=?, age=? where id=?";
	private final String USER_DELETE="delete from member where mno=?";
	private final String USER_LIST="select * from member order by mno desc";
	private final String USER_GET="select * from member where mno=?";
		
	//CRUD기능
	//회원 로그인
	public MemberVO loginMember(MemberVO vo)
	{
		System.out.println("[Model] loginMember() 기능 처리");
		MemberVO member=null;
		try
		{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(USER_LOGIN);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				member=new MemberVO();
				member.setMno(rs.getInt("MNO"));
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setName(rs.getString("NAME"));
				member.setRole(rs.getInt("ROLE"));
				member.setGrade(rs.getInt("GRADE"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.close(rs, stmt, conn);
		}
		return member;
	}
	//회원등록
	public void insertMember(MemberVO vo)
	{
		System.out.println("[Model] insertMember() 기능 처리");

		jdbcTemplate.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getTel(), vo.getSex(), vo.getAge());
	}
	//회원수정
	public void updateMember(MemberVO vo)
	{
		System.out.println("[Model] updateMember() 기능 처리");
		jdbcTemplate.update(USER_UPDATE, vo.getPassword(), vo.getName(), vo.getTel(), vo.getAge(), vo.getId());
	}
	//회원삭제
	public void deleteMember(MemberVO vo)
	{
		System.out.println("[Model] deleteMember() 기능 처리");
		jdbcTemplate.update(USER_DELETE, vo.getMno());
	}
	//회원 상세조회
	public MemberVO getMember(MemberVO vo)
	{
		System.out.println("[Model] getMember() 기능 처리");
		Object[] args={vo.getMno()};
		return jdbcTemplate.queryForObject(USER_GET, args, new MemberRowMapper());
	}
	//회원 목록조회
	public List<MemberVO> getMemberList(MemberVO vo)
	{
		System.out.println("[Model] getMemberList() 기능 처리");
		return jdbcTemplate.query(USER_LIST, new MemberRowMapper());
	}
}
