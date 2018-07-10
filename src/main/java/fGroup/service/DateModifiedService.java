package fGroup.service;

import org.springframework.beans.factory.annotation.Autowired;

import fGroup.dao.DateModifiedDao;
import fGroup.dto.Users;

public class DateModifiedService {

	@Autowired
	private DateModifiedDao dateModifiedDao;

	public Users dateModified(Integer user_id) {

		return dateModifiedDao.dateModified(user_id);
	}

}
