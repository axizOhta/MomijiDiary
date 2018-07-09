package fGroup.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fGroup.dto.Users;


@Repository
public class UserInsertDao {

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	public Users findLoginId(String login_id) {

		String logid = "SELECT * FROM users WHERE login_id = :login_id";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("login_id", login_id);

		List<Users> resultList = jdbcTemplate.query(logid, param, new BeanPropertyRowMapper<Users>(Users.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	public Users findEmail_address(String email_address) {

		String emil = "SELECT * FROM users WHERE email_address = :email_address";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("email_address", email_address);

		List<Users> resultList = jdbcTemplate.query(emil, param, new BeanPropertyRowMapper<Users>(Users.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	public int register(Users users) {

		String ins = "INSERT INTO users (login_id,name,email_address,password,entry_date,last_update_date,unsubscribe_flug) VALUES (:login_id,:name,:email_address,:password,:entry_date,:last_update_date,:unsubscribe_flug)";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("login_id", users.getLogin_id());
		param.addValue("name", users.getName());
		param.addValue("email_address", users.getEmail_address());
		param.addValue("password", users.getPassword());

		String date;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) HH時mm分");
		date = sdf.format(cal.getTime());
		param.addValue("entry_date",date );
		param.addValue("last_update_date",date );

		boolean unsubscribe = false;

		param.addValue("unsubscribe_flug", unsubscribe);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(ins, param, keyHolder, new String[] {"user_id"});

		return keyHolder.getKey().intValue();
	}

	public void nameinsert(Users users) {

		String pinsert ="INSERT INTO profile (user_id,profile_image,name,sex,birthyear,birthmonth,birthday,hobby,self_introduction) VALUES (:user_id,:profile_image,:name,:sex,:birthyear,:birthmonth,:birthday,:hobby,:self_introduction)";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("user_id", users.getUser_id());
		param.addValue("profile_image", "");
		param.addValue("name", users.getName());
		param.addValue("sex", "");
		param.addValue("birthyear", "");
		param.addValue("birthmonth", "");
		param.addValue("birthday", "");
		param.addValue("hobby", "");
		param.addValue("self_introduction", "");

		jdbcTemplate.update(pinsert, param);
	}

}
