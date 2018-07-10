package fGroup.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fGroup.dao.IProfileDao;
import fGroup.dto.Profile;

@Repository
public class ProfileDao implements IProfileDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

//	@Override
//	public UserInfo findById(Integer id) {
//
//		String sql = "SELECT * FROM user_info WHERE user_id = :userId";
//		MapSqlParameterSource param = new MapSqlParameterSource();
//		param.addValue("userId", id);
//
//		List<UserInfo> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
//
//		return resultList.isEmpty() ? null : resultList.get(0);
//	}

	@Override
	public List<Profile> findByConditions(Integer userid) {

		List<String> condition = new ArrayList<String>();
		MapSqlParameterSource param = new MapSqlParameterSource();



		if(userid != null) {
			condition.add("userid = :userid");
			param.addValue("userid", "%" + userid + "%");
		}

		String sql = "SELECT * FROM profile WHERE profile = :userid";
		List<Profile> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Profile>(Profile.class));

		return resultList;
	}


	@Override
	public void update(Profile userid) {
		String sql = "UPDATE article SET sex = :sex, birthyear = :birthYear, birthmonth = :birthMonth, birthday = :birthDay, hobby = :hobby, self_introduction = :self_Introduction, WHERE user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("sex", userid.getSex());
		param.addValue("birthYear", userid.getBirthyear());
		param.addValue("birthMonth", userid.getBirthmonth());
		param.addValue("birthDay", userid.getBirthday());
		param.addValue("hobby", userid.getHobby());
		param.addValue("self_Introduction", userid.getSelf_introduction());
		param.addValue("userId", userid.getUser_id());

		jdbcTemplate.update(sql, param);
	}

}
