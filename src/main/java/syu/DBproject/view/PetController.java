package syu.DBproject.view;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import syu.DBproject.biz.pet.PetService;
import syu.DBproject.biz.pet.PetVO;

@Controller
@SessionAttributes("pet")
public class PetController
{
	@Autowired
	private PetService petService;
	
	public PetController()
	{
		System.out.println("[Controller] PetController ��ü ����");
	}
	//�� ���
	@RequestMapping("/insertPet.do")
	public String insertPet(PetVO vo) throws IOException
	{
		System.out.println("[Controller] PetControlle -> �� ��� ó��");
		
		MultipartFile uploadFile=vo.getUploadFile();
		if(!uploadFile.isEmpty())
		{
			String fileName=uploadFile.getOriginalFilename(); //�����̸� ����
			uploadFile.transferTo(new File("D:/Spring workspace/DBproject16-2/src/main/webapp/resources/bootstrap/img/works/"+fileName)); //������ �ö󰡴°�
		}
		petService.insertPet(vo);
		return "redirect:getPetList.do";
	}
	//�� ���� ��
	@RequestMapping("/getUpdatePet.do")
	public String getUpdatePet(PetVO vo, Model model)
	{
		System.out.println("[Controller] PetController -> �� ���� ȭ�� ó��");
		
		model.addAttribute("pet", petService.getPet(vo));
		
		return "updatePet";
	}
	//�� ����
	@RequestMapping("/updatePet.do")
	public String updatePet(@ModelAttribute("pet")PetVO vo)
	{
		System.out.println("[Controller] PetController -> �� ���� ó��");
		
		petService.updatePet(vo);
		
		return "redirect:getPetList.do";
	}
	//�� ����
	@RequestMapping("/deletePet.do")
	public String deletePet(PetVO vo)
	{
		System.out.println("[Controller] PetController -> �� ���� ó��");
		
		petService.deletePet(vo);

		return "redirect:admin2.do";
	}
	//�� �� ��ȸ
	@RequestMapping("/getPet.do")
	public String getPet(PetVO vo, Model model)
	{
		System.out.println("[Controller] PetController -> �� �� ��ȸ ó��");
		
		model.addAttribute("pet", petService.getPet(vo));
		
		return "getPet";
	}
	//�˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchCondition()
	{
		Map<String, String> conditionMap=new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	//�� ��� ��ȸ
	@RequestMapping("/getPetList.do")
	public String getBoardList(PetVO vo, Model model, HttpSession session)
	{
		System.out.println("[Controller] PetListController -> �� ��� �˻�ó��");
		
		if(session.getAttribute("userName")==null)
		{
			throw new IllegalArgumentException("������ �����ϴ�.");
		}
		
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		model.addAttribute("petList", petService.getPetList(vo)); //Model���� ����

		return "getPetList";
	}
	//�� �����ȸ
	@RequestMapping("/admin2.do")
	public String getAdminPetList(PetVO vo, Model model, HttpSession session)
	{
		System.out.println("[Controller] PetController -> ������ ���� ó��");
		
		if(session.getAttribute("userName")==null)
		{
			throw new IllegalArgumentException("������ �����ϴ�.");
		}
		
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		model.addAttribute("petList2", petService.getPetList(vo)); //Model���� ����
		
		return "admin2";
	}
	//Json ���
	@RequestMapping("/petTransJson.do")
	@ResponseBody
	public List<PetVO> dataTransform(PetVO vo)
	{
		System.out.println("[Controller] PetController -> Json���� ���");
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<PetVO> petList=petService.getPetList(vo);
		return petList;
	}
	//���� ���
	@RequestMapping("/toPetExcel.do")
	public ModelAndView toExcel(PetVO vo)
	{
		System.out.println("[Controller] PetController -> Excel���� ���");
		
		ModelAndView mav=new ModelAndView();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<PetVO> petList=petService.getPetList(vo);
		mav.addObject("petList", petList);
		mav.setViewName("petExcel");
		
		return mav;
	}
	//PDF ���
	@RequestMapping("/toPetPdf.do")
	public ModelAndView toPdf(PetVO vo)
	{
		System.out.println("[Controller] PetController -> PDF�� ���");
		
		ModelAndView mav=new ModelAndView();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<PetVO> petList=petService.getPetList(vo);
		mav.addObject("petList", petList);
		mav.setViewName("petPdf");
		
		return mav;
	}
}
