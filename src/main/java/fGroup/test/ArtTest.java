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
import fGroup.service.ArtService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtTest {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	private ArtService artS;

	@Before
	public void setup() {
	  jT.update("DELETE FROM article");
	  jT.update("INSERT INTO article (article_id, user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?, ?)"
			  ,10001 , 100, "佐藤", "testタイトル", "テスト本文", "2018/05");
	  jT.update("INSERT INTO article (article_id, user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?, ?)"
			  ,10002 , 100, "佐藤", "テストタイトル", "test本文", "2018/06");
	  jT.update("INSERT INTO article (article_id, user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?, ?)"
			  ,10003 , 300, "十六", "test", "test本文", "2018/05");
	  jT.update("INSERT INTO article (article_id, user_id, name, article_title, article_main, contribute_date) VALUES (?, ?, ?, ?, ?, ?)"
			  ,10004 , 400, "non", "non", "non", "2018/05");
	}

	@Before
	public void UsersSetup() {
	  jT.update("DELETE FROM users");
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,100 , "ろぐいんID", "佐藤", "aaa@aaa.aaa", "aaa", "2018/05", "2018/05", false);
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,200 , "login", "田中", "bbb@bbb.bbb", "bbb", "2018/06", "2018/07", false);
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ? ,?)"
			  ,300 , "aaaaa", "加藤", "ccc@ccc.ccc", "ccc", "2018/07", "2018/08", true);
	  }

    @Test
    public void 記事表示OK() throws Exception {
    	Article art = artS.selectArt(10002);

    	assertThat(art.getArticle_title(), is("テストタイトル"));
    	assertThat(art.getArticle_main(), is("test本文"));
    }

    @Test
    public void 記事表示NG() throws Exception {
    	Article art = artS.selectArt(10005);
    	assertNull(art);
    }

    @Test
    public void 会員確認_非退会() throws Exception {
    	assertThat(artS.existUser(100), is(true));
    }

    @Test
    public void 会員確認_退会() throws Exception {
    	assertThat(artS.existUser(300), is(false));
    }

    @Test
    public void ユーザー記事一覧表示0件() throws Exception {
    	List <Article> list = artS.getAllArt(200);

    	assertThat(list.size(), is(0));
    }

    @Test
    public void ユーザー記事一覧表示1件() throws Exception {
    	List <Article> list = artS.getAllArt(300);

    	assertThat(list.size(), is(1));
    	assertThat(list.get(0).getArticle_title(), is("test"));
    }

    @Test
    public void ユーザー記事一覧表示2件() throws Exception {
    	List <Article> list = artS.getAllArt(100);

    	assertThat(list.size(), is(2));
    	assertThat(list.get(0).getArticle_id(), is(10002));
    	assertThat(list.get(0).getArticle_title(), is("テストタイトル"));
    	assertThat(list.get(1).getArticle_id(), is(10001));
    	assertThat(list.get(1).getArticle_title(), is("testタイトル"));

    }

    @Test
    public void 最新記事ID取得() throws Exception {
    	assertThat(artS.lastId(), is(10004));
    }

    @Test
    public void 記事投稿() throws Exception {
    	 artS.insert("titleT", "day", "mainT", 100, "佐藤", "", "", "", "");
    	 Article art = artS.selectArt(artS.lastId());

    	 assertThat(art.getArticle_title(), is("titleT"));
    	 assertThat(art.getArticle_main(), is("mainT"));

    }

    @Test
    public void 記事編集() throws Exception {
    	artS.update(10001, "editTitle", "editMain");
    	Article art = artS.selectArt(10001);

    	 assertThat(art.getArticle_title(), is("editTitle"));
    	 assertThat(art.getArticle_main(), is("editMain"));

    }

    @Test
    public void 記事削除() throws Exception {
    	artS.delete(10001);
    	Article art = artS.selectArt(10001);

    	assertNull(art);
    }


}
