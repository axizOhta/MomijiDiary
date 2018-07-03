package fGroup.dto;

public class Profile {

	private Integer user_id;
	private String profile_image;
	private String name;
	private String sex;
	private Integer birthyear;
	private Integer birthmonth;
	private Integer birthday;
	private String hobby;
	private String self_introduction;

	public Profile(){
	}

	public Profile(Integer user_id, String profile_image, String name, String sex,Integer birthyear,
					Integer birthmonth, Integer birthday, String hobby, String self_introduction) {
		this.user_id = user_id;
		this.profile_image = profile_image;
		this.name = name;
		this.sex = sex;
		this.birthyear = birthyear;
		this.birthmonth = birthmonth;
		this.birthday = birthday;
		this.self_introduction = self_introduction;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(Integer birthyear) {
		this.birthyear = birthyear;
	}

	public Integer getBirthmonth() {
		return birthmonth;
	}

	public void setBirthmonth(Integer birthmonth) {
		this.birthmonth = birthmonth;
	}

	public Integer getBirthday() {
		return birthday;
	}

	public void setBirthday(Integer birthday) {
		this.birthday = birthday;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSelf_introduction() {
		return self_introduction;
	}

	public void setSelf_introduction(String self_introduction) {
		this.self_introduction = self_introduction;
	}

}

