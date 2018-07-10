package fGroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fGroup.dao.impl.ProfileDao;
import fGroup.dto.Profile;
import fGroup.service.IProfileService;

@Service
@Transactional
public class ProfileService implements IProfileService {

	@Autowired
	private ProfileDao profileDao;

//	@Override
//	public Profile findById(Integer id) {
//		return profileDao.findById(id);
//	}

//	@Override
//	public Profile update(Profile userid) {
//		profileDao.update(userid);
//	}

	@Override
	public List<Profile> findByConditions(Integer userid) {
    	return profileDao.findByConditions(userid);
    }

	public Profile findById(Integer userId) {

		return profileDao.findById(userId);
	}



}
