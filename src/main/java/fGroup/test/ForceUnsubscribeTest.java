package fGroup.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import fGroup.dto.Users;
import fGroup.service.impl.PgUserUpService;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class ForceUnsubscribeTest {

		@Autowired
	    private JdbcTemplate jT;

		@Autowired
		private PgUserUpService uSer;

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
		public void 強制退会確認テスト() {

			Users users = new Users();

			users.setUser_id(10003);

			uSer.userDelete(10003);

			List<Users> list = jT.query
					("SELECT user_id, login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug"
							+ " FROM users "
							+ "WHERE user_id = ?" ,
							new BeanPropertyRowMapper<Users>(Users.class), 10003);

			assertTrue(list.get(0).isUnsubscribe_flug());
		}



	}
