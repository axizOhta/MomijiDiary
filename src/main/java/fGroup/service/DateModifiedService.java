package fGroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fGroup.dao.DateModifiedDao;

@Service
public class DateModifiedService {

	@Autowired
	private DateModifiedDao dateModifiedDao;

	public void dateModified(Integer user_id) {

		dateModifiedDao.dateModified(user_id);
	}

}
