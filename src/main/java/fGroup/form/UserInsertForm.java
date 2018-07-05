package fGroup.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInsertForm {

	private Integer user_id;

	@NotBlank(message="入力されていない項目があります。")
	@Size(min =4, max =10, message="ログインIDは4文字以上10文字以下で入力してください。")
	private String login_id;

	@NotBlank(message="入力されていない項目があります。")
	@Size(max =20, message="名前の文字数が多すぎます。")
	private String name;

	@NotBlank(message="入力されていない項目があります。")
	@Email(message="Eメール形式で入力してください。")
	private String email_address;

	@NotBlank(message="入力されていない項目があります。")
	@Size(min =4, max =10, message="パスワードは4文字以上10文字以下の半角英数字で入力してください。")
	private String password;

	private String entry_date;

	private String last_update_date;


	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer _user_id) {
		this.user_id =_user_id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String _login_id) {
		this.login_id=_login_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		this.name=_name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String _email_address) {
		this.email_address=_email_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String _password) {
		this.password=_password;
	}

	public String getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(String _entry_date) {
		this.entry_date=_entry_date;
	}

	public String getLast_update_date() {
		return last_update_date;
	}

	public void SetLast_update_date(String _last_update_date) {
		this.last_update_date=_last_update_date;
	}

}
