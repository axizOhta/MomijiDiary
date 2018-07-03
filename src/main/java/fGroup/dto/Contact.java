package fGroup.dto;

public class Contact {

	private Integer contact_id;
	private Integer user_id;
	private String email_address;
	private String contact_title;
	private String contact_message;
	private String contact_date;

	public Contact() {
	}

	public Contact(Integer contact_id, Integer user_id, String email_address,
					String contact_title, String contact_message, String contact_date) {
		this.contact_id = contact_id;
		this.user_id = user_id;
		this.email_address = email_address;
		this.contact_title = contact_title;
		this.contact_message = contact_message;
		this.contact_date = contact_date;
	}

	public Integer getContact_id() {
		return contact_id;
	}

	public void setContact_id(Integer contact_id) {
		this.contact_id = contact_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getContact_title() {
		return contact_title;
	}

	public void setContact_title(String contact_title) {
		this.contact_title = contact_title;
	}

	public String getContact_message() {
		return contact_message;
	}

	public void setContact_message(String contact_message) {
		this.contact_message = contact_message;
	}

	public String getContact_date() {
		return contact_date;
	}

	public void setContact_date(String contact_date) {
		this.contact_date = contact_date;
	}
}
