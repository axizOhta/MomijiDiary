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

import fGroup.dao.AdminDao;
import fGroup.dao.UsersDao;
import fGroup.dto.Admin;
import fGroup.dto.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginLogoutTest {

	@Autowired
    private JdbcTemplate jT;

	//ServiceがないためDaoのテスト
	@Autowired
	UsersDao usersDao;

	@Autowired
	AdminDao adminDao;

	@Before
	public void setup() {
	  jT.update("DELETE FROM users");
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,100 , "ろぐいんID", "佐藤", "aaa@aaa.aaa", "aaa", "2018/05", "2018/05", false);
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,200 , "login", "田中", "bbb@bbb.bbb", "bbb", "2018/06", "2018/07", false);
	  jT.update("INSERT INTO users (user_id,login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ? ,?)"
			  ,300 , "aaaaa", "加藤", "ccc@ccc.ccc", "ccc", "2018/07", "2018/08", false);

	  jT.update("DELETE FROM admin");
	  jT.update("INSERT INTO admin (admin_id, password) VALUES (110, 'pass')");
	}

    @Test
     public void ユーザーログインOKパターン() throws Exception {
    	Users users = usersDao.findByIdAndPassword("ろぐいんID", "aaa");
    	assertThat(users.getUser_id(), is(100));
    }

    @Test
    public void ユーザーログインIDNGパターン() throws Exception {
   	Users users = usersDao.findByIdAndPassword("ろぐいん", "aaa");
   	assertNull(users);
   }

    @Test
    public void ユーザーログインpassNGパターン() throws Exception {
   	Users users = usersDao.findByIdAndPassword("ろぐいんID", "uuuu");
   	assertNull(users);
   }

    @Test
    public void ユーザーログインIDpassNGパターン() throws Exception {
   	Users users = usersDao.findByIdAndPassword("ID", "uuuu");
   	assertNull(users);
   }

    @Test
    public void 管理者ログインOKパターン() throws Exception {
    Admin ad = adminDao.findByIdAndPassword(110, "pass");
   	assertThat(ad.getAdmin_id(), is(110));
   }

    @Test
    public void 管理者ログインIDNGパターン() throws Exception {
    Admin ad = adminDao.findByIdAndPassword(1100, "pass");
   	assertNull(ad);
   }

    @Test
    public void 管理者ログインpassNGパターン() throws Exception {
    Admin ad = adminDao.findByIdAndPassword(110, "pass1");
   	assertNull(ad);
   }

    @Test
    public void 管理者ログインIDpassNGパターン() throws Exception {
    Admin ad = adminDao.findByIdAndPassword(1100, "pass1");
   	assertNull(ad);
   }

}
