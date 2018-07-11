package fGroup.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DateModifiedDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	public void dateModified(Integer user_id) {

		String date;

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) HH時mm分");
		date = sdf.format(cal.getTime());

		String sql = "UPDATE users SET last_update_date ='" + date + "' WHERE user_id=?";
		jdbcTemplate.update(sql, user_id);
	}

}
