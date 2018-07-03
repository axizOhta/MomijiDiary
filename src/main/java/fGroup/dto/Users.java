package fGroup.dto;

public class Users {

	private Integer user_id;
	private String login_id;
	private String name;
	private String email_address;
	private String password;
	private String entry_date;
	private String last_update_date;
	private boolean unsubscribe_flug;

	public Users() {
	}

	public Users(Integer user_id, String login_id, String name, String email_address,
				  String password, String entry_date, String last_update_date, boolean unsubscribe_flug) {
		this.user_id = user_id;
		this.login_id = login_id;
		this.name = name;
		this.email_address = email_address;
		this.password = password;
		this.entry_date = entry_date;
		this.last_update_date = last_update_date;
		this.unsubscribe_flug = unsubscribe_flug;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public String getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}

	public boolean isUnsubscribe_flug() {
		return unsubscribe_flug;
	}

	public void setUnsubscribe_flug(boolean unsubscribe_flug) {
		this.unsubscribe_flug = unsubscribe_flug;
	}

}
