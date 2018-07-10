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

	public void insert(String title, String date, String content, Integer user_id, String name, String image01, String image02, String image03, String image04) {
		artDao.insert(title, date, content, user_id, name,image01,image02,image03,image04);
	}

	public void update(Integer article_id, String article_title, String article_main) {
		artDao.update(article_id, article_title, article_main);
	}

	public void delete(Integer article_id) {
		artDao.delete(article_id);
	}

	public List<Article> getAllArt(Integer user_id) {

        return artDao.findByUserId(user_id);
    }

	public boolean existUser(Integer user_id) {
		return artDao.existUser(user_id);
	}

	//画像パスをデータベースに突っ込む
//	public void updateImages(String image01path, String image02path, String image03path, String image04path) {
//
//		if(!((image01path).equals("")){
//			artDao.insertImage01(image01path);
//		}
//		if(!((image02path).equals("")){
//			artDao.insertImage02(image02path);
//		}
//		if(!((image03path).equals("")){
//			artDao.insertImage03(image03path);
//		}
//		if(!((image04path).equals("")){
//			artDao.insertImage04(image04path);
//		}
//	}


}
