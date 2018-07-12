package fGroup.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserUpForm {
	private Integer id;
	@NotBlank(message="入力されていない項目があります。")
	@Size(max =20, message="名前の文字数が多すぎます。20文字以下で入力してください。")
	private String newName;
	@NotBlank(message="入力されていない項目があります。")
	@Email(message="Eメール形式で入力してください。")
	private String newEmail;
	@NotBlank(message="入力されていない項目があります。")
	@Size(min =4, max =10, message="パスワードは4文字以上10文字以下の半角英数字で入力してください。")
	private String newPassword;

	private String confirmNewPassword;

	private String prevName;

	private String prevEmail;

	private String prevPassword;

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public String getPrevName() {
		return prevName;
	}

	public void setPrevName(String prevName) {
		this.prevName = prevName;
	}

	public String getPrevEmail() {
		return prevEmail;
	}

	public void setPrevEmail(String prevEmail) {
		this.prevEmail = prevEmail;
	}

	public String getPrevPassword() {
		return prevPassword;
	}

	public void setPrevPassword(String prevPassword) {
		this.prevPassword = prevPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public boolean hasRequiredError() {
		return (newName == null || newName.isEmpty())
				|| (newEmail == null || newEmail.isEmpty())
				|| (newPassword == null || newPassword.isEmpty());
	}


}
