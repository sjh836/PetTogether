package syu.DBproject.biz.pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("petService")
public class PetServiceImpl implements PetService
{
	@Autowired
	private PetDAO petDAO;
	
	public PetServiceImpl()
	{
		System.out.println("PetServiceImpl °´Ã¼ »ý¼º");
	}
	public void insertPet(PetVO vo)
	{
		petDAO.insertPet(vo);
	}
	public void updatePet(PetVO vo)
	{
		petDAO.updatePet(vo);
	}
	public void deletePet(PetVO vo)
	{
		petDAO.deletePet(vo);
	}
	public PetVO getPet(PetVO vo)
	{
		return petDAO.getPet(vo);
	}
	public List<PetVO> getPetList(PetVO vo)
	{
		return petDAO.getPetList(vo);
	}
}
