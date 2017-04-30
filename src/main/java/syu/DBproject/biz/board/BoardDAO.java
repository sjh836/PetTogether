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
	
	//SQL명령어들
	private final String BOARD_INSERT="insert into board(bno, title, writer, content) values((select nvl(max(bno),0)+1 from board),?,?,?)";
	private final String MEMBER_GRADE="update member set grade=grade+50 where id=?";
	private final String BOARD_UPDATE="update board set title=?, content=? where bno=?";
	private final String BOARD_DELETE="delete from board where bno=?";
	private final String BOARD_COUNT="update board set count=count+1 where bno=?";
	private final String BOARD_GET="select * from board where bno=?";
	private final String BOARD_LIST_T="select * from board where title like '%'||?||'%' order by bno desc";
	private final String BOARD_LIST_C="select * from board where content like '%'||?||'%' order by bno desc";
	
	//CRUD기능
	//글등록
	public void insertBoard(BoardVO vo)
	{
		System.out.println("[Model] insertBoard() 기능 처리");
		jdbcTemplate.update(MEMBER_GRADE, vo.getId()); //활동점수 50점 지급
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	//글수정
	public void updateBoard(BoardVO vo)
	{
		System.out.println("[Model] updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getBno());
	}
	
	//글삭제
	public void deleteBoard(BoardVO vo)
	{
		System.out.println("[Model] deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getBno());
	}
	
	//글 상세조회
	public BoardVO getBoard(BoardVO vo)
	{
		System.out.println("[Model] getBoard() 기능 처리");
		Object[] args={vo.getBno()};
		jdbcTemplate.update(BOARD_COUNT, vo.getBno());
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	//글 목록조회
	public List<BoardVO> getBoardList(BoardVO vo)
	{
		System.out.println("[Model] JDBC로 getBoardList() 기능 처리");
		Object[] args={vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		else if(vo.getSearchCondition().equals("CONTENT")) return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		return null;
	}
}
