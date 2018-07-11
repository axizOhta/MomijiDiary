package fGroup.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fGroup.dto.Profile;

@Repository
@Transactional
public class ProfileDao {

	@Autowired
	NamedParameterJdbcTemplate nPJT;

	public Profile FindById(Integer id) {

        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

        try {
            return nPJT.queryForObject(
                    "SELECT * FROM profile WHERE user_id = :id",
                    param,
                    new BeanPropertyRowMapper<Profile>(Profile.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	public void updateImage(Profile profile){

		 Integer id = profile.getUser_id();
		 String image = "/profile/images/"+profile.getProfile_image();

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("image", image);

		 nPJT.update("UPDATE profile SET profile_image = :image WHERE user_id= :id", param);
	 }

	public void updateName(Profile profile){

		 Integer id = profile.getUser_id();
		 String name = profile.getName();

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("name", name);

		 nPJT.update("UPDATE profile SET name = :name WHERE user_id= :id", param);
		 nPJT.update("UPDATE users SET name = :name WHERE user_id= :id", param);
	 }

	 public void updateSex(Profile profile){

		 Integer id = profile.getUser_id();
		 String sex = profile.getSex();

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("sex", sex);

		 nPJT.update("UPDATE profile SET sex = :sex WHERE user_id= :id", param);
	 }

	 public void updateBirthyear(Profile profile){

		 Integer id = profile.getUser_id();
		 Integer birthyear = profile.getBirthyear();

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("birthyear", birthyear);

		 nPJT.update("UPDATE profile SET birthyear = :birthyear WHERE user_id= :id", param);
	 }

	 public void updateBirthmonth(Profile profile){

		 Integer id = profile.getUser_id();
		 Integer birthmonth = profile.getBirthmonth();

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("birthmonth", birthmonth);

		 nPJT.update("UPDATE profile SET birthmonth = :birthmonth WHERE user_id= :id", param);
	 }

	 public void updateBirthday(Profile profile){

		 Integer id = profile.getUser_id();
		 Integer birthday = profile.getBirthday();

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("birthday", birthday);

		 nPJT.update("UPDATE profile SET birthday = :birthday WHERE user_id= :id", param);
	 }

	 public void updateHobby(Profile profile){

		 Integer id = profile.getUser_id();
		 String hobby = profile.getHobby();

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("hobby", hobby);

		 nPJT.update("UPDATE profile SET hobby = :hobby WHERE user_id= :id", param);
	 }

	 public void updateSelfIntroduction(Profile profile){

		 Integer id = profile.getUser_id();
		 String selfIntroduction = profile.getSelf_introduction();

		 SqlParameterSource param = new MapSqlParameterSource().addValue("id", id).addValue("selfIntroduction", selfIntroduction);

		 nPJT.update("UPDATE profile SET self_introduction = :selfIntroduction WHERE user_id= :id", param);
	 }

}
