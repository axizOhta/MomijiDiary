package fGroup.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import fGroup.dto.Article;
import fGroup.service.ArtService;
import fGroup.service.impl.ArticleService;


@RunWith(SpringRunner.class)
@WebMvcTest(ArtService.class)
public class MomijiDiaryTest {

	@Autowired
	ArticleService artDao;

	@MockBean
	private ArticleService aDao;

	@Test
	public void ArtServiceの動作確認 () throws Exception {

		Article article = new Article();

		List<Article> list = new ArrayList<>();


		Article haru001 = new Article();

		haru001.setArticle_id(100003);
    	haru001.setName("");
    	haru001.setArticle_title("この記事のタイトルです");
    	haru001.setArticle_main("test2");
    	haru001.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru001);

    	assertThat(aDao.findByConditions(article), is(list));

    	Article haru002 = new Article();

		haru002.setArticle_id(100003);
    	haru002.setName("");
    	haru002.setArticle_title("この記事のタイトルです");
    	haru002.setArticle_main("test2");
    	haru002.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru002);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru003 = new Article();

		haru003.setArticle_id(null);
    	haru003.setName("F野太郎");
    	haru003.setArticle_title("この記事のタイトルです");
    	haru003.setArticle_main("test2");
    	haru003.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru003);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru004 = new Article();

		haru004.setArticle_id(100003);
    	haru004.setName(null);
    	haru004.setArticle_title("この記事のタイトルです");
    	haru004.setArticle_main("test2");
    	haru004.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru004);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru005 = new Article();

		haru005.setArticle_id(100003);
    	haru005.setName("F野太郎");
    	haru005.setArticle_title("");
    	haru005.setArticle_main("test2");
    	haru005.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru005);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru006 = new Article();

		haru006.setArticle_id(100003);
    	haru006.setName(null);
    	haru006.setArticle_title("この記事のタイトルです");
    	haru006.setArticle_main("test2");
    	haru006.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru006);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru007 = new Article();

		haru007.setArticle_id(100003);
    	haru007.setName("F野太郎");
    	haru007.setArticle_title(null);
    	haru007.setArticle_main("test2");
    	haru007.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru007);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru008 = new Article();

		haru008.setArticle_id(100003);
    	haru008.setName("F野太郎");
    	haru008.setArticle_title("この記事のタイトルです。");
    	haru008.setArticle_main("");
    	haru008.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru008);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru009 = new Article();

		haru009.setArticle_id(100003);
    	haru009.setName("F野太郎");
    	haru009.setArticle_title("この記事のタイトルです。");
    	haru009.setArticle_main(null);
    	haru009.setContribute_date("2018/07/04（水）10時33分");

    	list.add(haru009);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru010 = new Article();

		haru010.setArticle_id(100003);
    	haru010.setName("F野太郎");
    	haru010.setArticle_title("この記事のタイトルです。");
    	haru010.setArticle_main("test2");
    	haru010.setContribute_date("");

    	list.add(haru010);

    	assertThat(aDao.findByConditions(article), is(not(list)));

    	Article haru011 = new Article();

		haru011.setArticle_id(100003);
    	haru011.setName("F野太郎");
    	haru011.setArticle_title("この記事のタイトルです。");
    	haru011.setArticle_main("test2");
    	haru011.setContribute_date(null);

    	list.add(haru011);

    	assertThat(aDao.findByConditions(article), is(not(list)));




	}



	}


