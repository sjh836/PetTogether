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
	
	//JDBC ���� ����
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	//SQL��ɾ��
	private final String USER_LOGIN="select * from member where id=? and password=?";
	private final String USER_INSERT="insert into member(mno, id, password, name, tel, sex, age) values((select nvl(max(mno),0)+1 from member),?,?,?,?,?,?)";
	private final String USER_UPDATE="update member set password=?, name=?, tel=?, age=? where id=?";
	private final String USER_DELETE="delete from member where mno=?";
	private final String USER_LIST="select * from member order by mno desc";
	private final String USER_GET="select * from member where mno=?";
		
	//CRUD���
	//ȸ�� �α���
	public MemberVO loginMember(MemberVO vo)
	{
		System.out.println("[Model] loginMember() ��� ó��");
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
	//ȸ�����
	public void insertMember(MemberVO vo)
	{
		System.out.println("[Model] insertMember() ��� ó��");

		jdbcTemplate.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getTel(), vo.getSex(), vo.getAge());
	}
	//ȸ������
	public void updateMember(MemberVO vo)
	{
		System.out.println("[Model] updateMember() ��� ó��");
		jdbcTemplate.update(USER_UPDATE, vo.getPassword(), vo.getName(), vo.getTel(), vo.getAge(), vo.getId());
	}
	//ȸ������
	public void deleteMember(MemberVO vo)
	{
		System.out.println("[Model] deleteMember() ��� ó��");
		jdbcTemplate.update(USER_DELETE, vo.getMno());
	}
	//ȸ�� ����ȸ
	public MemberVO getMember(MemberVO vo)
	{
		System.out.println("[Model] getMember() ��� ó��");
		Object[] args={vo.getMno()};
		return jdbcTemplate.queryForObject(USER_GET, args, new MemberRowMapper());
	}
	//ȸ�� �����ȸ
	public List<MemberVO> getMemberList(MemberVO vo)
	{
		System.out.println("[Model] getMemberList() ��� ó��");
		return jdbcTemplate.query(USER_LIST, new MemberRowMapper());
	}
}
