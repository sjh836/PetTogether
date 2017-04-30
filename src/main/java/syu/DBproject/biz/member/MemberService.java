package syu.DBproject.biz.member;

import java.util.List;

public interface MemberService
{
	//CRUD���
	MemberVO loginMember(MemberVO vo); //ȸ�� �α���
	void insertMember(MemberVO vo); //ȸ�����
	void updateMember(MemberVO vo); //ȸ������
	void deleteMember(MemberVO vo); //ȸ������
	MemberVO getMember(MemberVO vo);
	List<MemberVO> getMemberList(MemberVO vo); //ȸ�� �����ȸ
}
