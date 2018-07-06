package fGroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fGroup.dao.UserInsertDao;
import fGroup.dto.Users;

@Service
@Transactional
public class UserInsertService {

	@Autowired
	private UserInsertDao userinsertDao;

	public Users findLoginId(String login_id) {

		return userinsertDao.findLoginId(login_id);
	}

	public int insert (Users users) {
		return userinsertDao.register(users);
	}

}
