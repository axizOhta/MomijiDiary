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

import fGroup.dto.Profile;
import fGroup.dto.Users;
import fGroup.service.ProfileService;
import fGroup.service.UserInsertService;
import fGroup.service.UserUpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class profileTest {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	ProfileService profileService;

	@Autowired
	private UserInsertService userinsertservice;

	@Autowired
	private UserUpService userS;

	@Before
	public void setUpProfile() {
		  jT.update("DELETE FROM profile");
		  jT.update("INSERT INTO profile (user_id,profile_image,name,sex,birthyear,birthmonth,birthday,hobby) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
				  ,100 , "", "佐藤", "男",1940, 7, 9,"ゲーム");
		  jT.update("INSERT INTO profile (user_id,profile_image,name,sex,birthyear,birthmonth,birthday,hobby) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
				  ,200 , "", "田中", "",1900, 11, 6, "旅行");
		  jT.update("INSERT INTO profile (user_id,profile_image,name) VALUES (?, ?, ?)"
				  ,300 ,"", "十六");
	}

    @Test
    public void プロフィール表示() throws Exception {

    	Profile profile = profileService.FindById(100);

    	assertThat(profile.getName(), is("佐藤"));
    }

    //NullPointer
    @Test
    public void プロフィール編集() throws Exception {
    	Profile profile = profileService.FindById(300);
    	assertNull(profile.getBirthyear());
    	assertNull(profile.getBirthmonth());
    	assertNull(profile.getBirthday());

    	Profile beforeProfile = profileService.FindById(300);
    	Profile afterProfile = new Profile();
    	afterProfile.setBirthyear(1940);
    	afterProfile.setBirthmonth(5);
    	afterProfile.setBirthday(12);

    	profileService.update(beforeProfile, afterProfile);
    	profile = profileService.FindById(300);

    	assertThat(profile.getBirthyear(), is(1940));
    	assertThat(profile.getBirthmonth(), is(5));
    	assertThat(profile.getBirthday(), is(12));
    }

    @Test
    public void プロフィール() throws Exception {
    	List<Profile> list = jT.query("SELECT * FROM profile WHERE user_id = ?", new BeanPropertyRowMapper<Profile>(Profile.class), 100);

    	assertThat(list.get(0).getName(), is("佐藤"));

    	Users users = new Users();
    	users.setUser_id(100);
    	users.setName("後藤");

    	userinsertservice.nameinsert(users);

    	assertThat(list.get(0).getName(), is("後藤"));

    }
}
