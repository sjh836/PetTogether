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
		System.out.println("[Controller] MemberController ��ü ����");
	}
	//ȸ�� �α���
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session)
	{
		System.out.println("[Controller] MemberController -> �α���ó��");
		
		if(vo.getId()==null||vo.getId().equals(""))
		{
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�");
		}
		MemberVO user=memberService.loginMember(vo);
		if(memberService.loginMember(vo)!=null)
		{
			session.setAttribute("userId", user.getId()); //���̵���
			session.setAttribute("userName", user.getName()); //�̸�����
			
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
		System.out.println("[Controller] MemberController -> �α׾ƿ�ó��");
		
		//1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
		session.invalidate();

		//2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
		return "login";
	}
	//ȸ�����
	@RequestMapping("/signup.do")
	public String insertMember(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> ȸ������ó��");
		
		memberService.insertMember(vo);
		return "login";
	}
	//ȸ������
	@RequestMapping("/updateMember.do")
	public String updateMember(@ModelAttribute("member")MemberVO vo, HttpSession session)
	{
		System.out.println("[Controller] MemberController -> ȸ������ ����ó��");
		
		memberService.updateMember(vo);
		session.invalidate();
		login(vo, session);
		
		return "lndex";
	}
	//ȸ������
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> ȸ��Ż�� ó��");
		
		memberService.deleteMember(vo);
		return "redirect:admin.do";
	}
	//ȸ�� �� ��ȸ
	@RequestMapping("/getMember.do")
	public String getPet(MemberVO vo, Model model)
	{
		System.out.println("[Controller] MemberController -> ȸ�� �� ��ȸ ó��");
		
		model.addAttribute("member", memberService.getMember(vo));
		
		return "getMember";
	}
	//������ ������
	//ȸ�� �����ȸ
	@RequestMapping("/admin.do")
	public String getMemberList(MemberVO vo, Model model, HttpSession session)
	{
		System.out.println("[Controller] MemberController -> ȸ����� ó��");
		
		if(session.getAttribute("userName")==null)
		{
			throw new IllegalArgumentException("������ �����ϴ�.");
		}
		
		model.addAttribute("memberList", memberService.getMemberList(vo)); //Model���� ����
		
		return "admin";
	}
	//Json ���
	@RequestMapping("/memberTransJson.do")
	@ResponseBody
	public List<MemberVO> dataTransform(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> Json���� ���");
		
		List<MemberVO> memberList=memberService.getMemberList(vo);
		return memberList;
	}
	//���� ���
	@RequestMapping("/toMemberExcel.do")
	public ModelAndView toExcel(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> Excel���� ���");
		
		ModelAndView mav=new ModelAndView();
		List<MemberVO> memberList=memberService.getMemberList(vo);
		mav.addObject("memberList", memberList);
		mav.setViewName("memberExcel");
		
		return mav;
	}
	//PDF ���
	@RequestMapping("/toMemberPdf.do")
	public ModelAndView toPdf(MemberVO vo)
	{
		System.out.println("[Controller] MemberController -> PDF�� ���");
		
		ModelAndView mav=new ModelAndView();
		List<MemberVO> memberList=memberService.getMemberList(vo);
		mav.addObject("memberList", memberList);
		mav.setViewName("memberPdf");
		
		return mav;
	}
}
