package syu.DBproject.biz.member;

import java.util.List;

public interface MemberService
{
	//CRUD기능
	MemberVO loginMember(MemberVO vo); //회원 로그인
	void insertMember(MemberVO vo); //회원등록
	void updateMember(MemberVO vo); //회원수정
	void deleteMember(MemberVO vo); //회원삭제
	MemberVO getMember(MemberVO vo);
	List<MemberVO> getMemberList(MemberVO vo); //회원 목록조회
}
