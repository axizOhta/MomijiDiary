package fGroup.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserUpForm {
	@NotNull
	private Integer id;
	private String newName;
	@NotNull
	@Email(message="Eメール形式で入力してください。")
	private String newEmail;
	@NotNull
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
