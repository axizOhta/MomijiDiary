package fGroup.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fGroup.dao.UserUpDao;
import fGroup.dto.Article;
import fGroup.dto.Users;
@Repository
public class PgUserUpDao  implements UserUpDao{
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;



	public List<Users> findAll() {//ユーザー情報取得
		String sql = "SELECT * FROM users WHERE unsubscribe_flug = false ORDER BY user_id";
		List<Users> resultList = npJdbcTemplate.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
		return resultList;
	}

	@Override
	public List<Article> findByName(Integer user_id) {//記事情報取得
		String sql = "SELECT * FROM article WHERE user_id =:user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user_id);
		List<Article> resultList = npJdbcTemplate.query(sql, param,new BeanPropertyRowMapper<Article>(Article.class));
		return resultList;
	}

	public void userUpdate(Users user) {//ユーザー情報更新
		String sql ="UPDATE users SET name = :user_name,email_address = :email,password = :password WHERE user_id =:user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user.getUser_id());
		param.addValue("user_name", user.getName());
		param.addValue("email", user.getEmail_address());
		param.addValue("password", user.getPassword());
		npJdbcTemplate.update(sql, param);
	}

	public void proUpdate(Users user) {//プロフィール名前更新
		String sql ="UPDATE profile SET name = :user_name WHERE user_id =:user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user.getUser_id());
		param.addValue("user_name", user.getName());
		npJdbcTemplate.update(sql, param);
	}


	public void artDelete(Integer id) {//記事削除
		String sql ="DELETE FROM article WHERE article_id = :article_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("article_id", id);
		npJdbcTemplate.update(sql, param);
	}

	public void userDelete(Integer id) {//強制退会
		String sql ="UPDATE users SET unsubscribe_flug = (CASE WHEN (SELECT unsubscribe_flug FROM users WHERE user_id = :user_id)=true THEN false ELSE true END)WHERE user_id = :user_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", id);
		npJdbcTemplate.update(sql, param);
	}

}
