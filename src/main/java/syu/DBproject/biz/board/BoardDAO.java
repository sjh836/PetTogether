package syu.DBproject.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL��ɾ��
	private final String BOARD_INSERT="insert into board(bno, title, writer, content) values((select nvl(max(bno),0)+1 from board),?,?,?)";
	private final String MEMBER_GRADE="update member set grade=grade+50 where id=?";
	private final String BOARD_UPDATE="update board set title=?, content=? where bno=?";
	private final String BOARD_DELETE="delete from board where bno=?";
	private final String BOARD_COUNT="update board set count=count+1 where bno=?";
	private final String BOARD_GET="select * from board where bno=?";
	private final String BOARD_LIST_T="select * from board where title like '%'||?||'%' order by bno desc";
	private final String BOARD_LIST_C="select * from board where content like '%'||?||'%' order by bno desc";
	
	//CRUD���
	//�۵��
	public void insertBoard(BoardVO vo)
	{
		System.out.println("[Model] insertBoard() ��� ó��");
		jdbcTemplate.update(MEMBER_GRADE, vo.getId()); //Ȱ������ 50�� ����
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	//�ۼ���
	public void updateBoard(BoardVO vo)
	{
		System.out.println("[Model] updateBoard() ��� ó��");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getBno());
	}
	
	//�ۻ���
	public void deleteBoard(BoardVO vo)
	{
		System.out.println("[Model] deleteBoard() ��� ó��");
		jdbcTemplate.update(BOARD_DELETE, vo.getBno());
	}
	
	//�� ����ȸ
	public BoardVO getBoard(BoardVO vo)
	{
		System.out.println("[Model] getBoard() ��� ó��");
		Object[] args={vo.getBno()};
		jdbcTemplate.update(BOARD_COUNT, vo.getBno());
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	//�� �����ȸ
	public List<BoardVO> getBoardList(BoardVO vo)
	{
		System.out.println("[Model] JDBC�� getBoardList() ��� ó��");
		Object[] args={vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		else if(vo.getSearchCondition().equals("CONTENT")) return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		return null;
	}
}
