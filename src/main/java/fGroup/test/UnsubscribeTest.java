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
			  ,10001 , "100", "佐藤", "testタイトル", "axizaxiz", "2018/05","2018/05");
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date, last_update_date) VALUES (?, ?, ?, ?, ?, ?, ?)"
			  ,10002 , "200", "田中", "テストタイトル", "bxizbxiz", "2018/05","2018/05");
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date, last_update_date) VALUES (?, ?, ?, ?, ?, ?, ?)"
			  ,10003 , "300", "十六", "test", "cxizcxiz", "2018/05","2018/05");
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date, last_update_date) VALUES (?, ?, ?, ?, ?, ?, ?)"
			  ,10004 , "400", "non", "non", "dxizdxiz", "2018/05","2018/05");
	}



	@Test
    public void 退会テスト() throws Exception {
    	Users users = new Users();
    	users.setUser_id(10001);

    	userS.userDelete(10001);

    	List<Users> list = userS.find(users);
    	Users user = list.get(0);

    	assertTrue(user.isUnsubscribe_flug());
    }


}
