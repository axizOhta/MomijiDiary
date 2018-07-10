package fGroup.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import fGroup.service.UserInsertService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class signUpTest {

	@Autowired
	JdbcTemplate jT;

	@Autowired
	UserInsertService uIS;

	@Before
	public void setup() {
	  jT.update("DELETE FROM article");

	  jT.update("INSERT INTO users (user_id,login_id,name,email_address,password,entry_date,last_update_date,unsubscribe_flug)" +
	  		   "VALUES (?, ?, ?, ?, ?, ?)"
			  ,10001 ,"さとちゃん","佐藤太郎","sato@example.com","axiz","2018/07/01 (土) 12時00分","2018/07/01 (日) 12時00分",false);
	  jT.update("INSERT INTO users (user_id,login_id,name,email_address,password,entry_date,last_update_date,unsubscribe_flug)" +
			  "VALUES (?, ?, ?, ?, ?, ?)"
			  ,10002 , "ベル","鈴木花子","suzuki@example.com","bxiz","2018/07/01 (土) 12時05分","2018/07/01 (日) 12時05分",false);
	  jT.update("INSERT INTO users (user_id,login_id,name,email_address,password,entry_date,last_update_date,unsubscribe_flug)" +
			  "VALUES (?, ?, ?, ?, ?, ?)"
			  ,10003 , "セカンド","高橋次郎","takahashi@example.com","cxiz","2018/07/01 (土) 12時10分","2018/07/01 (日) 12時10分",false);
	}

}
