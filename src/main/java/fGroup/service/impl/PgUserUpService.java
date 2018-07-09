package fGroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fGroup.dao.UserUpDao;
import fGroup.dto.Article;
import fGroup.dto.Users;
import fGroup.service.UserUpService;

@Service
public class PgUserUpService implements UserUpService {
	@Autowired
	private UserUpDao userUpDao;
	@Override
	public List<Users> find(Users user) {
			return userUpDao.findAll();
	}

	@Override
	public List<Article> findByName(Integer id) {
		return userUpDao.findByName(id);
	}

	@Override
	public void userUpdate(Users user) {
		userUpDao.userUpdate(user);
	}

	@Override
	public void proUpdate(Users user) {
		userUpDao.proUpdate(user);
	}

	@Override
	public void artDelete( Integer id) {
		userUpDao.artDelete(id);
	}

	@Override
	public void userDelete(Integer id) {
		userUpDao.userDelete(id);
	}
}

