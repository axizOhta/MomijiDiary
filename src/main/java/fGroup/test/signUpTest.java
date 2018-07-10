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

import fGroup.dao.UsersDao;
import fGroup.dto.Users;
import fGroup.service.UserInsertService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class signUpTest {

	@Autowired
	JdbcTemplate jT;

	@Autowired
	UserInsertService uIS;

	@Autowired
	UsersDao uD;

	@Before
	public void setup() {
	  jT.update("DELETE FROM users");

	  jT.update("INSERT INTO users (user_id,login_id,name,email_address,password,entry_date,last_update_date,unsubscribe_flug)" +
	  		   "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10001 ,"さとちゃん","佐藤太郎","sato@example.com","axiz","2018/07/01 (土) 12時00分","2018/07/01 (日) 12時00分",false);
	  jT.update("INSERT INTO users (user_id,login_id,name,email_address,password,entry_date,last_update_date,unsubscribe_flug)" +
			  "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10002 , "ベル","鈴木花子","suzuki@example.com","bxiz","2018/07/01 (土) 12時05分","2018/07/01 (日) 12時05分",false);
	  jT.update("INSERT INTO users (user_id,login_id,name,email_address,password,entry_date,last_update_date,unsubscribe_flug)" +
			  "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10003 , "セカンド","高橋次郎","takahashi@example.com","cxiz","2018/07/01 (土) 12時10分","2018/07/01 (日) 12時10分",false);
	}

	@Test
    public void 既存ログインIDなし() throws Exception {
		Users u = uIS.findLoginId("login3");
		assertNull(u);

	}

	@Test
    public void 既存ログインIDあり() throws Exception {
		Users user01 = uIS.findLoginId("さとちゃん");
		Users user02 = uIS.findLoginId("ベル");
		Users user03 = uIS.findLoginId("セカンド");

		assertThat(user01.getUser_id(), is(10001));
		assertThat(user02.getUser_id(), is(10002));
		assertThat(user03.getUser_id(), is(10003));

	}

	@Test
	public void メールアドレスなし() throws Exception{
		Users u = uIS.findEmail_address("ieigaye-i@example.com");
		assertNull(u);

	}

	@Test
	public void メールアドレスあり() throws Exception{
		Users user01 = uIS.findEmail_address("sato@example.com");
		Users user02 = uIS.findEmail_address("suzuki@example.com");
		Users user03 = uIS.findEmail_address("takahashi@example.com");

		assertThat(user01.getUser_id(), is(10001));
		assertThat(user02.getUser_id(), is(10002));
		assertThat(user03.getUser_id(), is(10003));

	}

	@Test
	public void ユーザー登録成功() throws Exception{
		Users newUser = new Users(10004,"イシクシィ","石塚大志","ishizuka@example.com","dxiz","2018/07/01 (土) 12時15分","2018/07/01 (日) 12時15分",false);

		int u = uIS.insert(newUser);

		Users user = uD.findByIdAndPassword("イシクシィ", "dxiz");

		assertThat(user.getUser_id(), is(10004));


	}

}
