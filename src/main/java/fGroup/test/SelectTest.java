package fGroup.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import fGroup.dto.Article;
import fGroup.service.impl.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	private ArticleService artS;

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
    public void 検索結果0件() throws Exception {
    	Article article = new Article();
    	article.setKeyword("aaaaaaaaaaaaaa");

    	assertThat(artS.findByConditions(article).size(), is(0));
    }

    @Test
    public void 検索結果1件() throws Exception {
    	Article article = new Article();
    	article.setKeyword("テストタイトル");

    	List<Article> list = artS.findByConditions(article);
    	Article art1 = list.get(0);

    	assertThat(list.size(), is(1));
    	assertThat(art1.getArticle_id(), is(10002));
    	assertThat(art1.getUser_id(), is(200));
    }

    @Test
    public void 検索結果2件以上() throws Exception {
    	Article article = new Article();
    	article.setKeyword("test");

    	List<Article> list = artS.findByConditions(article);

    	assertThat(list.size(), is(3));

    	Article art1 = list.get(0);
    	Article art2 = list.get(1);
    	Article art3 = list.get(2);

    	assertThat(art1.getArticle_id(), is(10001));
    	assertThat(art1.getUser_id(), is(100));
    	assertThat(art2.getArticle_id(), is(10002));
    	assertThat(art2.getUser_id(), is(200));
    	assertThat(art3.getArticle_id(), is(10003));
    	assertThat(art3.getUser_id(), is(300));
    }

}
