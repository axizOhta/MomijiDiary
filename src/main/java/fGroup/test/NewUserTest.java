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

import fGroup.dto.Users;
import fGroup.service.UserInsertService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewUserTest {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	private UserInsertService userinsertservice;

	@Before
	public void setup() {
	  jT.update("DELETE FROM users");
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,100 , "ろぐいんID", "佐藤", "aaa@aaa.aaa", "aaa", "2018/05", "2018/05", false);
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,200 , "login", "田中", "bbb@bbb.bbb", "bbb", "2018/06", "2018/07", false);
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ? ,?)"
			  ,300 , "aaaaa", "加藤", "ccc@ccc.ccc", "ccc", "2018/07", "2018/08", false);
	  }

	@Test
    public void 既存ログインIDなし() throws Exception {
		Users u = userinsertservice.findLoginId("login3");
		assertNull(u);

	}

	@Test
    public void 既存ログインIDあり() throws Exception {
		Users u = userinsertservice.findLoginId("ろぐいんID");
		assertThat(u.getUser_id(), is(100));

	}


}
