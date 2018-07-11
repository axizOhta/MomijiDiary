package fGroup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import fGroup.dto.Article;
import fGroup.dto.Users;

@Repository
public class ArtDao {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	private NamedParameterJdbcTemplate nPJT;

	String SELECT_WHERE_ArtId = "SELECT article_id, user_id, name, article_title, article_main, image_1, image_2, image_3, image_4, contribute_date FROM article WHERE article_id = ?";
	String SELECT_LAST_ARTID = "SELECT MAX(article_id) FROM article";
	String INSERT_POST_ART = "INSERT INTO article (user_id, name, article_title, article_main,image_1, image_2, image_3, image_4, contribute_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String UPDATE_EDIT_ART = "UPDATE article SET article_title = ?, article_main = ? WHERE article_id = ?";
	String DELETE_ART = "DELETE FROM article WHERE article_id = ?";
	String SELECT_BY_UserId = "SELECT article_id, user_id, name, article_title, article_main, image_1, image_2, image_3, image_4, contribute_date FROM article WHERE user_id = ? ORDER BY article_id DESC";
	String SELECT_USER_EXIST ="SELECT user_id FROM users WHERE user_id = ? AND unsubscribe_flug = false";

	public List<Article> selectArt(Integer art_id) {
		return jT.query(SELECT_WHERE_ArtId, new BeanPropertyRowMapper<Article>(Article.class), art_id);

	}

	public Integer lastId() {
		return jT.queryForObject(SELECT_LAST_ARTID, Integer.class);
	}

	public void insert(String title, String date, String content, Integer user_id, String name, String image01, String image02, String image03, String image04) {
		jT.update(INSERT_POST_ART, user_id, name, title , content, image01, image02, image03, image04, date);

	}

	public void update(Integer article_id, String article_title, String article_main) {
		jT.update(UPDATE_EDIT_ART, article_title, article_main , article_id);
	}

	public void delete(Integer article_id) {
		jT.update(DELETE_ART, article_id);
	}

	public List<Article> findByUserId(Integer user_id){

		return jT.query(SELECT_BY_UserId, new BeanPropertyRowMapper<Article>(Article.class), user_id);
	}

	public boolean existUser(Integer user_id) {
		 List<Users> list = jT.query(SELECT_USER_EXIST, new BeanPropertyRowMapper<Users>(Users.class), user_id);

		 if (list.size() == 0) {
			 return false;
		 }

		return true;
	}

	public void updateImage01(Integer art_id, String newImage01) {
		Integer id = art_id;
		String image = newImage01;

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("image", image);

		 nPJT.update("UPDATE article SET image_1 = :image WHERE article_id= :id", param);
	}

	public void updateImage02(Integer art_id, String newImage02) {
		Integer id = art_id;
		String image = newImage02;

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("image", image);

		 nPJT.update("UPDATE article SET image_2 = :image WHERE article_id= :id", param);
	}

	public void updateImage03(Integer art_id, String newImage03) {
		Integer id = art_id;
		String image = newImage03;

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("image", image);

		 nPJT.update("UPDATE article SET image_3 = :image WHERE article_id= :id", param);
	}

	public void updateImage04(Integer art_id, String newImage04) {
		Integer id = art_id;
		String image = newImage04;

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("image", image);

		 nPJT.update("UPDATE article SET image_4 = :image WHERE article_id= :id", param);
	}
}
