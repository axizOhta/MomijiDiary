package fGroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fGroup.dao.ProfileDao;
import fGroup.dto.Profile;

@Service
public class ProfileService {

	@Autowired
	ProfileDao profileDao;

	public Profile FindById (Integer id) {
		return profileDao.FindById(id);

	}

	public void update(Profile updateProfile, Profile beforeProfile) {
		String newImage = updateProfile.getProfile_image();
		String newName =updateProfile.getName();
		String newSex = updateProfile.getSex();
		Integer newBirthyear = updateProfile.getBirthyear();
		Integer newBirthmonth = updateProfile.getBirthmonth();
		Integer newBirthday = updateProfile.getBirthday();
		String newHobby = updateProfile.getHobby();
		String newSelfIntroduction = updateProfile.getSelf_introduction();

		if(!(newImage.equals(beforeProfile.getProfile_image())) && !(newImage.equals(""))) {
			profileDao.updateImage(updateProfile);
		}
		if(!(newName.equals(beforeProfile.getName())) && !(newName.equals(""))) {
			profileDao.updateName(updateProfile);
		}
		if(!(newSex.equals(beforeProfile.getSex())) && !(newSex.equals(""))){
			profileDao.updateSex(updateProfile);
		}
		if(newBirthyear != beforeProfile.getBirthyear() && newBirthyear != null){
			profileDao.updateBirthyear(updateProfile);
		}
		if(newBirthmonth != beforeProfile.getBirthmonth() && newBirthmonth != null){
			profileDao.updateBirthmonth(updateProfile);
		}
		if(newBirthday != beforeProfile.getBirthday() && newBirthday != null){
			profileDao.updateBirthday(updateProfile);
		}
		if(!(newHobby.equals(beforeProfile.getHobby())) && !(newHobby.equals("")) && newHobby != null){
			profileDao.updateHobby(updateProfile);
		}
		if(!(newSelfIntroduction.equals(beforeProfile.getSelf_introduction())) && !(newSelfIntroduction.equals(""))){
			profileDao.updateSelfIntroduction(updateProfile);
		}
	}

}
