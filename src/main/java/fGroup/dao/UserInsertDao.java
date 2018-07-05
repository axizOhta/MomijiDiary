package fGroup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

}
