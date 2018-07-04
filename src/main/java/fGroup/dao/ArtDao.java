package fGroup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fGroup.dto.Article;

@Repository
public class ArtDao {

	@Autowired
    private JdbcTemplate jT;

	String SELECT_WHERE_ArtId = "SELECT article_id, user_id, name, article_title, article_main, image_1, image_2, image_3, image_4, contribute_date FROM article WHERE article_id = ?";
	String SELECT_LAST_ARTID = "SELECT MAX(article_id) FROM article";
	String INSERT_POST_ART = "INSERT INTO article (user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?)";
	String UPDATE_EDIT_ART = "UPDATE article SET article_title = ?, article_main = ? WHERE article_id = ?";

	public List<Article> selectArt(Integer art_id) {
		return jT.query(SELECT_WHERE_ArtId, new BeanPropertyRowMapper<Article>(Article.class), art_id);

	}

	public Integer lastId() {
		return jT.queryForObject(SELECT_LAST_ARTID, Integer.class);
	}

	public void insert(String title, String date, String content, Integer user_id, String name) {
		jT.update(INSERT_POST_ART, user_id, name, title , content, date);

	}

	public void update(Integer article_id, String article_title, String article_main) {
		jT.update(UPDATE_EDIT_ART, article_title, article_main , article_id);
	}

}
