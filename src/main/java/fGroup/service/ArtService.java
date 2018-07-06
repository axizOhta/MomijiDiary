package fGroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fGroup.dao.ArtDao;
import fGroup.dto.Article;

@Service
public class ArtService {

	@Autowired
	ArtDao artDao;

	public Article selectArt(Integer art_id) {
		List<Article> list = artDao.selectArt(art_id);
		if(list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public Integer lastId() {
		return artDao.lastId();
	}

	public void insert(String title, String date, String content, Integer user_id, String name) {
		artDao.insert(title, date, content, user_id, name);
	}

	public void update(Integer article_id, String article_title, String article_main) {
		artDao.update(article_id, article_title, article_main);
	}

	public void delete(Integer article_id) {
		artDao.delete(article_id);
	}

}
