package fGroup.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fGroup.dto.Article;
import fGroup.service.impl.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {


//
//	@Autowired
//	ApplicationContext ctx;

	@Autowired
	private ArticleService artS;

//	@Before
//	public void setup() {
//	  artS = ctx.getAutowireCapableBeanFactory().createBean(ArticleService.class);
//	  jdbcTemplate = ctx.getAutowireCapableBeanFactory().createBean(NamedParameterJdbcTemplate.class);
//	  artDao = ctx.getAutowireCapableBeanFactory().createBean(ArticleDao.class);
//
//	}


    @Test
    public void 検索結果0件() throws Exception {
    	Article article = new Article();
    	article.setKeyword("aaaaaaaaaaaaaa");
    	List<Article> list = new ArrayList<>();

    	assertThat(artS.findByConditions(article), is(list));
    }

//    @Test
//    public void 検索結果1件() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("この記事のタイトルです");
//    	List<Article> list = new ArrayList<>();
//
//    	Article result1 = new Article();
//    	result1.setArticle_id(100003);
//    	result1.setUser_id(10002);
//    	result1.setName("F野太郎");
//    	result1.setArticle_title("この記事のタイトルです");
//    	result1.setArticle_main("test2");
//    	result1.setContribute_date("2018/07/04（水）10時33分");
//    	list.add(result1);
//
//    	assertThat(artS.findByConditions(article), is(list));
//    }
//
//    @Test
//    public void 検索結果2件以上() throws Exception {
//    	List<Article> list = new ArrayList<>();
//
//    	Article result1 = new Article();
//    	result1.setArticle_id(100003);
//    	result1.setUser_id(10002);
//    	result1.setName("F野太郎");
//    	result1.setArticle_title("この記事のタイトルです");
//    	result1.setArticle_main("test2");
//    	result1.setContribute_date("2018/07/04（水）10時33分");
//    	list.add(result1);
//
//    	Article result2 = new Article();
//    	result1.setArticle_id(100014);
//    	result1.setUser_id(111);
//    	result1.setName("aaa");
//    	result1.setArticle_title("test");
//    	result1.setArticle_main("main");
//    	result1.setContribute_date("2018/7");
//    	list.add(result2);
//
//    	Article result3 = new Article();
//    	result1.setArticle_id(100015);
//    	result1.setUser_id(112);
//    	result1.setName("bbb");
//    	result1.setArticle_title("title");
//    	result1.setArticle_main("test2");
//    	result1.setContribute_date("2018/7");
//    	list.add(result3);
//
//    	Article result4 = new Article();
//    	result1.setArticle_id(100016);
//    	result1.setUser_id(112);
//    	result1.setName("bbb");
//    	result1.setArticle_title("title");
//    	result1.setArticle_main("test2");
//    	result1.setContribute_date("2018/7");
//    	list.add(result4);
//
//    	Article article = new Article();
//    	article.setKeyword("test");
//
//    	assertThat(artS.findByConditions(article), is(list));
//    }

}
