package fGroup.test;

import static org.hamcrest.CoreMatchers.*;
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
public class UserInsertServiceTest {

	@Autowired
	PgUserUpService userU;

	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PgUserUpService uService;

    @Before
	public void setup() {
	  jdbcTemplate.update("DELETE FROM users");
	  jdbcTemplate.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date,last_update_date,unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10001 , "はるぴっぴ", "辻", "harupippi@au.au", "hrtj7923", "2018/7/10(火) 10時42分","2018/7/10(火) 10時42分",false);
	  jdbcTemplate.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date,last_update_date,unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10002 , "たちばなりえちゃん", "たちばなりえ", "riestandup@iketeruhearts", "riechan","2018/7/10(火) 10時42分","2018/7/10(火) 10時42分",false);
	  jdbcTemplate.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date,last_update_date,unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10003 ,"十六", "teatea", "tietie@teatea", "ooiocha","2018/7/10(火) 10時42分","2018/7/10(火) 10時42分",false);
	  jdbcTemplate.update("INSERT INTO users (user_id, login_id, name, email_address, password, entry_date,last_update_date,unsubscribe_flug) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
			  ,10004 ,"mamipippi", "mamika", "mamika@docomo.docomo", "mamikaa", "2018/7/10(火) 10時42分","2018/7/10(火) 10時42分",false);
	}

    @Test
    public void 更新() throws Exception {
    	Users users = new Users();

    	users.setUser_id(10001);
    	users.setName("はるぴっぴはるぴっぴ");
    	users.setEmail_address("harupippitj@au.au");
    	users.setPassword("hr7923tj");

    	uService.userUpdate(users);

    	List<Users> list = jdbcTemplate.query
				("SELECT user_id, login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug"
						+ " FROM users "
						+ "WHERE login_id = ?" ,
						new BeanPropertyRowMapper<Users>(Users.class), "はるぴっぴ");

    	Users user1 = list.get(0);



    	assertThat(list.size(), is(1));
    	assertThat(user1.getUser_id(), is(10001));
    	assertThat(user1.getName(), is("はるぴっぴはるぴっぴ"));
    	assertThat(user1.getEmail_address(), is("harupippitj@au.au"));
    	assertThat(user1.getPassword(), is("hr7923tj"));
    }

    //@Test
    //public void 検索結果1件() throws Exception {
//    	Users users = new Users();
//    	users.setEmail_address("harupippi@aaaaaa");
//
//    	List<Users> list = uService.userUpdate(users);
//    	Users user1 = list.get(0);
//
//    	assertThat(list.size(), is(1));
//    	assertThat(user1.getUser_id(), is(10002));
//    	assertThat(user1.getUser_id(), is("たちばなりえ"));
//    }
//
//    @Test
//    public void 検索結果2件以上() throws Exception {
//    	Users users = new Users();
//    	users.setPassword("ooiocha");
//
//    	List<Users> list = uService.userUpdate(users);
//
//    	assertThat(list.size(), is(3));
//
//    	Users user1 = list.get(0);
//    	Users user2 = list.get(1);
//    	Users user3 = list.get(2);
//
//    	assertThat(user1.getUser_id(), is(10001));
//    	assertThat(user1.getLogin_id(), is("はるぴっぴ"));
//    	assertThat(user2.getUser_id(), is(10002));
//    	assertThat(user2.getLogin_id(), is("たちばなりえ"));
//    	assertThat(user3.getUser_id(), is(10003));
//    	assertThat(user3.getLogin_id(), is("十六"));
//    }


	//@Test
	//public void PgUserUpdateServiceの動作確認01() throws Exception {

		//String ins = "INSERT INTO users (login_id,name,email_address,password,entry_date,last_update_date,unsubscribe_flug) VALUES ('はるぴっぴ','はるぴっぴはるぴっぴ','harupippi@au.au','hrtj7923',2018/07/04（水）10時33分,2018/07/04（水）10時33分,false)";

		//jdbcTemplate.update(ins);

		//List<Users> list = new ArrayList<>();

		//ケース01

		//Users afterUser = new Users();

		//afterUser.setUser_id(10001);

		//afterUser.setName();
		//afterUser.setEmail_address(form.getNewEmail());
		//afterUser.setPassword(form.getNewPassword());
		//Users users = PgUserUpService.userUpdate(afterUser);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

		//users.setName("はるぴっぴはるぴっぴは");
		//uService.userUpdate(user);

		//users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴは", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

	//}
		//ケース02

	//public void PgUserUpdateServiceの動作確認02() {
		//Users users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

		//users.setName("はるぴ");
		//uService.userUpdate(user);

		//users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴ", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

	//}

	//public void PgUserUpdateServiceの動作確認03() {
		//Users users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

		//users.setName("");
		//uService.userUpdate(user);

		//users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

	//}

	//public void PgUserUpdateServiceの動作確認04() {
		//Users users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

		//users.setName(null);
		//uService.userUpdate(user);

		//users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals(null, users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

	//}

	//public void PgUserUpdateServiceの動作確認05() {
		//Users users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

		//users.setEmail_address("harupippi");
		//uService.userUpdate(user);

		//users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("harupippi", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

	//}
	//public void PgUserUpdateServiceの動作確認06() {
		//Users users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

		//users.setEmail_address("");
		//uService.userUpdate(user);

		//users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

	//}

	//public void PgUserUpdateServiceの動作確認07() {
		//Users users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴ", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

		//users.setEmail_address(null);
		//uService.userUpdate(user);

		//users = PgUserUpService.find(10001);

		//assertEquals(Integer.valueOf(10001), users.getUser_id());
		//assertEquals("はるぴっぴはるぴっぴは", users.getName());
		//assertEquals("harupippi@au.au", users.getEmail_address());
		//assertEquals("hrtj7923", users.getPassword());

	//}

		//List<Users> list = new ArrayList<>();

		//Users haru001 = new Users();

		//haru001.setUser_id(10001);
		//haru001.setLogin_id("はるぴっぴ");
    	//haru001.setName("はるぴっぴはるぴっぴ");
    	//haru001.setEmail_address("harupippi@au.au");
    	//haru001.setPassword("hrtj7923");
    	//haru001.setEntry_date("2018/07/04（水）10時33分");
    	//haru001.setLast_update_date("2018/07/04（水）10時33分");
    	//haru001.setUnsubscribe_flug(false);

    	//list.add(haru001);

    	//Users afterUser = new Users();

    	//afterUser.setUser_id(10001);

		//afterUser.setName("はるぴっぴはるぴっぴ");
		//afterUser.setEmail_address("harupippi@au.au");
		//afterUser.setPassword("hrtj7923");

    	//assertThat(uService.userUpdate(afterUser), is(haru001));
