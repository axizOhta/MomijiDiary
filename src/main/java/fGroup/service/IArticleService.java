package fGroup.service;

import java.util.List;

import fGroup.dto.Article;

public interface IArticleService {

	public List<Article> findByConditions(Article article);

}
