package syu.DBproject.biz.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PetDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL명령어들
	private final String PET_INSERT="insert into pet(pno, title, writer, habitat, content, imagepath) values((select nvl(max(pno),0)+1 from pet),?,?,?,?,?)";
	private final String MEMBER_GRADE="update member set grade=grade+100 where id=?";
	private final String PET_UPDATE="update pet set title=?, content=?, habitat=? where pno=?";
	private final String PET_DELETE="delete from pet where pno=?";
	private final String PET_GET="select * from pet where pno=?";
	private final String PET_LIST_T="select * from pet where title like '%'||?||'%' order by pno";
	private final String PET_LIST_C="select * from pet where content like '%'||?||'%' order by pno";
	
	//CRUD기능
	//펫등록
	public void insertPet(PetVO vo)
	{
		System.out.println("[Model] insertPet() 기능 처리");
		jdbcTemplate.update(MEMBER_GRADE, vo.getId()); //활동점수 100점 지급
		jdbcTemplate.update(PET_INSERT, vo.getTitle(), vo.getWriter(), vo.getHabitat(), vo.getContent(), "resources/bootstrap/img/works/"+vo.getUploadFile().getOriginalFilename());
		//파일 저장경로: D:/Spring workspace/DBproject16-2/src/main/webapp/resources/bootstrap/img/works/
	}
	
	//펫수정
	public void updatePet(PetVO vo)
	{
		System.out.println("[Model] updatePet() 기능 처리");
		jdbcTemplate.update(PET_UPDATE, vo.getTitle(), vo.getContent(), vo.getHabitat(), vo.getPno());
	}
	
	//펫삭제
	public void deletePet(PetVO vo)
	{
		System.out.println("[Model] deletePet() 기능 처리");
		jdbcTemplate.update(PET_DELETE, vo.getPno());
	}
	
	//펫 상세조회
	public PetVO getPet(PetVO vo)
	{
		System.out.println("[Model] getPet() 기능 처리");
		Object[] args={vo.getPno()};
		return jdbcTemplate.queryForObject(PET_GET, args, new PetRowMapper());
	}
	
	//펫 목록조회
	public List<PetVO> getPetList(PetVO vo)
	{
		System.out.println("[Model] JDBC로 getPetList() 기능 처리");
		Object[] args={vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) return jdbcTemplate.query(PET_LIST_T, args, new PetRowMapper());
		else if(vo.getSearchCondition().equals("CONTENT")) return jdbcTemplate.query(PET_LIST_C, args, new PetRowMapper());
		return null;
	}
}
