package fGroup.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ProfileForm implements Serializable{

	private MultipartFile profile_image;
	private String name;
	private String sex;
	private Integer birthyear;
	private Integer birthmonth;
	private Integer birthday;
	private String hobby;
	private String self_introduction;

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
