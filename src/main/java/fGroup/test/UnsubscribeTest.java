package fGroup.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import fGroup.dto.Users;
import fGroup.service.UserUpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnsubscribeTest {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	private UserUpService userS;

	@Before
	public void setup() {
	  jT.update("DELETE FROM users");
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date, last_update_date) VALUES (?, ?, ?, ?, ?, ?, ?)"
			  ,10001 , 100, "佐藤", "testタイトル", "axizaxiz", "2018/05","2018/05");
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date, last_update_date) VALUES (?, ?, ?, ?, ?, ?, ?)"
			  ,10002 , 200, "田中", "テストタイトル", "bxizbxiz", "2018/05","2018/05");
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date, last_update_date) VALUES (?, ?, ?, ?, ?, ?, ?)"
			  ,10003 , 300, "十六", "test", "cxizcxiz", "2018/05","2018/05");
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date, last_update_date) VALUES (?, ?, ?, ?, ?, ?, ?)"
			  ,10004 , 400, "non", "non", "dxizdxiz", "2018/05","2018/05");
	}

//    @Test
//    public void パスワード空欄時() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("aaaaaaaaaaaaaa");
//
//    	userS.userDelete(null);
//
//
//    	assertThat ();
//    }

//    @Test
//    public void パスワード違う場合() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("aaaaaaaaaaaaaa");
//
//    	assertThat(artS.findByConditions(article).size(), is(0));
//    }
//
//    @Test
//    public void パスワード再入力不一致() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("aaaaaaaaaaaaaa");
//
//    	assertThat(artS.findByConditions(article).size(), is(0));
//    }
//
//    @Test
//    public void パスワードMAX桁数以上入力時() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("aaaaaaaaaaaaaa");
//
//    	assertThat(artS.findByConditions(article).size(), is(0));
//    }

	@Test
    public void 退会テスト() throws Exception {
    	Users users = new Users();
    	users.setUser_id(10001);

    	userS.userDelete(10001);

    	List<Users> list = userS.find(users);
    	Users user = list.get(0);

    	assertTrue(user.isUnsubscribe_flug());
    }

//    @Test
//    public void 退会後ログイン不可テスト() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("aaaaaaaaaaaaaa");
//
//    	assertThat(userS.findByConditions(article).size(), is(0));
//    }
//
//    @Test
//    public void 退会後管理者のユーザー一覧に表示されていない() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("aaaaaaaaaaaaaa");
//
//    	assertThat(artS.findByConditions(article).size(), is(0));
//    }
//
//    @Test
//    public void 大会後プロフィール等消えているか() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("aaaaaaaaaaaaaa");
//
//    	assertThat(artS.findByConditions(article).size(), is(0));
//    }
//
//    @Test
//    public void 途中でブラウザに戻ったときに退会処理がされていないか() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("aaaaaaaaaaaaaa");
//
//    	assertThat(artS.findByConditions(article).size(), is(0));
//    }



//    @Test
//    public void 検索結果1件() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("テストタイトル");
//
//    	List<Article> list = artS.findByConditions(article);
//    	Article art1 = list.get(0);
//
//    	assertThat(list.size(), is(1));
//    	assertThat(art1.getArticle_id(), is(10002));
//    	assertThat(art1.getUser_id(), is(200));
//    }
//
//    @Test
//    public void 検索結果2件以上() throws Exception {
//    	Article article = new Article();
//    	article.setKeyword("test");
//
//    	List<Article> list = artS.findByConditions(article);
//
//    	assertThat(list.size(), is(3));
//
//    	Article art1 = list.get(0);
//    	Article art2 = list.get(1);
//    	Article art3 = list.get(2);
//
//    	assertThat(art1.getArticle_id(), is(10001));
//    	assertThat(art1.getUser_id(), is(100));
//    	assertThat(art2.getArticle_id(), is(10002));
//    	assertThat(art2.getUser_id(), is(200));
//    	assertThat(art3.getArticle_id(), is(10003));
//    	assertThat(art3.getUser_id(), is(300));
//    }

}
