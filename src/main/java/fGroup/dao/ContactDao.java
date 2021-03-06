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

import fGroup.dto.Contact;

@Repository
public class ContactDao {

	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	public int coninsert(Contact contact) {

		String coninsert = "INSERT INTO contact (email_address,user_id,contact_title,contact_message,contact_date) VALUES (:email_address,:user_id,:contact_title,:contact_message,:contact_date)";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("email_address",contact.getEmail_address());
		param.addValue("user_id", null);
		param.addValue("contact_title",contact.getContact_title() );
		param.addValue("contact_message",contact.getContact_message() );
		String date;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) HH時mm分");
		date = sdf.format(cal.getTime());
		param.addValue("contact_date",date );

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(coninsert, param, keyHolder, new String[] {"contact_id"});


		return keyHolder.getKey().intValue();
	}


	public int coninsertUser(Contact contact) {

		String coninsertUser = "INSERT INTO contact (email_address,user_id,contact_title,contact_message,contact_date) VALUES (:email_address,:user_id,:contact_title,:contact_message,:contact_date)";

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("email_address",contact.getEmail_address());
		param.addValue("user_id",contact.getUser_id());
		param.addValue("contact_title",contact.getContact_title() );
		param.addValue("contact_message",contact.getContact_message() );
		String date;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) HH時mm分");
		date = sdf.format(cal.getTime());
		param.addValue("contact_date",date );

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(coninsertUser, param, keyHolder, new String[] {"contact_id"});


		return keyHolder.getKey().intValue();
	}

	public List<Contact> contactall() {
		String contactall ="SELECT * FROM contact ORDER BY contact_id";

		List<Contact> resultList = jdbcTemplate.query(contactall,new BeanPropertyRowMapper<Contact>(Contact.class));

		return resultList;
	}

	public List<Contact> contactallUser(Integer user_id) {

		String contactuserall = "SELECT * FROM contact WHERE user_id = :user_id ORDER BY contact_id";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", user_id);

		List<Contact> resultList = jdbcTemplate.query(contactuserall,param,new BeanPropertyRowMapper<Contact>(Contact.class));

		return resultList;
	}
}
