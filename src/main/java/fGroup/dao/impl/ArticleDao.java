package fGroup.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fGroup.dao.IArticleDao;
import fGroup.dto.Article;

@Repository
public class ArticleDao implements IArticleDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


	@Override
	public List<Article> findByConditions(Article article) {

		List<String> condition = new ArrayList<String>();
		MapSqlParameterSource param = new MapSqlParameterSource();

		String keyword = article.getKeyword();

		if(keyword != null) {
			condition.add("keyword = :keyword");
			param.addValue("keyword", "%" + keyword + "%");
		}

		String sql = "SELECT * FROM article WHERE article_title LIKE :keyword OR article_main LIKE :keyword ORDER BY contribute_date";
		List<Article> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Article>(Article.class));

		return resultList;
	}

//    @Override
//	public Article findByKeyword(String keyword) {
//
//		String sql = "SELECT * FROM article WHERE article_title LIKE :keyword OR article_main LIKE :keyword ORDER BY contribute_date";
//		MapSqlParameterSource param = new MapSqlParameterSource();
//		param.addValue("keyword", keyword);
//
//		List<Article> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Article>(Article.class));
//
//		return resultList.isEmpty() ? null : resultList.get(0);
//	}


	}




