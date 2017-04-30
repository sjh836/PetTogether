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
	
	//SQL��ɾ��
	private final String PET_INSERT="insert into pet(pno, title, writer, habitat, content, imagepath) values((select nvl(max(pno),0)+1 from pet),?,?,?,?,?)";
	private final String MEMBER_GRADE="update member set grade=grade+100 where id=?";
	private final String PET_UPDATE="update pet set title=?, content=?, habitat=? where pno=?";
	private final String PET_DELETE="delete from pet where pno=?";
	private final String PET_GET="select * from pet where pno=?";
	private final String PET_LIST_T="select * from pet where title like '%'||?||'%' order by pno";
	private final String PET_LIST_C="select * from pet where content like '%'||?||'%' order by pno";
	
	//CRUD���
	//����
	public void insertPet(PetVO vo)
	{
		System.out.println("[Model] insertPet() ��� ó��");
		jdbcTemplate.update(MEMBER_GRADE, vo.getId()); //Ȱ������ 100�� ����
		jdbcTemplate.update(PET_INSERT, vo.getTitle(), vo.getWriter(), vo.getHabitat(), vo.getContent(), "resources/bootstrap/img/works/"+vo.getUploadFile().getOriginalFilename());
		//���� ������: D:/Spring workspace/DBproject16-2/src/main/webapp/resources/bootstrap/img/works/
	}
	
	//�����
	public void updatePet(PetVO vo)
	{
		System.out.println("[Model] updatePet() ��� ó��");
		jdbcTemplate.update(PET_UPDATE, vo.getTitle(), vo.getContent(), vo.getHabitat(), vo.getPno());
	}
	
	//�����
	public void deletePet(PetVO vo)
	{
		System.out.println("[Model] deletePet() ��� ó��");
		jdbcTemplate.update(PET_DELETE, vo.getPno());
	}
	
	//�� ����ȸ
	public PetVO getPet(PetVO vo)
	{
		System.out.println("[Model] getPet() ��� ó��");
		Object[] args={vo.getPno()};
		return jdbcTemplate.queryForObject(PET_GET, args, new PetRowMapper());
	}
	
	//�� �����ȸ
	public List<PetVO> getPetList(PetVO vo)
	{
		System.out.println("[Model] JDBC�� getPetList() ��� ó��");
		Object[] args={vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) return jdbcTemplate.query(PET_LIST_T, args, new PetRowMapper());
		else if(vo.getSearchCondition().equals("CONTENT")) return jdbcTemplate.query(PET_LIST_C, args, new PetRowMapper());
		return null;
	}
}
