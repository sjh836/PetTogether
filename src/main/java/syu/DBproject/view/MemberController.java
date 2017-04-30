package syu.DBproject.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import syu.DBproject.biz.member.MemberService;
import syu.DBproject.biz.member.MemberVO;

@Controller
@SessionAttributes("member")
public class MemberController
{
	@Autowired
	private MemberService memberService;
	
	public MemberController()
	{
		System.out.println("[Controller] MemberController 객체 생성");
	}
	//회원 로그인
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session)
	{
		System.out.println("[Controller] MemberController -> 로그인처리");
		
		if(vo.getId()==null||vo.getId().equals(""))
		{
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다");
		}
		MemberVO user=memberService.loginMember(vo);
		if(memberService.loginMember(vo)!=null)
		{
			session.setAttribute("userId", user.getId()); //아이디설정
			session.setAttribute("userName", user.getName()); //이름설정
			
			return "index";
		}
		else
		{
			return "login";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception
	{
		System.out.println("[Controller] MemberController -> 로그아웃처리");
		
		//1. 브라우저와 연결된 세션 객체를 강제 종료한다.
		session.invalidate();

		//2. 세션 종료 후, 메인 화면으로 이동한다.
		return "login";
	}
	//회원등록
	@RequestMapping("/signup.do")
	public String insertMember(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> 회원가입처리");
		
		memberService.insertMember(vo);
		return "login";
	}
	//회원수정
	@RequestMapping("/updateMember.do")
	public String updateMember(@ModelAttribute("member")MemberVO vo, HttpSession session)
	{
		System.out.println("[Controller] MemberController -> 회원정보 수정처리");
		
		memberService.updateMember(vo);
		session.invalidate();
		login(vo, session);
		
		return "lndex";
	}
	//회원삭제
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> 회원탈퇴 처리");
		
		memberService.deleteMember(vo);
		return "redirect:admin.do";
	}
	//회원 상세 조회
	@RequestMapping("/getMember.do")
	public String getPet(MemberVO vo, Model model)
	{
		System.out.println("[Controller] MemberController -> 회원 상세 조회 처리");
		
		model.addAttribute("member", memberService.getMember(vo));
		
		return "getMember";
	}
	//관리자 페이지
	//회원 목록조회
	@RequestMapping("/admin.do")
	public String getMemberList(MemberVO vo, Model model, HttpSession session)
	{
		System.out.println("[Controller] MemberController -> 회원목록 처리");
		
		if(session.getAttribute("userName")==null)
		{
			throw new IllegalArgumentException("권한이 없습니다.");
		}
		
		model.addAttribute("memberList", memberService.getMemberList(vo)); //Model정보 저장
		
		return "admin";
	}
	//Json 출력
	@RequestMapping("/memberTransJson.do")
	@ResponseBody
	public List<MemberVO> dataTransform(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> Json으로 출력");
		
		List<MemberVO> memberList=memberService.getMemberList(vo);
		return memberList;
	}
	//엑셀 출력
	@RequestMapping("/toMemberExcel.do")
	public ModelAndView toExcel(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> Excel으로 출력");
		
		ModelAndView mav=new ModelAndView();
		List<MemberVO> memberList=memberService.getMemberList(vo);
		mav.addObject("memberList", memberList);
		mav.setViewName("memberExcel");
		
		return mav;
	}
	//PDF 출력
	@RequestMapping("/toMemberPdf.do")
	public ModelAndView toPdf(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> PDF로 출력");
		
		ModelAndView mav=new ModelAndView();
		List<MemberVO> memberList=memberService.getMemberList(vo);
		mav.addObject("memberList", memberList);
		mav.setViewName("memberPdf");
		
		return mav;
	}
}
