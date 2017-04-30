package syu.DBproject.biz.pet;

import java.util.List;

public interface PetService
{
	//CRUD±‚¥…
	void insertPet(PetVO vo); //∆Í µÓ∑œ
	void updatePet(PetVO vo); //∆Í ºˆ¡§
	void deletePet(PetVO vo); //∆Í ªË¡¶
	PetVO getPet(PetVO vo); //∆Í ªÛºº¡∂»∏
	List<PetVO> getPetList(PetVO vo); //∆Í ∏Ò∑œ¡∂»∏
}
