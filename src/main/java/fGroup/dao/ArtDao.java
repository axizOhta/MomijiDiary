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

	public List<Article> selectArt(Integer art_id) {
		return jT.query(SELECT_WHERE_ArtId, new BeanPropertyRowMapper<Article>(Article.class), art_id);

	}

}
