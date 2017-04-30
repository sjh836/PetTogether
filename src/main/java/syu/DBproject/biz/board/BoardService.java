package syu.DBproject.biz.board;

import java.util.List;

public interface BoardService
{
	//CRUD���
	void insertBoard(BoardVO vo); //�۵��
	void updateBoard(BoardVO vo); //�ۼ���
	void deleteBoard(BoardVO vo); //�ۻ���
	BoardVO getBoard(BoardVO vo); //�� ����ȸ
	List<BoardVO> getBoardList(BoardVO vo); //�� �����ȸ
}