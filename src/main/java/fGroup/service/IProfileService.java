package fGroup.service;

import java.util.List;

import fGroup.dto.Profile;

public interface IProfileService {

	//void update(Profile profile);

//	Profile findById(Integer id);

	//List<Profile> findByConditions(Profile profile);

	List<Profile> findByConditions(Integer userid);

	//void update(Integer userid);

	Profile update(Profile userid);

}
