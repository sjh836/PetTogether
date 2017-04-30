package syu.DBproject.view;

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

import syu.DBproject.biz.board.BoardVO;
import syu.DBproject.biz.board.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController
{
	@Autowired
	private BoardService boardService;
	
	public BoardController()
	{
		System.out.println("[Controller] BoardController ��ü ����");
	}
	//�� ���
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException
	{
		System.out.println("[Controller] BoardControlle -> �� ��� ó��");
		
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	//�� ���� ��
	@RequestMapping("/getUpdateBoard.do")
	public String getUpdateBoard(BoardVO vo, Model model)
	{
		System.out.println("[Controller] BoardController -> �� ���� ȭ�� ó��");
		
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "updateBoard";
	}
	//�� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")BoardVO vo)
	{
		System.out.println("[Controller] BoardController -> �� ���� ó��");
		
		boardService.updateBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	//�� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo)
	{
		System.out.println("[Controller] BoardController -> �� ���� ó��");
		
		boardService.deleteBoard(vo);

		return "redirect:getBoardList.do";
	}
	//�� �� ��ȸ
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model)
	{
		System.out.println("[Controller] BoardController -> �� �� ��ȸ ó��");
		
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getBoard";
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
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, HttpSession session)
	{
		System.out.println("[Controller] BoardListController -> �� ��� �˻�ó��");
		
		if(session.getAttribute("userName")==null)
		{
			throw new IllegalArgumentException("������ �����ϴ�.");
		}
		
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); //Model���� ����

		return "getBoardList";
	}
	@RequestMapping("/boardTransJson.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo)
	{
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList=boardService.getBoardList(vo);
		return boardList;
	}
}