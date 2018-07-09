package fGroup.dao;

import java.util.List;

import fGroup.dto.Article;

public interface IArticleDao {



	//List<Article> findByConditions(String keyword);

	List<Article> findByConditions(Article article);

	//Article findByKeyword(String keyword);

	//List<Article> findByConditions(String keyword);





}
