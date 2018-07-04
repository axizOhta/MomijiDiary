package fGroup.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fGroup.dto.Admin;

@Repository
public class AdminDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	public Admin findByIdAndPassword(Integer id,String pass) {

		List<Admin> list = jdbcTemplate.query
				("SELECT admin_id, password FROM admin "
						+ "WHERE admin_id = ? AND password = ?",
						new BeanPropertyRowMapper<Admin>(Admin.class), id, pass);

		if(list.size()==0) {
			return null;
		}

		return (Admin) list.get(0);

	}
}
