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
}
