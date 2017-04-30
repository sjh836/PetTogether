package syu.DBproject.biz.board;

import java.util.List;

public interface BoardService
{
	//CRUD기능
	void insertBoard(BoardVO vo); //글등록
	void updateBoard(BoardVO vo); //글수정
	void deleteBoard(BoardVO vo); //글삭제
	BoardVO getBoard(BoardVO vo); //글 상세조회
	List<BoardVO> getBoardList(BoardVO vo); //글 목록조회
}