//Users haru002 = new Users();

		//haru002.setUser_id(10001);
		//haru002.setLogin_id("はるぴっぴ");
    	//haru002.setName("はるぴっぴ");
    	//haru002.setEmail_address("harupippi@au.au");
    	////haru002.setPassword("hrtj7923");
    	//haru002.setEntry_date("2018/07/04（水）10時33分");
    	//haru002.setLast_update_date("2018/07/04（水）10時33分");
    	//haru002.setUnsubscribe_flug(false);

    	//list.add(haru002);

    	//assertThat(uDao.find(), is(not(list)));

		//Users haru003 = new Users();

		//haru003.setUser_id(10001);
		//haru003.setLogin_id("はるぴっぴ");
    	//haru003.setName("はるぴっぴはるぴっぴはるぴっぴ");
    	//haru003.setEmail_address("harupippi@au.au");
    	//haru003.setPassword("hrtj7923");
    	//haru003.setEntry_date("2018/07/04（水）10時33分");
    	///haru003.setLast_update_date("2018/07/04（水）10時33分");
    	//haru003.setUnsubscribe_flug(false);

    	//list.add(haru002);

    	//assertThat(uDao.findAll(), is(not(list)));

		///Users haru004 = new Users();

		//haru004.setUser_id(10001);
		//haru004.setLogin_id("はるぴっぴ");
    	//haru004.setName("はる");
    	//haru004.setEmail_address("harupippi@au.au");
    	//haru004.setPassword("hrtj7923");
    	//haru004.setEntry_date("2018/07/04（水）10時33分");
    	//haru004.setLast_update_date("2018/07/04（水）10時33分");
    	//haru004.setUnsubscribe_flug(false);

    	//list.add(haru004);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru005 = new Users();

		//haru005.setUser_id(10001);
		//haru005.setLogin_id("はるぴっぴ");
    	//haru005.setName("");
    	//haru005.setEmail_address("harupippi@au.au");
    	//haru005.setPassword("hrtj7923");
    	//haru005.setEntry_date("2018/07/04（水）10時33分");
    	//haru005.setLast_update_date("2018/07/04（水）10時33分");
    	//haru005.setUnsubscribe_flug(false);

    	//list.add(haru002);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru006 = new Users();

		//haru006.setUser_id(10001);
		//haru006.setLogin_id("はるぴっぴ");
    	//haru006.setName(null);
    	//haru006.setEmail_address("harupippi@au.au");
    	//haru006.setPassword("hrtj7923");
    	//haru006.setEntry_date("2018/07/04（水）10時33分");
    	//haru006.setLast_update_date("2018/07/04（水）10時33分");
    	//haru006.setUnsubscribe_flug(false);

    	//list.add(haru006);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru007 = new Users();

		//haru007.setUser_id(10001);
		//haru007.setLogin_id("はるぴっぴ");
    	//haru007.setName("はるぴっぴはるぴっぴ");
    	//haru007.setEmail_address("harupippi");
    	//haru007.setPassword("hrtj7923");
    	//haru007.setEntry_date("2018/07/04（水）10時33分");
    	//haru007.setLast_update_date("2018/07/04（水）10時33分");
    	//haru007.setUnsubscribe_flug(false);

    	//list.add(haru007);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru008 = new Users();

		//haru008.setUser_id(10001);
		//haru008.setLogin_id("はるぴっぴ");
    	///haru008.setName("はるぴっぴはるぴっぴ");
    	//haru008.setEmail_address("");
    	//haru008.setPassword("hrtj7923");
    	//haru008.setEntry_date("2018/07/04（水）10時33分");
    	//haru008.setLast_update_date("2018/07/04（水）10時33分");
    	//haru008.setUnsubscribe_flug(false);

    	//list.add(haru008);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru009 = new Users();

		//haru009.setUser_id(10001);
		//haru009.setLogin_id("はるぴっぴ");
    	//haru009.setName("はるぴっぴはるぴっぴ");
    	//haru009.setEmail_address(null);
    	//haru009.setPassword("hrtj7923");
    	//haru009.setEntry_date("2018/07/04（水）10時33分");
    	//haru009.setLast_update_date("2018/07/04（水）10時33分");
    	//haru009.setUnsubscribe_flug(false);

    	//list.add(haru009);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru010 = new Users();

		//haru010.setUser_id(10001);
		//haru010.setLogin_id("はるぴっぴ");
    	//haru010.setName("はるぴっぴはるぴっぴ");
    	//haru010.setEmail_address("harupippi@au.au");
    	//haru/010.setPassword("hrtj7923hrt");
    	//haru010.setEntry_date("2018/07/04（水）10時33分");
    	//haru010.setLast_update_date("2018/07/04（水）10時33分");
    	//haru010.setUnsubscribe_flug(false);

    	//list.add(haru010);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru011 = new Users();

		//haru011.setUser_id(10001);
		//haru011.setLogin_id("はるぴっぴ");
    	//haru011.setName("はるぴっぴはるぴっぴ");
    	//haru011.setEmail_address("harupippi@au.au");
    	//haru011.setPassword("hrt");
    	//haru011.setEntry_date("2018/07/04（水）10時33分");
    	//haru011.setLast_update_date("2018/07/04（水）10時33分");
    	//haru011.setUnsubscribe_flug(false);

    	//list.add(haru011);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru012 = new Users();

		//haru012.setUser_id(10001);
		//haru012.setLogin_id("はるぴっぴ");
    	//haru012.setName("はるぴっぴはるぴっぴ");
    	//haru012.setEmail_address("harupippi@au.au");
    	//haru012.setPassword("");
    	//haru012.setEntry_date("2018/07/04（水）10時33分");
    	//haru012.setLast_update_date("2018/07/04（水）10時33分");
    	//haru012.setUnsubscribe_flug(false);

    	//list.add(haru012);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru013 = new Users();

		//haru013.setUser_id(10001);
		//haru013.setLogin_id("はるぴっぴ");
    	//haru013.setName("はるぴっぴはるぴっぴ");
    	//haru013.setEmail_address("harupippi@au.au");
    	//haru013.setPassword(null);
    	//haru013.setEntry_date("2018/07/04（水）10時33分");
    	//haru013.setLast_update_date("2018/07/04（水）10時33分");
    	//haru013.setUnsubscribe_flug(false);

    	//list.add(haru013);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru014 = new Users();

		//haru014.setUser_id(10001);
		//haru014.setLogin_id("はるぴっぴ");
    	//haru014.setName("はるぴっぴはるぴっぴ");
    	//haru014.setEmail_address("harupippi@au.au");
    	//haru014.setPassword("hrtj7923");
    	//haru014.setEntry_date("");
    	//haru014.setLast_update_date("2018/07/04（水）10時33分");
    	//haru014.setUnsubscribe_flug(false);

    	//list.add(haru014);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru015 = new Users();

		//haru015.setUser_id(10001);
		//haru015.setLogin_id("はるぴっぴ");
    	//haru015.setName("はるぴっぴはるぴっぴ");
    	//haru015.setEmail_address("harupippi@au.au");
    	//haru015.setPassword("hrtj7923hrt");
    	//haru015.setEntry_date(null);
    	//haru015.setLast_update_date("2018/07/04（水）10時33分");
    	//haru015.setUnsubscribe_flug(false);

    	//list.add(haru015);

    	///assertThat(uDao.findAll(), is(not(list)));

		//Users haru016 = new Users();

		//haru016.setUser_id(10001);
		//haru016.setLogin_id("はるぴっぴ");
    	//haru016.setName("はるぴっぴはるぴっぴ");
    	//haru016.setEmail_address("harupippi@au.au");
    	/////haru016.setPassword("hrtj7923hrt");
    	//haru016.setEntry_date("2018/07/04（水）10時33分");
    	//haru016.setLast_update_date("");
    	///haru016.setUnsubscribe_flug(false);

    	//list.add(haru016);

    	//assertThat(uDao.findAll(), is(not(list)));

		//Users haru017 = new Users();

		//haru017.setUser_id(10001);
		//haru017.setLogin_id("はるぴっぴ");
    	//haru017.setName("はるぴっぴはるぴっぴ");
    	//haru017.setEmail_address("harupippi@au.au");
    	//haru017.setPassword("hrtj7923hrt");
    	//haru017.setEntry_date("2018/07/04（水）10時33分");
    	//haru017.setLast_update_date(null);
    	//haru017.setUnsubscribe_flug(false);

    	//list.add(haru017);

    	//assertThat(uDao.findAll(), is(not(list)));
	//}

}
