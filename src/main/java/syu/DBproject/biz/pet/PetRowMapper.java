package syu.DBproject.biz.pet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PetRowMapper implements RowMapper<PetVO>
{
	@Override
	public PetVO mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		PetVO pet=new PetVO();
		pet.setPno(rs.getInt("PNO"));
		pet.setTitle(rs.getString("TITLE"));
		pet.setWriter(rs.getString("WRITER"));
		pet.setContent(rs.getString("CONTENT"));
		pet.setRegDate(rs.getDate("REGDATE"));
		pet.setCount(rs.getInt("COUNT"));
		pet.setImagePath(rs.getString("IMAGEPATH"));
		pet.setHabitat(rs.getString("HABITAT"));
		
		return pet;
	}
}
