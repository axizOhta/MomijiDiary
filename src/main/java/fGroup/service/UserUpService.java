package fGroup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fGroup.dto.Article;
import fGroup.dto.Users;
@Service
public interface UserUpService {
	public List<Users> find(Users user);
	public List<Article> findByName(Integer id);
	public void userUpdate(Users user);
	public void proUpdate(Users user);
	public void artDelete( Integer id);
	public void userDelete(Integer id);
}
