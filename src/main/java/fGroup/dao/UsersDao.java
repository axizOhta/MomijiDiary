package fGroup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fGroup.dto.Users;

@Repository
public class UsersDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	public Users findByIdAndPassword(String id,String pass) {

		List<Users> list = jdbcTemplate.query
				("SELECT user_id, login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug"
						+ " FROM users "
						+ "WHERE login_id = ? AND password = ? AND unsubscribe_flug = false" ,
						new BeanPropertyRowMapper<Users>(Users.class), id, pass);
		if(list.size()==0) {
			return null;
		}
		return (Users) list.get(0);
	}

	public Users findByPass(String newpassword) {
		List<Users> list = jdbcTemplate.query
				("SELECT user_id, login_id, name, email_address, password, entry_date, last_update_date, unsubscribe_flug"
						+ " FROM users "
						+ "WHERE password = ?",
						new BeanPropertyRowMapper<Users>(Users.class), newpassword);
		if(list.size()==0) {
			return null;
		}
		return (Users) list.get(0);
	}

	public void Unsub(Integer user_id) {
		String sql = "UPDATE users SET unsubscribe_flug = true WHERE user_id=?";
		jdbcTemplate.update(sql, user_id);
	}

}
