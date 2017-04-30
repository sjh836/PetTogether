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
		System.out.println("[Controller] PetController 객체 생성");
	}
	//펫 등록
	@RequestMapping("/insertPet.do")
	public String insertPet(PetVO vo) throws IOException
	{
		System.out.println("[Controller] PetControlle -> 펫 등록 처리");
		
		MultipartFile uploadFile=vo.getUploadFile();
		if(!uploadFile.isEmpty())
		{
			String fileName=uploadFile.getOriginalFilename(); //파일이름 추출
			uploadFile.transferTo(new File("D:/Spring workspace/DBproject16-2/src/main/webapp/resources/bootstrap/img/works/"+fileName)); //파일이 올라가는곳
		}
		petService.insertPet(vo);
		return "redirect:getPetList.do";
	}
	//펫 수정 뷰
	@RequestMapping("/getUpdatePet.do")
	public String getUpdatePet(PetVO vo, Model model)
	{
		System.out.println("[Controller] PetController -> 펫 수정 화면 처리");
		
		model.addAttribute("pet", petService.getPet(vo));
		
		return "updatePet";
	}
	//펫 수정
	@RequestMapping("/updatePet.do")
	public String updatePet(@ModelAttribute("pet")PetVO vo)
	{
		System.out.println("[Controller] PetController -> 펫 수정 처리");
		
		petService.updatePet(vo);
		
		return "redirect:getPetList.do";
	}
	//펫 삭제
	@RequestMapping("/deletePet.do")
	public String deletePet(PetVO vo)
	{
		System.out.println("[Controller] PetController -> 펫 수정 처리");
		
		petService.deletePet(vo);

		return "redirect:admin2.do";
	}
	//펫 상세 조회
	@RequestMapping("/getPet.do")
	public String getPet(PetVO vo, Model model)
	{
		System.out.println("[Controller] PetController -> 펫 상세 조회 처리");
		
		model.addAttribute("pet", petService.getPet(vo));
		
		return "getPet";
	}
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchCondition()
	{
		Map<String, String> conditionMap=new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	//펫 목록 조회
	@RequestMapping("/getPetList.do")
	public String getBoardList(PetVO vo, Model model, HttpSession session)
	{
		System.out.println("[Controller] PetListController -> 펫 목록 검색처리");
		
		if(session.getAttribute("userName")==null)
		{
			throw new IllegalArgumentException("권한이 없습니다.");
		}
		
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		model.addAttribute("petList", petService.getPetList(vo)); //Model정보 저장

		return "getPetList";
	}
	//펫 목록조회
	@RequestMapping("/admin2.do")
	public String getAdminPetList(PetVO vo, Model model, HttpSession session)
	{
		System.out.println("[Controller] PetController -> 관리자 펫목록 처리");
		
		if(session.getAttribute("userName")==null)
		{
			throw new IllegalArgumentException("권한이 없습니다.");
		}
		
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		model.addAttribute("petList2", petService.getPetList(vo)); //Model정보 저장
		
		return "admin2";
	}
	//Json 출력
	@RequestMapping("/petTransJson.do")
	@ResponseBody
	public List<PetVO> dataTransform(PetVO vo)
	{
		System.out.println("[Controller] PetController -> Json으로 출력");
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<PetVO> petList=petService.getPetList(vo);
		return petList;
	}
	//엑셀 출력
	@RequestMapping("/toPetExcel.do")
	public ModelAndView toExcel(PetVO vo)
	{
		System.out.println("[Controller] PetController -> Excel으로 출력");
		
		ModelAndView mav=new ModelAndView();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<PetVO> petList=petService.getPetList(vo);
		mav.addObject("petList", petList);
		mav.setViewName("petExcel");
		
		return mav;
	}
	//PDF 출력
	@RequestMapping("/toPetPdf.do")
	public ModelAndView toPdf(PetVO vo)
	{
		System.out.println("[Controller] PetController -> PDF로 출력");
		
		ModelAndView mav=new ModelAndView();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<PetVO> petList=petService.getPetList(vo);
		mav.addObject("petList", petList);
		mav.setViewName("petPdf");
		
		return mav;
	}
}
