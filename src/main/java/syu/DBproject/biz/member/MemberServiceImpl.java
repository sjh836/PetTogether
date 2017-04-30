package syu.DBproject.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService
{
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberServiceImpl()
	{
		System.out.println("MemberServiceImpl °´Ã¼ »ý¼º");
	}
	public MemberVO loginMember(MemberVO vo)
	{
		return memberDAO.loginMember(vo);
	}
	public void insertMember(MemberVO vo)
	{
		memberDAO.insertMember(vo);
	}
	public void updateMember(MemberVO vo)
	{
		memberDAO.updateMember(vo);
	}
	public void deleteMember(MemberVO vo)
	{
		memberDAO.deleteMember(vo);
	}
	public MemberVO getMember(MemberVO vo)
	{
		return memberDAO.getMember(vo);
	}
	public List<MemberVO> getMemberList(MemberVO vo)
	{
		return memberDAO.getMemberList(vo);
	}

}
