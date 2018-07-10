package fGroup.dao;

import java.util.List;

import fGroup.dto.Profile;

public interface IProfileDao {

	//void update(Profile profile);

	//List<Profile> findByConditions(Profile profile);

	List<Profile> findByConditions(Integer userid);

	//void update(Integer userid);

	void update(Profile userid);

}
