package fGroup.test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import fGroup.dto.Article;
import fGroup.service.UserUpService;
import fGroup.service.impl.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleForceDeleteTest {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	private UserUpService artS;

	@Autowired
	private ArticleService artA;

	@Before
	public void setup() {
	  jT.update("DELETE FROM article");
	  jT.update("INSERT INTO article (article_id, user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?, ?)"
			  ,10001 , 100, "佐藤", "testタイトル", "テスト本文", "2018/05");
	  jT.update("INSERT INTO article (article_id, user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?, ?)"
			  ,10002 , 200, "田中", "テストタイトル", "test本文", "2018/05");
	  jT.update("INSERT INTO article (article_id, user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?, ?)"
			  ,10003 , 300, "十六", "test", "test本文", "2018/05");
	  jT.update("INSERT INTO article (article_id, user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?, ?)"
			  ,10004 , 400, "non", "non", "non", "2018/05");
	}


	@Test
	public void deleteでデータを削除できる() throws Exception {
		Article article = new Article();
    	article.setKeyword("テスト本文");

		artS.artDelete(10001);

    	assertThat(artA.findByConditions(article).size(), is(0));

//    	List<Article> list = artA.findByConditions(article);
//    	Article art1 = list.get(0);
//
//    	assertNull(art1.getArticle_id());

//		user = userDao.findById(1);
//		assertNull(user);
	}

//	@Test
//	public void deleteでデータを複数削除できる() throws Exception {
//		Article article = new Article();
//    	article.setKeyword("テスト本文");
//
//		for(String art_id : check) {
//
//			Article art = artS.selectArt(Integer.parseInt(art_id));
//			list.add(art);
//		}
//		model.addAttribute("userlist", list);
//		session.setAttribute("delList", list);
//
//    	//List<Article> list = (List<Article>) session.getAttribute("delList");
//		for (Article art : list) {
//			artS.artDelete(art.getArticle_id());
//		}
//
//		artS.artDelete(10001);
//
//    	assertThat(artA.findByConditions(article).size(), is(0));
//
//
//}
}
