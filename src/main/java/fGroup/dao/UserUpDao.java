package fGroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fGroup.dto.Article;
import fGroup.dto.Users;
@Repository
public interface UserUpDao {
	public List<Users> findAll();

	public List<Article> findByName(Integer id);

	public void userUpdate( Users user);

	public void proUpdate( Users user);

	public void artDelete( Integer id);

	public void userDelete(Integer id);

}
