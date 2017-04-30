package syu.DBproject.biz.pet;

import java.util.List;

public interface PetService
{
	//CRUD���
	void insertPet(PetVO vo); //�� ���
	void updatePet(PetVO vo); //�� ����
	void deletePet(PetVO vo); //�� ����
	PetVO getPet(PetVO vo); //�� ����ȸ
	List<PetVO> getPetList(PetVO vo); //�� �����ȸ
}
