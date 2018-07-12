package fGroup.form;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class ProfileFormConfirm {

	private MultipartFile profile_image;
	private String name;
	private String sex;

	private String birthyear;
	private String birthmonth;
	private String birthday;

	private String hobby;

	@Size(max = 300,message="自己紹介の文字数が多すぎます。300文字以内で入力してください。")
	private String self_introduction;

	private Integer user_id;

	public MultipartFile getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(MultipartFile profile_image) {
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
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}
	public String getBirthmonth() {
		return birthmonth;
	}
	public void setBirthmonth(String birthmonth) {
		this.birthmonth = birthmonth;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
