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

import fGroup.dto.Users;
import fGroup.service.impl.PgUserUpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSelectTest {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	private PgUserUpService userupservice;

    @Before
	public void setup() {
	  jT.update("DELETE FROM users");
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date,last_update_date,unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10001 , "はるぴっぴ", "辻", "harupippi@au.au", "hrtj7923", "2018/7/10(火) 10時42分","2018/7/10(火) 10時42分",false);
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date,last_update_date,unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10002 , "たちばなりえちゃん", "たちばなりえ", "riestandup@iketeruhearts", "riechan","2018/7/10(火) 10時42分","2018/7/10(火) 10時42分",false);
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date,last_update_date,unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10003 ,"十六", "teatea", "tietie@teatea", "ooiocha","2018/7/10(火) 10時42分","2018/7/10(火) 10時42分",false);
	  jT.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date,last_update_date,unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10004 ,"mamipippi", "mamika", "mamika@docomo.docomo", "mamikaa", "2018/7/10(火) 10時42分","2018/7/10(火) 10時42分",false);
	}



	@Test
    public void ユーザー一覧表示() throws Exception {

				Users users = new Users();

				List<Users> list = userupservice.find(users);

				assertThat(list.size(), is(4));

				Users user1 = list.get(0);
		    	Users user2 = list.get(1);
		    	Users user3 = list.get(2);
		    	Users user4 = list.get(3);

		    	assertThat(user1.getUser_id(), is(10001));
		    	assertThat(user1.getLogin_id(), is("はるぴっぴ"));
		    	assertThat(user2.getUser_id(), is(10002));
		    	assertThat(user2.getLogin_id(), is("たちばなりえちゃん"));
		    	assertThat(user3.getUser_id(), is(10003));
		    	assertThat(user3.getLogin_id(), is("十六"));
		    	assertThat(user4.getUser_id(), is(10004));
		    	assertThat(user4.getLogin_id(), is("mamipippi"));
	}



}
