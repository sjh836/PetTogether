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
		System.out.println("[Controller] BoardController 객체 생성");
	}
	//글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException
	{
		System.out.println("[Controller] BoardControlle -> 글 등록 처리");
		
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	//글 수정 뷰
	@RequestMapping("/getUpdateBoard.do")
	public String getUpdateBoard(BoardVO vo, Model model)
	{
		System.out.println("[Controller] BoardController -> 글 수정 화면 처리");
		
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "updateBoard";
	}
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")BoardVO vo)
	{
		System.out.println("[Controller] BoardController -> 글 수정 처리");
		
		boardService.updateBoard(vo);
		
		return "redirect:getBoardList.do";
	}
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo)
	{
		System.out.println("[Controller] BoardController -> 글 수정 처리");
		
		boardService.deleteBoard(vo);

		return "redirect:getBoardList.do";
	}
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model)
	{
		System.out.println("[Controller] BoardController -> 글 상세 조회 처리");
		
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getBoard";
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
	//글 목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, HttpSession session)
	{
		System.out.println("[Controller] BoardListController -> 글 목록 검색처리");
		
		if(session.getAttribute("userName")==null)
		{
			throw new IllegalArgumentException("권한이 없습니다.");
		}
		
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); //Model정보 저장

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