package fGroup.service;

import org.springframework.beans.factory.annotation.Autowired;

import fGroup.dao.DateModifiedDao;

public class DateModifiedService {

	@Autowired
	private DateModifiedDao dateModifiedDao;

	public void dateModified(Integer user_id) {

		dateModifiedDao.dateModified(user_id);
	}

}
