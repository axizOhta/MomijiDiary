package fGroup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fGroup.dao.impl.ArticleDao;
import fGroup.dto.Article;
import fGroup.service.IArticleService;

@Service
@Transactional
public class ArticleService implements IArticleService {

	@Autowired
	private ArticleDao articleDao;

//	@Override
//	public List<Article> findByConditions(String keyword) {
//    	return articleDao.findByConditions(keyword);
//    }

	@Override
	public List<Article> findByConditions(Article article) {
    	return articleDao.findByConditions(article);
    }

//	public Article findByKeyword(String keyword) {
//		return null;
//	}


}
